package problem10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainEntryPoint {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String first = reader.readLine();
            String second = reader.readLine();

            DateModifier dateModifier = new DateModifier();
            dateModifier.getDifferenceBetweenDates(first, second);
            System.out.println(dateModifier.getDifference());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

class DateModifier {

    private long difference;

    public long getDifference() {
        return difference;
    }

    public void getDifferenceBetweenDates(String date1, String date2) {

//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy MM dd");
//        date1 = date1.replaceAll("[\\s]+", " ");
//        date2 = date2.replace("[\\s]+", " ");
//        try {
//            Date firstDate = formatter.parse(date1);
//            Date secondDate = formatter.parse(date2);
//            long diff = Math.abs(firstDate.getTime() - secondDate.getTime());
//            this.difference = TimeUnit.MILLISECONDS.toDays(diff);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        String[] firstDateParams = date1.split("[\\s]+");
        int year1 = Integer.parseInt(firstDateParams[0]);
        int month1 = Integer.parseInt(firstDateParams[1]);
        int day1 = Integer.parseInt(firstDateParams[2]);

        String[] secondDateParams = date2.split("[\\s]+");
        int year2 = Integer.parseInt(secondDateParams[0]);
        int month2 = Integer.parseInt(secondDateParams[1]);
        int day2 = Integer.parseInt(secondDateParams[2]);

        Calendar firstCalendar = Calendar.getInstance();
        Calendar secondCalendar = Calendar.getInstance();

        firstCalendar.set(year1,month1,day1);
        secondCalendar.set(year2,month2,day2);

        long milisec1 = firstCalendar.getTimeInMillis();
        long milisec2 = secondCalendar.getTimeInMillis();
        long diff = Math.abs(milisec2 - milisec1);

        long diffDays = diff / (24 * 60 * 60 * 1000);
        this.difference = diffDays;

    }
}
