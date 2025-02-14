package br.fatec.api.exception;

// Exceção para falhas gerais
public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }
}

