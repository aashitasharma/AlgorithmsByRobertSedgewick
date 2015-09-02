public class Date{
    private final int month;
    private final int day;
    private final int year;
    
    public Date(int m, int d, int y){
        month = m;
        day = d;
        year = y;
    }
    
    public Date(String date){
        String[] fields = date.split("/");
        month = Integer.parseInt(fields[0]);
        day = Integer.parseInt(fields[1]);
        year = Integer.parseInt(fields[2]);
    }
    public int month(){
        return month;
    }
    
    public int day(){
        return day;
    }
    
    public int year(){
        return year;
    }
    
    public String toString(){
        return month() + "/" + day() + "/" + year();
    }
    
    public boolean equals(Object x)
    {
        if(this == x) return true;
        if(x == null) return false;
        if(this.getClass() != x.getClass()) return false;
        
        Date that = (Date)x;
        if(this.month != that.month) return false;
        if(this.day != that.day) return false;
        if(this.year != that.year) return false;
        
        return true;
    }
    
    public static void main(String[] args){
        Date a = new Date(6,12,1988);
        Date b = new Date("4/12/1991");
        System.out.println(a);
        System.out.println(b);
        System.out.println("Both the dates are same ? " + a.equals(b));
    }
}
/*
 * C:\Users\ngunti\algs4\FundamentalsOfProgramming\DataAbstraction>javac-algs4 Date.java
 * C:\Users\ngunti\algs4\FundamentalsOfProgramming\DataAbstraction>java-algs4 Date
 * 6/12/1988
 * 4/12/1991
 * Both the dates are same ? false
 */