package app.block5crudvalidation.Persona.Domain.Exceptions;

public class UnprocessableEntityException extends RuntimeException {
    public UnprocessableEntityException(String message) {
        super(message);
    }
}
