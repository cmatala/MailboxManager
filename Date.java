public class Date {
    // variable initialisation
    private int year;
    private int month;
    private int day;

    // constructor

    Date(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //Getters Methods

    public int getYear(){
        return year;
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    // Setters Methods


    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return day + "-" + month + "-" + year;
    }


}

