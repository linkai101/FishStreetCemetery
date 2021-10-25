package wu.linkai;

import java.util.*;

class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    private static Map<String, Integer> MONTHS = new HashMap<String, Integer>() {{
        put("jan", 1);
        put("feb", 2);
        put("mar", 3);
        put("apr", 4);
        put("may", 5);
        put("jun", 6);
        put("jul", 7);
        put("aug", 8);
        put("sep", 9);
        put("oct", 10);
        put("nov", 11);
        put("dec", 12);
    }};

    public Date(int month, int day, int year) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Date(String month, int day, int year) {
        this.year = year;
        this.month = MONTHS.get(month.trim().toLowerCase());
        this.day = day;
    }

    public int getYear() { return year; }
    public int getMonth() { return month; }
    public int getDay() { return day; }

    public String format() {
        return String.format("%s/%s/%s", month, day, year);
    }

    public int compareTo(Date date) {
        if (this.year < date.getYear()) return -1;
        else if (this.year > date.getYear()) return 1;
        else if (this.month < date.getMonth()) return -1;
        else if (this.month > date.getMonth()) return 1;
        else if (this.day < date.getDay()) return -1;
        else if (this.day > date.getDay()) return 1;
        return 0;
    }
}
