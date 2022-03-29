package test;

import java.util.Calendar;

public enum Year {
    ADULT_YEAR(Calendar.getInstance().get(Calendar.YEAR) - 20),
    MINOR_YEAR(Calendar.getInstance().get(Calendar.YEAR) - 16);

    private final int year;

    Year(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}
