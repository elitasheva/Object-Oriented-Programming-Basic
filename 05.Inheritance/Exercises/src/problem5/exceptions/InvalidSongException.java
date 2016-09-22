package problem5.exceptions;

public abstract class InvalidSongException extends InvalidException{

    private static final String DEFAULT = "Invalid song.";

    public InvalidSongException() {
                super(DEFAULT);
    }
}
