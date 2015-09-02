public class Rational{

    private int numerator;
    private int denominator;
    
    public Rational(int n, int d){
        assert d != 0 : "Denominator = 0";
        int gcd = gcd(n,d);        
        numerator = ((d > 0) ? 1 : -1) * n / gcd;
        denominator = Math.abs(d)/gcd;;        
    }
    
    public Rational plus(Rational b){
        int rn = this.numerator * b.denominator + 
            this.denominator * b.numerator;
        int rd = this.denominator * b. denominator;
        return new Rational(rn, rd);
    }
    public Rational minus(Rational b){
        int rn = this.numerator * b.denominator - 
            this.denominator * b.numerator;
        int rd = this.denominator * b. denominator;
        return new Rational(rn, rd);
    }
    public Rational times(Rational b){
        int rn = this.numerator * b.numerator;
        int rd = this.denominator * b. denominator;
        return new Rational(rn, rd);
    }
    public Rational divides(Rational b){
        int rn = this.numerator * b.denominator;            
        int rd = this.denominator * b. numerator;
        return new Rational(rn, rd);
    }
    public boolean equals(Rational that){
        if(this == that) return true;
        if(that == null) return false;
        if(this.getClass() != that.getClass()) return false;
        
        Rational x = (Rational)that;
        if(x.numerator != this.numerator) return false;
        if(x.denominator != this.denominator) return false;
        
        return true;
    }
    public String toString(){
        if(denominator == 1)
            return numerator + "";
        else
            return numerator + "/" +  denominator;
    }
    public int gcd(int p,int q){
        if(q == 0) return p;
        int r = p % q;
        return gcd(q,r);
    }
    
    public static void main(String[] args){
        Rational r1 = new Rational(2, 4);
        Rational r2 = new Rational(3, 4);
        
        System.out.println(r1 + "+" + r2 + " = " + r1.plus(r2));
        System.out.println(r1 + "-" + r2 + " = " + r1.minus(r2));
        System.out.println(r1 + "*" + r2  + " = " + r1.times(r2));
        System.out.println(r1 + "/" + r2 + " = " + r1.divides(r2));
        System.out.println(r1 + " equals " + r2 + " ? " + r1.equals(r2));
    }
}

/*
C:\Users\ngunti\algs4\FundamentalsOfProgramming\DataAbstraction>javac-algs4 Rational.java
C:\Users\ngunti\algs4\FundamentalsOfProgramming\DataAbstraction>java-algs4 Rational
1/2+3/4 = 5/4
1/2-3/4 = 1/-4
1/2*3/4 = 3/8
1/2/3/4 = 2/3
1/2 equals 3/4 ? false

assert denominator != 0 : "Denominator = 0";
 */