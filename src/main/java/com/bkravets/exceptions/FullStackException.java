package com.bkravets.exceptions;

public class FullStackException extends RuntimeException{

    public FullStackException() {
        super("Stack is already full");
    }
}
