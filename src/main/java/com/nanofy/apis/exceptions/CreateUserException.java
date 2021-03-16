package com.nanofy.apis.exceptions;

public class CreateUserException extends AssertionError{

	private static final long serialVersionUID = 1L;
	final String errorMessage;

    public CreateUserException(String errors){
        super(errors);
        this.errorMessage = errors;
    }
    public CreateUserException(String errors, Throwable cause){
        super(errors, cause);
        this.errorMessage = errors;
    }

}
