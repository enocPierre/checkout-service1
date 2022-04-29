package com.mscompra.mscompra.service.exceptions;

public class EntityNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
