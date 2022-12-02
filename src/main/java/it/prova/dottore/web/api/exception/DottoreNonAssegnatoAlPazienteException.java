package it.prova.dottore.web.api.exception;

public class DottoreNonAssegnatoAlPazienteException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public DottoreNonAssegnatoAlPazienteException(String message) {
			super(message);
		}

}
