public class Exercise1_2_1{
    
    //bruteforce approach
    public static double closestDistance(Point2D[] a){
        double dist = Double.POSITIVE_INFINITY;
        
        for(int i = 0; i< a.length-1; i++){
            Point2D thisPoint = a[i];
            for(int j = i+1; j < a.length; j++){
                Point2D thatPoint = a[j];
                if(thisPoint.distanceTo(thatPoint) < dist) 
                    dist = thisPoint.distanceTo(thatPoint);
            }
            
        }
        return dist;
    }
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        StdDraw.setXscale(0, 1.0);
        StdDraw.setYscale(0, 1.0);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.02);
        Point2D[] a = new Point2D[N];
        //Generate N random points
        for(int i = 0; i < N; i++){
            double x = Math.random();
            double y = Math.random();
            a[i] = new Point2D(x, y);
            StdDraw.point(x,y);
        }
//        for(int i = 0; i < N; i++){
//            System.out.println(a[i]);
//        }
        //Compute the distance seperating the closest pair of points
        System.out.println("Closest Distance " + closestDistance(a));
    }
}

/*
 * C:\Users\ngunti\algs4\FundamentalsOfProgramming\DataAbstraction>java-algs4 Exercise1_2_1 100
 * Closest Distance 0.008876261234832207
 */