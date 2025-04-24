package models.enums.environment;

public class Time {
    private static int year;
    private static Season Season;
    private static Month month;
    private static Weekday weekday;
    private static int hour;
    private static int minute;
    private static int second;
    public static Time currentTime;

    public static void increaseTime(Time increasedAmount) {

    }

    public static void cheatAdvanceTime(int hourIncrease, Time currentTime) {
    }

    public static void cheatAdvanceDate(int dayIncrease, Time currentTime) {
    }

    public static int getYear() {
        return year;
    }

    public static Season getSeason() {
        return Season;
    }

    public static Month getMonth() {
        return month;
    }

    public static Weekday getWeekday() {
        return weekday;
    }

    public static int getHour() {
        return hour;
    }

    public static int getMinute() {
        return minute;
    }

    public static int getSecond() {
        return second;
    }

    public static void nextYear() {

    }

    public static void nextSeason(){

    }
    public static void nextMonth(){

    }

    public static void nextWeekday(){

    }


}
