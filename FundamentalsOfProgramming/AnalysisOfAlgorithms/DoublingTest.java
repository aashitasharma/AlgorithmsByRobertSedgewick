public class DoublingTest{
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
        
        
        for(int N = 250; true; N+=N){           
            double time = timeTrial(N);
            System.out.printf("%7d %5.1f \n", N , time);
        }            
    }
    
}