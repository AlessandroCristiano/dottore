package it.prova.dottore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.dottore.model.Dottore;

public interface DottoreRepository extends CrudRepository<Dottore, Long>{
	
	@Query("select d from Dottore d where d.codiceDottore = :codiceDottore")
	public List<Dottore> findByCodiceDottore(String codiceDottore);

}
