package com.haruatari.task38.excetions;

public class BaseException extends Exception {
    public final String message;

    public BaseException(String message) {
        this.message = message;
    }
}
