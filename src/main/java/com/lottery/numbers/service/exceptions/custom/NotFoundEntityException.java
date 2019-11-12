package com.lottery.numbers.service.exceptions.custom;

public class NotFoundEntityException extends RuntimeException {

    public NotFoundEntityException(Class classObject) {
        super(classObject.getSimpleName() + " was not found");
    }
}
