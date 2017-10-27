package com.carservice.carservice.Exceptions;

public class AlreadySameException extends Exception {

    public AlreadySameException(String msg, Throwable t) {
        super(msg, t);
    }

    public AlreadySameException(String msg) {
        super(msg);
    }
}
