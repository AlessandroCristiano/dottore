package it.prova.dottore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dottore")
public class Dottore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cognome;
	private String codiceDottore;
	private String codFiscalePazienteAttualmenteInVisita;
	private Boolean inVisita;
	private Boolean inServizio;
	
	
	public Dottore() {
		super();
	}

	public Dottore(Long id, String nome, String cognome, String codiceDottore,
			String codFiscalePazienteAttualmenteInVisita, Boolean inVisita, Boolean inServizio) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDottore = codiceDottore;
		this.codFiscalePazienteAttualmenteInVisita = codFiscalePazienteAttualmenteInVisita;
		this.inVisita = inVisita;
		this.inServizio = inServizio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceDottore() {
		return codiceDottore;
	}

	public void setCodiceDottore(String codiceDottore) {
		this.codiceDottore = codiceDottore;
	}

	public String getCodFiscalePazienteAttualmenteInVisita() {
		return codFiscalePazienteAttualmenteInVisita;
	}

	public void setCodFiscalePazienteAttualmenteInVisita(String codFiscalePazienteAttualmenteInVisita) {
		this.codFiscalePazienteAttualmenteInVisita = codFiscalePazienteAttualmenteInVisita;
	}

	public Boolean getInVisita() {
		return inVisita;
	}

	public void setInVisita(Boolean inVisita) {
		this.inVisita = inVisita;
	}

	public Boolean getInServizio() {
		return inServizio;
	}

	public void setInServizio(Boolean inServizio) {
		this.inServizio = inServizio;
	}
	
}
