package hu.training.exception;

public class MyUncheckedException extends RuntimeException {

	private static final long serialVersionUID = 7415925940530838927L;

	public MyUncheckedException() {
		super();
	}

	public MyUncheckedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MyUncheckedException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyUncheckedException(String message) {
		super(message);
	}

	public MyUncheckedException(Throwable cause) {
		super(cause);
	}

}
