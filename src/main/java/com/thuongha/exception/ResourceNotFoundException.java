package com.thuongha.exception;

import com.thuongha.constant.ErrorConstants;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;


public class ResourceNotFoundException extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(ErrorConstants.NOT_FOUND, message, Status.NOT_FOUND);
    }
}