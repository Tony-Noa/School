package org.example.schoolclass.exeptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Not found");
    }
}
