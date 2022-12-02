package it.prova.dottore.web.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.dottore.dto.DottoreDTO;
import it.prova.dottore.model.Dottore;
import it.prova.dottore.service.DottoreService;
import it.prova.dottore.web.api.exception.IdNotNullForInsertException;
import it.prova.dottore.web.api.exception.NotFoundException;


@RestController
@RequestMapping("/api/dottore")
public class DottoreController {

	@Autowired
	private DottoreService service;

	@GetMapping
	public List<DottoreDTO> listAll(){
		return DottoreDTO.createDottoreDTOListFromModelList(service.findAll());
	}
	
	@GetMapping("/{id}")
	public DottoreDTO findById(@PathVariable(name = "id", required = true) Long id) {
		Dottore result = service.findById(id);
		
		if (result == null)
		throw new NotFoundException("Dottore non trovato con id: " + id);
		
		return DottoreDTO.buildDottoreDTOFromModel(result);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DottoreDTO createNew(@RequestBody DottoreDTO input) {
		if (input.getId() != null)
			throw new IdNotNullForInsertException("Non è ammesso fornire un id per la creazione");

		return DottoreDTO.buildDottoreDTOFromModel(service.inserisciNuovo(input.buildDottoreModel()));
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public DottoreDTO update(@Valid @RequestBody DottoreDTO dottore, @PathVariable(required = true) Long id) {
		Dottore dottoreDaAggiornare = service.findById(id);

		if (dottoreDaAggiornare == null)
			throw new NotFoundException("Dottore not found con id: " + id);

		dottoreDaAggiornare.setId(id);
		Dottore pazienteAggiornato = service.aggiorna(dottore.buildDottoreModel());
		return DottoreDTO.buildDottoreDTOFromModel(pazienteAggiornato);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(name = "id", required = true) Long id) {
		Dottore dottore = service.findById(id);

		if (dottore == null)
			throw new NotFoundException("Dottore non trovato con id: " + id);

		service.rimuovi(id);
	}	
	
	
	//DEVI AGGIUNGE I METODI: /assegnaPaziente

}
