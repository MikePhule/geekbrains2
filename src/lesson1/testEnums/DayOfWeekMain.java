package lesson1.testEnums;

public class DayOfWeekMain {
    public static void main(String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.FRIDAY));
    }

    private static String getWorkingHours(DayOfWeek day) {
        int hoursToWork;
        hoursToWork = (5 - day.ordinal()) * 8;
        if (hoursToWork <= 0) {
            return "Сегодня выходной";
        } else {
            return "" + hoursToWork;
        }
    }
}
