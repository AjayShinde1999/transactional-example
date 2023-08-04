package com.transactionalexample.exception;

public class InsufficientAmountException extends RuntimeException{

    public InsufficientAmountException(String meassage){
        super(meassage);
    }
}
