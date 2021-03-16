package com.nanofy.apis.exceptions;

public class UpdateUserException extends AssertionError{

	private static final long serialVersionUID = 1L;
	final String errorMessage;

    public UpdateUserException(String errors){
        super(errors);
        this.errorMessage = errors;
    }
    public UpdateUserException(String errors, Throwable cause){
        super(errors, cause);
        this.errorMessage = errors;
    }

}
