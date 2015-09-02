public class SmartDate{
    private final int day;
    private final int month;
    private final int year;
    
    public SmartDate(int m, int d, int y){
        if((m >=1 && m <=12) && 
           (d >= 1 && d <= 31) && y > 1800){
            day = d;
            month = m;
            year = y;
        }
        else {
            throw new RuntimeException("Illegal Date entry");
        }
    }
    
    public int day(){
        return day;
    }
    public int month(){
        return month;
    }
    public int year(){
        return year;
    }
    public String toString(){
        return month() + "/" + day() + "/" + year();
    }
    
    public String dayOfTheWeek(){
        int a = (int)Math.floor((14 - this.month) / 12);
        int y = this.year - a;
        int m = this.month + 12 * a - 2;
        int weekDay = ( this.day + y + y/4 - y/100 + y/400 + (31 * m)/12 )%7;
        switch(weekDay){
            case 0: return "Sunday";
            case 1: return "Monday";
            case 2: return "Tuesday";
            case 3: return "Wednesday";
            case 4: return "Thursday";
            case 5: return "Friday";
            case 6: return "Saturday";
        }
        return "";
    }
    
    public boolean equals(Object x)
    {
        if(this == x) return true;
        if(x == null) return false;
        if(this.getClass() != x.getClass()) return false;
        
        SmartDate that = (SmartDate)x;
        if(this.month != that.month) return false;
        if(this.day != that.day) return false;
        if(this.year != that.year) return false;
        
        return true;
    }
    
    public static void main(String[] args){
        SmartDate a = new SmartDate(6,12,1988);
        SmartDate b = new SmartDate(4,12,2015);
        System.out.println(a.dayOfTheWeek());
        System.out.println(b.dayOfTheWeek());
        System.out.println("Both the dates are same ? " + a.equals(b));
    }
}

/*
 * http://codereview.stackexchange.com/questions/48938/output-day-of-the-week-from-given-date/
 C:\Users\ngunti\algs4\FundamentalsOfProgramming\DataAbstraction>javac-algs4 SmartDate.java
 C:\Users\ngunti\algs4\FundamentalsOfProgramming\DataAbstraction>java-algs4 SmartDate
 Exception in thread "main" java.lang.RuntimeException: Illegal Date entry
 at SmartDate.<init>(SmartDate.java:14)
 at SmartDate.main(SmartDate.java:47)

For WeekDay
C:\Users\ngunti\algs4\FundamentalsOfProgramming\DataAbstraction>javac-algs4 SmartDate.java
C:\Users\ngunti\algs4\FundamentalsOfProgramming\DataAbstraction>java-algs4 SmartDate
Sunday
Sunday
Both the dates are same ? false

 
 
 */