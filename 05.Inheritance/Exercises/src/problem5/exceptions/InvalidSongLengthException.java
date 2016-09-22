package problem5.exceptions;

public class InvalidSongLengthException extends InvalidException{

    private static final String DEFAULT = "Invalid song length.";

    public InvalidSongLengthException() {
                super(DEFAULT);
    }

    public InvalidSongLengthException(String message) {
        super(message);
    }
}
