package ru.sewaiper.smokehouse.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

public class SmokehouseTestUtils {
    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

    public static long getRandomNumber(long min, long max) {
        if(min > max) throw new IllegalArgumentException();
        return ThreadLocalRandom.current().nextLong(min, max+1);
    }

    public static String getRandomString(int size) {
        return getRandomString(size, false);
    }

    public static String getRandomString(int size, boolean up) {
        if(size < 0) throw new IllegalArgumentException();
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<size; i++) {
            if(i==0 && up) builder.append((char) getRandomNumber(65, 90));
            else builder.append((char) getRandomNumber(97, 122));
        }

        return builder.toString();
    }

    public static String getRandomNumberString(int size) {
        if(size < 0) throw new IllegalArgumentException();
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<size; i++) {
            builder.append((char) getRandomNumber(48, 57));
        }

        return builder.toString();
    }

    public static LocalDate getRandomDate() {
        return getRandomDate(LocalDate.of(2010, 1, 1),
                LocalDate.of(2022, 1, 1));
    }

    public static LocalDate getRandomDate(LocalDate min, LocalDate max) {
        return LocalDate.ofEpochDay(getRandomNumber(min.toEpochDay(), max.toEpochDay()));
    }

    public static LocalTime getRandomTime() {
        return LocalTime.of((int) getRandomNumber(0, 23), (int) getRandomNumber(0, 59));
    }

    public static LocalTime getRandomTime(LocalTime min, LocalTime max) {
        int hour = (int) getRandomNumber(min.getHour(), max.getHour());
        int minute = (int) getRandomNumber(min.getMinute(), max.getMinute());
        return LocalTime.of(hour, minute);
    }
}
