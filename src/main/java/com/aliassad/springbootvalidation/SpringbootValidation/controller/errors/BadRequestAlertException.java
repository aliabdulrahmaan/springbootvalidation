package com.aliassad.springbootvalidation.SpringbootValidation.controller.errors;

public class BadRequestAlertException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String entityName;

    private final String errorKey;
    private final String defaultMessage;


    public BadRequestAlertException(String defaultMessage, String entityName, String errorKey) {

        this.entityName = entityName;
        this.errorKey = errorKey;
        this.defaultMessage = defaultMessage;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getErrorKey() {
        return errorKey;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

}

