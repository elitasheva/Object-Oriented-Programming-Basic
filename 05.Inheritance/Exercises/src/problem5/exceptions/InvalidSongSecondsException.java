package problem5.exceptions;

public class InvalidSongSecondsException extends InvalidSongLengthException{

    private static final String DEFAULT = "Song seconds should be between 0 and 59.";

    public InvalidSongSecondsException() {
        super(DEFAULT);
    }
}
