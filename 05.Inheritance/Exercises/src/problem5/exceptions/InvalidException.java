package problem5.exceptions;

public abstract class InvalidException extends RuntimeException{

    protected InvalidException(String message) {
        super(message);
    }
}
