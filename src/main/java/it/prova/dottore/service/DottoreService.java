package it.prova.dottore.service;

import java.util.List;

import it.prova.dottore.model.Dottore;

public interface DottoreService {
	
	List<Dottore> findAll();

	Dottore findById(Long id);

	Dottore findByCodice(String codice);

	Dottore inserisciNuovo(Dottore input);

	Dottore aggiorna(Dottore input);

	void rimuovi(Long id);

}
