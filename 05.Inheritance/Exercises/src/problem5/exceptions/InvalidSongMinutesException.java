package problem5.exceptions;

public class InvalidSongMinutesException extends InvalidSongLengthException{


    private static final String DEFAULT = "Song minutes should be between 0 and 14.";

    public InvalidSongMinutesException() {
        super(DEFAULT);
    }
}
