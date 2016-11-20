package com.lb.parrot.support.context.exception;

public class ContextException extends RuntimeException {

	private static final long serialVersionUID = -2182593817210367215L;

	public ContextException(String message) {
		super(message);
	}

	public ContextException(Throwable e) {
		super(e);
	}

	public ContextException(String message, Throwable e) {
		super(message, e);
	}
}
