package dataoffice;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class dynamicTime {
    String myTime;
    public String dynamicTime() {
        Thread clock = new Thread() {
            @Override
            public void run() {
                for (;;) {
                    Calendar cal = new GregorianCalendar();
                    int yr = cal.get(Calendar.YEAR);
                    int mon = cal.get(Calendar.MONTH) + 1;
                    int dy = cal.get(Calendar.DATE);
                    int hr = cal.get(Calendar.HOUR_OF_DAY);
                    int min = cal.get(Calendar.MINUTE);
                    int sec = cal.get(Calendar.SECOND);
                    String year = Integer.toString(yr);
                    String month = Integer.toString(mon);
                    String day = Integer.toString(dy);
                    String hour = Integer.toString(hr);
                    String minute = Integer.toString(min);
                    String second = Integer.toString(sec);
                    if (mon < 10) {
                        month = "0".concat(month);
                    }
                    if (dy < 10) {
                        day = "0".concat(day);
                    }
                    if (hr < 10) {
                        hour = "0".concat(hour);
                    }
                    if (min < 10) {
                        minute = "0".concat(minute);
                    }
                    if (sec < 10) {
                        second = "0".concat(second);
                    }
                    myTime = "Date " + day + "-" + (month) + "-" + year + "    Time " + hour + ":" + (minute) + ":" + second;
                }
            }
        };
        clock.start();
    return myTime;
}
}