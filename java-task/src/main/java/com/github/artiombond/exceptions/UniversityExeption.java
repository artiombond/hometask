package com.github.artiombond.exceptions;

public class UniversityExeption extends Exception {
    public UniversityExeption() {
    }

    public UniversityExeption(String message) {
        super(message);
    }

    public UniversityExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public UniversityExeption(Throwable cause) {
        super(cause);
    }
}
