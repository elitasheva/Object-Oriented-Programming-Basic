package problem5.exceptions;


public class InvalidArtistNameException extends InvalidException{

    private static final String DEFAULT = "Artist name should be between 3 and 20 symbols.";

    public InvalidArtistNameException() {
                super(DEFAULT);
    }
}
