package it.prova.dottore.web.api.exception;

public class DottoreImpegnatoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DottoreImpegnatoException(String message) {
		super(message);
	}
}
