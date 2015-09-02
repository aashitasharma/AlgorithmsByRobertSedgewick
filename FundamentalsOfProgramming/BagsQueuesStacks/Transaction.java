public class Transaction{
    private final String who;
    private final Date when;
    private final double amount;
    public Transaction(String t){
        String[] fields = t.split("\\s+");
        who = fields[0];
        when = new Date(fields[1]);
        amount = Double.parseDouble(fields[2]);
    }
    
    public Transaction(String s, Date d, double a){
        who = s;
        when = d;
        amount = a;
    }
    
    
    public String who(){
        return who;
    }
    public Date when(){
        return when;
    }
    public double amount(){
        return amount;
    }
    public String toString(){
        return "Name: " + who() + "\n" 
            + "Date: " + when + "\n" 
            + "Amount: " +amount() +"\n";
    }
    
    public boolean equals(Object x){
        if(this ==  x) return true;
        if(x == null) return false;
        if(this.getClass() != x.getClass()) return false;
        
        Transaction that = (Transaction)x;
        if(this.who != that.who)return false;
        if(!((this.when).equals(that.when)))return false;
        if(this.amount != that.amount)return false;
        return true;
    }
    
    public static void main(String[] args){
        Transaction t1 = new Transaction("Nagajyothi Gunti",new Date(6,12,1988),1000);
        Transaction t2 = new Transaction("Nagajyothi 6/12/1988 15.00");
        System.out.println(t1);
        System.out.println(t2);
        if(t1.equals(t2))
            System.out.println("Both transactions are same");
        else
            System.out.println("Both are Different transactions");
    }
}
/*
C:\Users\ngunti\algs4\FundamentalsOfProgramming\DataAbstraction>javac-algs4 Transaction.java
C:\Users\ngunti\algs4\FundamentalsOfProgramming\DataAbstraction>java-algs4 Transaction
Name: Nagajyothi Gunti
Date: 6/12/1988
Amount: 1000.0

Name: Nagajyothi Gunti
Date: 6/12/1988
Amount: 1000.0

Both transactions are same

C:\Users\ngunti\algs4\FundamentalsOfProgramming\DataAbstraction>javac-algs4 Transaction.java
C:\Users\ngunti\algs4\FundamentalsOfProgramming\DataAbstraction>java-algs4 Transaction
Name: Nagajyothi Gunti
Date: 6/12/1988
Amount: 1000.0

Name: Nagajyothi Gunti
Date: 6/12/1988
Amount: 1500.0

Both are Different transactions
 */