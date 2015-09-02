public class Interval2DTestClient{
    public static void main(String[] args){
        double xlo = Double.parseDouble(args[0]);
        double xhi = Double.parseDouble(args[1]);
        double ylo = Double.parseDouble(args[2]);
        double yhi = Double.parseDouble(args[3]);        
        int T = Integer.parseInt(args[4]);
        
        Interval1D x = new Interval1D(xlo, xhi);
        Interval1D y = new Interval1D(ylo, yhi);
        
        Interval2D box = new Interval2D(x, y);
        box.draw();
        
        Counter c = new Counter("hits");
        for(int t = 0; t < T; t++)
        {
            double a = Math.random(); // returns a random number between 0.0 and 1.0
            double b = Math.random();
            Point2D p = new Point2D(a, b);
            if(box.contains(p)) c.increment();
            else p.draw();            
        }
        
        System.out.println(c);
        System.out.println(box.area());
        
    }
}

/*
 * C:\Users\ngunti\algs4\FundamentalsOfProgramming\DataAbstraction>java-algs4 Interval2DTestClient 0.2 0.5 0.5 0.6 10000
 * 312 hits
 * 0.029999999999999992
 */