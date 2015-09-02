public class Exercise1_2_3{
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);
        System.out.println(N + " numbers with min = " +min+" and max = "+max);
        StdDraw.setXscale(0,1.0);
        StdDraw.setYscale(0,1.0);
        
        Interval2D[] boxes = new Interval2D[N];
        for(int i = 0; i < N ; i++){
            Interval1D x = new Interval1D(xlo, xhi);
            Interval1D y = new Interval1D(ylo, yhi);
            boxes[i] = new Interval2D(x, y);
            boxes[i].draw();
        }
        
    }
}