public class Exercise1_4_3{
    public static double timeTrial(int N){
        int[] a = new int[N];
        int MAX = 1000000;
        for(int i = 0; i < N; i++){
            a[i] = StdRandom.uniform(-MAX,MAX);            
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        double time = timer.elapsedTime();
        return time;
    }
    
    public static void main(String[] args){
        int MAX = 10000;
        StdDraw.setXscale(0,MAX);
        StdDraw.setYscale(0,MAX*MAX);
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.RED);
        
        for(int N = 125; true; N+=N){
            
            double time = timeTrial(N);
            //StdDraw.point(N,N);
            StdDraw.point(N, time);
            //StdDraw.point(N,N*Math.log(N));
            //System.out.printf("%7d %5.1f \n", N , time);
        }            
    }
}