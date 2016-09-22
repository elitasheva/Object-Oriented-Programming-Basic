package problem5.models;

import problem5.exceptions.InvalidArtistNameException;
import problem5.exceptions.InvalidSongMinutesException;
import problem5.exceptions.InvalidSongNameException;
import problem5.exceptions.InvalidSongSecondsException;

public class Song {

    private String artistName;
    private String songName;
    private int minutes;
    private int seconds;

    public Song(String artistName, String songName, int minutes, int seconds) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    public void setArtistName(String artistName) {
        if (artistName.length() < 3 || artistName.length() > 20){
            throw new InvalidArtistNameException();
        }
        this.artistName = artistName;
    }

    public void setSongName(String songName) {
        if (songName.length() < 3 || songName.length() > 30){
            throw new InvalidSongNameException();
        }
        this.songName = songName;
    }

    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 14){
            throw new InvalidSongMinutesException();
        }
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59){
            throw new InvalidSongSecondsException();
        }
        this.seconds = seconds;
    }
}
