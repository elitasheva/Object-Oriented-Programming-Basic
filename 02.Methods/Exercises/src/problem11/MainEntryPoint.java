package problem11;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainEntryPoint {

    public static void main(String[] args) throws InterruptedException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        TimeStamp time1 = new TimeStamp();

        System.out.println(dateFormat.format(time1.getDate()));


        Thread.sleep(4000);
        TimeStamp time2 = new TimeStamp();

        System.out.println(dateFormat.format(time2.getDate()));
    }
}

class TimeStamp {

    private Date date;

    public TimeStamp() {

        this.date = getCurrentDate();
    }

    private Date getCurrentDate() {

        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }

    public Date getDate() {
        return date;
    }
}
