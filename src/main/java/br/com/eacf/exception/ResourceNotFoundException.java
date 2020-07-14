package br.com.eacf.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Long id) {
        super("Unable to find entity with id: " + id);
    }
}
