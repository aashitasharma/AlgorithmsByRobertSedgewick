public class DoublingRatio{
    public static double timeTrial(int N){
        int[] a = new int[N];
        int MAX = 1000000;
        for(int i = 0; i < N; i++){
            a[i] = StdRandom.uniform(-MAX,MAX);            
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSumFast.count(a);
        double time = timer.elapsedTime();
        return time;
    }
    
    public static void main(String[] args){
        double prev = timeTrial(125);
        for(int N = 250; true; N+=N){
            double time = timeTrial(N);
            System.out.printf("%6d %7.1f ",N, time);
            System.out.printf("%5.1f\n",time/prev);
            prev = time;
        }
    }
}