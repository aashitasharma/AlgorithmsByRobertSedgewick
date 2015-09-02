//Binomial Distribution: 
public class Exercise1_1_27 {
    public static double binomial(int N, int k, double p, Counter c)
    {
        
        if ((N == 0) && (k == 0)) return 1.0;
        if( N < 0 || k < 0) return 0.0;
        c.increment();
        return (1.0 - p)*binomial(N-1, k, p,c) + p*binomial(N-1, k-1, p,c);
    }
    public static double betterBinomial(int N, int k, double p, Counter c) {
       double[][] v = new double[N+1][k+1];
       for(int i = 0;i <= N; i++){
           for(int j = 0; j <= k; j++){
               v[i][j] = -1;
           }
       }
       return betterBinomial(v,N,k,p,c);
        
    }
    public static double betterBinomial(double[][] v, int N, int k, double p, 
                                        Counter c){
        if ((N == 0) && (k == 0)) return 1.0;
        if( N < 0 || k < 0) return 0.0;
        //c.increment();
        if(v[N][k] == -1){
            c.increment();
            v[N][k] = (1.0 - p) * betterBinomial(v,N-1,k,p,c) 
                + p * betterBinomial(v, N-1, k-1, p, c);
        }
        return v[N][k];
    }
    
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);

        Counter c = new Counter("calls");
        double b = betterBinomial(n,k,p,c);
        
        StdOut.println("Binomial distribution of n = " + n + " k = "
                           + k + " with probability = " + p + " is " + b);
        StdOut.println("Number of times the binomial is called " + c);

    }
    // java Ex_1_1_27a 10  5 0.5:         1,233 calls
    // java Ex_1_1_27a 20 10 0.5:     1,216,535 calls
    // java Ex_1_1_27a 30 15 0.5: 1,219,164,498 calls
    
    //Better Binomial
    // java Ex_1_1_27b   10    5 0.5:        50 calls
    // java Ex_1_1_27b   20   10 0.5:       175 calls
    // java Ex_1_1_27b   30   15 0.5:       375 calls
    // java Ex_1_1_27b  100   50 0.5:     3,875 calls
    // java Ex_1_1_27b 1000  500 0.5:   376,250 calls
    // java Ex_1_1_27b 4000 2000 0.5: 6,005,000 calls
}