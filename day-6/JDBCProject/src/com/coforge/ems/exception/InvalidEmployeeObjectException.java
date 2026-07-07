package com.coforge.ems.exception;

// This custom exception is thrown when employee data is invalid.
public class InvalidEmployeeObjectException extends Exception {
    public InvalidEmployeeObjectException(String message) {
        super(message);
    }
}
