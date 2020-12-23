package com.github.artiombond.threads;

public class NoPlacesException extends Exception{
    public NoPlacesException() {
    }

    public NoPlacesException(String message) {
        super(message);
    }

    public NoPlacesException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPlacesException(Throwable cause) {
        super(cause);
    }
}
