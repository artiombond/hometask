package com.github.artiombond.exceptions;

public class MarkExeption extends Exception {

    public MarkExeption() {
    }

    public MarkExeption(String message) {
        super(message);
    }

    public MarkExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public MarkExeption(Throwable cause) {
        super(cause);
    }
}
