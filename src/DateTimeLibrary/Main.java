package DateTimeLibrary;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Set;

/*
    Java.time -> package for date and time in java. (from java 8 onwards)
        before java 8, java.util package used to hold the date and time classes now these classes are deprecated.

    How java stores a Date?
        ans: date in java is stored in the from of a long number. This long number holds the number os milliseconds
        passed since 1 Jan 1970.

        Java assumes that 1900 is the start year which means it calculates year passed since 1900 whenever we ask it for years passed.

        System.currentTimeMillis() returns no of milliseconds passed. Once no of ms one calculated, we can calculate minutes, seconds, and year passed.


        // Date class in java
        Date d = new Date();

        we can also use constructors provided by the Date class.

        // issues with legacy date and Calendar classes
            * mutable
            * confusing
            * limited(Zone, different)

       // java - 8
       * Local Date - represents a date without a time zone.
       * Local Time - represents a time without a date or time zone.
       * Local DateTime - represents a date & time without a time zone.
       * Zoned DateTime - represents a date, and time with a time zone.
       * Instant - represents an instantaneous point on the timeline, typically used for machine timestamps.
       * Duration - represents a duration of time between two points in time
       * Period - represents a period of time between two dates.
       * DateTimeFormatter - formats and parses dates and times.



 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(System.currentTimeMillis());
        // seconds
        System.out.println(System.currentTimeMillis()/1000);
        // minutes
        System.out.println(System.currentTimeMillis()/1000/3600);
        // day
        System.out.println(System.currentTimeMillis()/1000/3600/24);
        // year
        System.out.println(System.currentTimeMillis()/1000/3600/24/365);


        // Date class deprecated
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        System.out.println(date.getDate());


        // java 8 - LocalDate
        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalDate customDate = LocalDate.of(1990, 2, 7);
        System.out.println(customDate);

        int dayOfMonth = now.getDayOfMonth();
        int month = now.getMonthValue();
        Month month1 = now.getMonth();
        int year = now.getYear();
        System.out.println(dayOfMonth);
        System.out.println(month);
        System.out.println(year);

        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        LocalDate pastDate = today.minusMonths(10);
        System.out.println(yesterday);
        System.out.println(pastDate);

        System.out.println(today.isAfter(yesterday));
        System.out.println(today.isBefore(yesterday));

        // java 8 - LocalTime
        LocalTime time = LocalTime.now();
        System.out.println(time);
        LocalTime customTime = LocalTime.of(14,30,40);
        System.out.println(customTime);

        String timeInString = "10:10:30";
        LocalTime parseTime = LocalTime.parse(timeInString);
        System.out.println(parseTime);

        LocalTime beforeOneHour = time.minusHours(1);
        System.out.println(beforeOneHour);

        System.out.println(time.isBefore(beforeOneHour));
        System.out.println(time.isAfter(beforeOneHour));

        // java 8 - LocalDateTime
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        LocalDateTime customDateTime = LocalDateTime.of(1990, 2, 7,2,2,1);
        System.out.println(customDateTime);

        LocalDateTime parseDateTime = LocalDateTime.parse("1990-02-07T02:02:01");
        System.out.println(parseDateTime);

        // java 8 - ZoneDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.getZone());

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);

        ZonedDateTime customZonedDateTime = ZonedDateTime.of(2000,12,1,14,2,30,30, ZoneId.of("Asia/Aden"));
        System.out.println(customZonedDateTime);

        System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Dhaka")));
        System.out.println(ZonedDateTime.now(ZoneId.of("Europe/Monaco")));


        // java 8 - Instant

        long currentTimeMillis = System.currentTimeMillis();  // millisecond
        System.out.println(currentTimeMillis);

        Instant instant = Instant.now();    // nanosecond
        System.out.println(instant);
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.atZone(ZoneId.of("Asia/Dhaka")));

        // java 8 - Duration - use seconds, minutes, hour
        Instant start = Instant.now();
        Thread.sleep(1000);
        Instant end = Instant.now();
        Duration d1 = Duration.between(start, end);
        Duration d2 = Duration.of(1, ChronoUnit.MILLIS);
        System.out.println(d1);
        System.out.println(d2);

        int d3 = d1.compareTo(d2);
        System.out.println(d3);

        // java 8 - period - use day, month, year

        LocalDate localDateNow = LocalDate.now();
        LocalDate localDateThen = LocalDate.of(1990, 2, 2);
        Period period = Period.between(localDateNow, localDateThen);
        System.out.println(period);

        // java 8 - DateTimeFormatter
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = LocalDateTime.parse("2024-04-07T21:40:44.86938900");
        System.out.println(localDateTime1);

        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String format = localDateTime.format(myFormatter);
        System.out.println(format);

        String cdate = "25/04/2020";
        LocalDate parse = LocalDate.parse(cdate, myFormatter);
        System.out.println(parse);


    }
}
