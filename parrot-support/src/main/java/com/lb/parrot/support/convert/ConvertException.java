package com.lb.parrot.support.convert;

public class ConvertException extends Exception {

	private static final long serialVersionUID = -8488972950030663342L;

	public ConvertException(String message, Throwable e) {
		super(message, e);
	}

	public ConvertException(Throwable e) {
		super(e);
	}

	public ConvertException(String message) {
		super(message);
	}

}
