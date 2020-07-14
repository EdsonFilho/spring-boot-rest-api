package br.com.eacf.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Long id) {
        super("Could not find " + id);
    }
}
