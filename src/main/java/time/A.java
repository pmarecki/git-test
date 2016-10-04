package Wykopki;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class A {
    public static void main(String[] args) {
        Instant a = Instant.now();
        System.out.println(a);
        System.out.println(ZonedDateTime.ofInstant(a, ZoneId.systemDefault()));
        System.out.println(ZonedDateTime.ofInstant(a, ZoneId.of("Europe/London")));
//        ZoneId.getAvailableZoneIds().forEach(System.out::println);
        ZonedDateTime zdt = ZonedDateTime.ofInstant(a, ZoneId.of("Europe/London"));
        System.out.println(DateTimeFormatter.ofPattern("yyyy/MMM/dd HH:mm:ss").format(zdt));

        Instant later = a.plus(5, ChronoUnit.DAYS);
        System.out.println(later);
    }
}
