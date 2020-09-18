package com.diayan.ICD10RESTProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Code not found")
public class CodeNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public CodeNotFoundException() {

    }

    public CodeNotFoundException(String message) {
        super(message);
    }
}
