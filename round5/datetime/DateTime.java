public class DateTime extends Date {
    private int hour;
    private int minute;
    private int second;
    public DateTime(int year, int month, int day, int hour, int minute, int second) throws DateException{
        super(year, month, day);
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59) {
            throw new DateException(String.format("Illegal time %02d:%02d:%02d", hour, minute, second));
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour(){
        return hour;
    }
    public int getMinute(){
        return minute;
    }
    public int getSecond(){
        return second;
    }

    public String toString(){
        return String.format("%s %02d:%02d:%02d", super.toString(), hour, minute, second);
    }
}