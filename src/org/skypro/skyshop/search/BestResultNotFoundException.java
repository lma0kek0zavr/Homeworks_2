package org.skypro.skyshop.search;

public class BestResultNotFoundException extends Exception {
    public BestResultNotFoundException() { super(); }
    public BestResultNotFoundException(String message) { super(message); }
    public BestResultNotFoundException(Throwable cause) { super(cause); }
}
