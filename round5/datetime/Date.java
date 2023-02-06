import java.util.ArrayList;



public class Date {
    private int day;
    private int month;
    private int year;
    final static ArrayList<Integer> daysInMonth = new ArrayList<Integer>(){{
        add(31);
        add(28);
        add(31);
        add(30);
        add(31);
        add(30);
        add(31);
        add(31);
        add(30);
        add(31);
        add(30);
        add(31);
    }};
    public Date(int year, int month, int day) throws DateException {
        if (year < 0 || month < 1 || month > 12 || day < 1 || day > daysInMonth.get(month - 1)) {
            throw new DateException(String.format("Illegal date %02d.%02d.%04d", day, month, year));
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }

    public String toString(){
        return String.format("%02d.%02d.%04d", day, month, year);
    }
}