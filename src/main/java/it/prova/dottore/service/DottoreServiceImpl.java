package it.prova.dottore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.dottore.model.Dottore;
import it.prova.dottore.repository.DottoreRepository;

@Service
@Transactional
public class DottoreServiceImpl implements DottoreService{
	
	@Autowired
	private DottoreRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Dottore> findAll() {
		return (List<Dottore>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Dottore findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Dottore findByCodice(String codice) {
		return repository.findByCodiceDottore(codice).stream().findFirst().orElse(null);
	}

	@Override
	public Dottore inserisciNuovo(Dottore input) {
		return repository.save(input);
	}

	@Override
	public Dottore aggiorna(Dottore input) {
		return repository.save(input);
	}

	@Override
	public void rimuovi(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public void impostaInVisita(Dottore dottore, String codiceFiscalePaziente) {
		dottore.setInVisita(true);
		dottore.setCodFiscalePazienteAttualmenteInVisita(codiceFiscalePaziente);
		repository.save(dottore);
	}

	@Override
	public void terminaVisita(Dottore dottore) {
		dottore.setCodFiscalePazienteAttualmenteInVisita(null);
		dottore.setInVisita(false);
		repository.save(dottore);
		
	}
}
