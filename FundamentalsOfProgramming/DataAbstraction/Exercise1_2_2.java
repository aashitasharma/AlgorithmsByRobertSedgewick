public class Exercise1_2_2{
    public static void findIntersects(Interval1D[] interval){
        int N = interval.length;
        for(int i = 0; i< N-1; i++){
            Interval1D thisi = interval[i];
            for(int j = i+1; j < N; j++){
                Interval1D that = interval[j];
                if(thisi.intersects(that)){
                    System.out.println(thisi + " intersects " + that);
                }
            }            
        }
    }
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        
        Interval1D[] a = new Interval1D[N+1];            
            
        //Generate N random intervals
        for(int i = 0; i < N; i++){
            double x = StdRandom.random();
            double y = StdRandom.random();
            a[i] = new Interval1D(x, y);
            System.out.println(a[i]);
            //StdDraw.point(x,y);
        }
           
        findIntersects(a);
    }
}