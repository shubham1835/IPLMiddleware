package com.ipl.middleware.exception;

import lombok.Getter;

@Getter
public class ResponseEntityException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final ErrorMessageConstant errorMessageConstant;

    public ResponseEntityException(ErrorMessageConstant errorMessageConstant) {
        super();
        this.errorMessageConstant = errorMessageConstant;
    }

}
