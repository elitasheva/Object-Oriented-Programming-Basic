package problem5;

import problem5.exceptions.InvalidException;
import problem5.exceptions.InvalidSongLengthException;
import problem5.models.Song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            List<Song> listOfSongs = new ArrayList<>();

            int hours = 0;
            int minutes = 0;
            int seconds = 0;

            int count = Integer.parseInt(reader.readLine());
            for (int i = 0; i < count; i++) {

                String[] input = reader.readLine().split(";");
                String artistName = input[0];
                String songName = input[1];
                String[] time = input[2].split(":");
                int min = 0;
                int sec = 0;
                try {
                    min = Integer.parseInt(time[0]);
                    sec = Integer.parseInt(time[1]);

                    try {

                        Song song = new Song(artistName, songName, min, sec);
                        listOfSongs.add(song);
                        System.out.println("Song added.");

                        seconds += sec;
                        if (seconds >= 60) {
                            seconds -= 60;
                            minutes += 1;
                        }
                        minutes += min;
                        if (minutes >= 60) {
                            minutes -= 60;
                            hours += 1;
                        }

                    } catch (InvalidException ex) {
                        System.out.println(ex.getMessage());
                    }

                } catch (NumberFormatException ex) {

                    System.out.println("Invalid song length.");

                }


            }

            System.out.println("Songs added: " + listOfSongs.size());
            System.out.printf("Playlist length: %dh %dm %ds%n", hours, minutes, seconds);

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
