package problem5.exceptions;


public class InvalidSongNameException extends InvalidException{

    private static final String DEFAULT = "Song name should be between 3 and 30 symbols.";

    public InvalidSongNameException() {
        super(DEFAULT);
    }
}
