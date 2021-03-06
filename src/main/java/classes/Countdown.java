package classes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Countdown {

    public static long countMinutes(LocalDateTime moment) {

        long minutes = 0;
        String day = moment.getDayOfWeek().name();
        LocalTime hour = moment.toLocalTime();
        LocalDate date = moment.toLocalDate();
        LocalDateTime endDate = LocalDateTime.of(2018, 11, 5, 12, 0 );

        LocalTime[] endDates = new LocalTime[12];
        endDates[0] = LocalTime.of(8, 15);
        endDates[1] = LocalTime.of(9, 45);
        endDates[2] = LocalTime.of(10, 0);
        endDates[3] = LocalTime.of(11, 30);
        endDates[4] = LocalTime.of(11, 45);
        endDates[5] = LocalTime.of(13, 15);
        endDates[6] = LocalTime.of(13, 45);
        endDates[7] = LocalTime.of(15, 15);
        endDates[8] = LocalTime.of(15, 30);
        endDates[9] = LocalTime.of(17, 0);
        endDates[10] = LocalTime.of(17, 15);
        endDates[11] = LocalTime.of(18, 45);

        int timeIndex = 0;
        for (int i=0; i<=11; i++) {
            if (moment.toLocalTime().isBefore(endDates[i])) {
                timeIndex = i;
                break;
            }
        }

        if (day.equals("FRIDAY")) {
            if (hour.isAfter(endDates[11])) {
                endDate = LocalDateTime.of(date.plusDays(3), endDates[0]);
            }
            else {
                endDate = LocalDateTime.of(date, endDates[timeIndex]);
            }
        }
        else if (day.equals("SATURDAY")) {
            endDate = LocalDateTime.of(date.plusDays(2), endDates[0]);
        }
        else if (day.equals("SUNDAY")) {
            endDate = LocalDateTime.of(date.plusDays(1), endDates[0]);
        }
        else if (day.equals("MONDAY") || day.equals("TUESDAY") || day.equals("WEDNESDAY")
                || day.equals("THURSDAY"))
        {
            if (hour.isAfter(endDates[11])) {
                endDate = LocalDateTime.of(date.plusDays(1), endDates[0]);
            }
            else {
                endDate = LocalDateTime.of(date, endDates[timeIndex]);
            }
        }

        minutes = Duration.between(moment, endDate).toMinutes();
        return minutes;

    }

    public static boolean isClass(LocalDateTime moment) {
        LocalTime[] endDates = new LocalTime[12];
        endDates[0] = LocalTime.of(8, 15);
        endDates[1] = LocalTime.of(9, 45);
        endDates[2] = LocalTime.of(10, 0);
        endDates[3] = LocalTime.of(11, 30);
        endDates[4] = LocalTime.of(11, 45);
        endDates[5] = LocalTime.of(13, 15);
        endDates[6] = LocalTime.of(13, 45);
        endDates[7] = LocalTime.of(15, 15);
        endDates[8] = LocalTime.of(15, 30);
        endDates[9] = LocalTime.of(17, 0);
        endDates[10] = LocalTime.of(17, 15);
        endDates[11] = LocalTime.of(18, 45);

        int timeIndex = 0;
        for (int i=0; i<=11; i++) {
            if (moment.toLocalTime().isBefore(endDates[i])) {
                timeIndex = i;
                break;
            }
        }
        String day = moment.getDayOfWeek().name();

        if(day.equals("SATURDAY") || day.equals("SUNDAY")) {
            return false;
        }
        else if (timeIndex %2 == 0) {
            return false;
        }
        else {
            return true;
        }
    }
}
