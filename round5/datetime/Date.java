public class Date {
    private int day;
    private int month;
    private int year;
    public Date(int year, int month, int day) throws DateException {
        if (year < 0 || month < 1 || month > 12 || day < 1 || day > 31) {
            throw new DateException("Illegal time " + day + "." + month + "." + year);
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
        return  day + "." + month + "." + year;
    }
}