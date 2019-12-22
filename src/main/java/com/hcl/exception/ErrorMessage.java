package com.hcl.exception;

public class ErrorMessage extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public ErrorMessage(String message) {
		super(message);
	}
}
