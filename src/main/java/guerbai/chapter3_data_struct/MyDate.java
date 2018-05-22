package guerbai.chapter3_data_struct;

import java.util.HashMap;
import java.util.Map;

import static guerbai.util.Print.print;
import static guerbai.util.Print.printnb;
import static java.lang.System.currentTimeMillis;

public class MyDate {

    int year;
    int month;
    int day;

    private static Map<Integer, Integer> daysOfMonth = new HashMap<>();
    static {
        daysOfMonth.put(1, 31);
        daysOfMonth.put(2, 28);
        daysOfMonth.put(3, 31);
        daysOfMonth.put(4, 30);
        daysOfMonth.put(5, 31);
        daysOfMonth.put(6, 30);
        daysOfMonth.put(7, 31);
        daysOfMonth.put(8, 31);
        daysOfMonth.put(9, 30);
        daysOfMonth.put(10, 31);
        daysOfMonth.put(11, 30);
        daysOfMonth.put(12, 31);
    }

    MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static boolean isLeapYear(int year) {
        if (year%400==0) {
            return true;
        }
        if (year%100==0) {
            return false;
        }
        if (year%4==0) {
            return true;
        }
        return false;
    }

    private int getNumberOfThisYear() {
        if (month==1) {
            return day;
        }
        int leapYearAddDay = isLeapYear(year)? 1: 0;
        int number = 0;
        for (int i=0; i<month; i++) {
            number += daysOfMonth.get(i+1);
        }
        number += leapYearAddDay;
        number -= month==2 ? daysOfMonth.get(month)+leapYearAddDay - day : daysOfMonth.get(month)-day;
        return number;
    }

    private boolean after(MyDate date2) {
        if (year > date2.year) {
            return true;
        }
        if (year < date2.year) {
            return false;
        }
        if (month > date2.month) {
            return true;
        }
        if (month < date2.month) {
            return false;
        }
        if (day > date2.day) {
            return true;
        }
        return false;
    }

    // date1与date2均为YYYY-MM-DD表示的日期.
    public int deltaDays(MyDate date) {
        // 此处处理使date1在date2之后.
        if (date.after(this)) {
            return date.deltaDays(this);
        }
        int deltaYear = year - date.year;
        int dayNumberOfDate1 = getNumberOfThisYear();
        int dayNumberOfDate2 = date.getNumberOfThisYear();
        int numberOfLeapYears = 0;
        for (int i=0; i<deltaYear; i++) {
            if (isLeapYear(date.year+i)) {
                numberOfLeapYears++;
            }
        }
        return deltaYear*365 + numberOfLeapYears + dayNumberOfDate1 - dayNumberOfDate2;
    }

    public int getWeekDay() {
        // 需要一个确切的日期以及该日期是星期几，使用今天，2018-05-22，星期二.
        // 注意，周日使用0表示.
        MyDate today = new MyDate(2018, 5, 22);
        int deltaDays = today.deltaDays(this);
        if (this.after(today)) {
            return (2 + deltaDays%7) % 7;
        }
        return (2 + 7 - deltaDays%7) % 7;
    }

    public void getCalendar() {
        print(month+"月:");
        print("日 一 二 三 四 五 六");
        int daysOfThisMonth = daysOfMonth.get(month);
        if (month==2 && isLeapYear(year)) {
            daysOfThisMonth++;
        }
        MyDate firstDayOfThisMonth = new MyDate(year, month, 1);
        int weekday = firstDayOfThisMonth.getWeekDay();
        int lineIndex = 0;
        for (int i=0; i<weekday; i++) {
            printnb("   ");
            lineIndex++;
        }
        for (int d=0; d<daysOfThisMonth; d++) {
            printnb(d+1);
            printnb(lineIndex==6? '\n': d<9 ? "  ": " ");
            lineIndex = (lineIndex+1) % 7;
        }
    }

    public static void main(String[] args) {
        long startAt = currentTimeMillis();

        MyDate date1 = new MyDate(2000, 3, 25);
        MyDate date2 = new MyDate(2005, 1, 23);
        MyDate date3 = new MyDate(1002, 2, 21);
        print(date2.deltaDays(date1));
        print(date1.deltaDays(date3));
        print(date1.getWeekDay());
        print(date2.getWeekDay());
        print(date3.getWeekDay());

        MyDate thatday = new MyDate(2018, 5, 1);
        thatday.getCalendar();

        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + 's');
    }
}
