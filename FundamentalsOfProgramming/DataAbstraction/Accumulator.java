public class Accumulator{
    private double total;
    private int N;
    private double s;
    private double m;
    
    public void addDataValue(double val){
        N++;
        total += val;
        s = s + 1.0 * (N - 1) / N * (val - m) *(val - m);
        m = m + (val - m)/N;
    }
    
    public double mean(){
        return m;
    }
    
    public double var(){
        return s/(N-1);
    }
    
    public double stddev(){
        return Math.sqrt(this.var());
    }
    
    public String toString(){
        return "Mean (" + N + " values): " + String.format("%7.5f", mean()) + 
            "\n" + "Variance (" + N + " values): " + String.format("%7.5f", var()) + 
            "\n" + "Standard Deviation (" + N + " values): " + String.format("%7.5f", stddev());
    }
    
    public static void main(String[] args){
        int T = Integer.parseInt(args[0]);
        Accumulator a = new Accumulator();
        for(int i = 0; i < T; i++)
            a.addDataValue(Math.random());
        System.out.println(a);
    }
}
/*
 * C:\Users\ngunti\algs4\FundamentalsOfProgramming\DataAbstraction>java-algs4 Accumulator 1000
 * Mean (1000 values): 0.50666
 */