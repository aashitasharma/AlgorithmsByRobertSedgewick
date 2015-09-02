public class Exercise1_1_34{
    private static int SIDES = 6;
    
    public static double[] getExact(){
        double[] dist = new double[2*SIDES+1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
            dist[i+j] += 1.0;
        for (int k = 2; k <= 2*SIDES; k++)
            dist[k] /= 36.0;
        return dist;
    }
    
    public static double[] getExperim(int n){
        double[] dist = new double[2*SIDES+1];
        for(int i = 0; i < n; i++)
            dist[throwDice()]++;
        for(int k = 2; k <= 2*SIDES; k++)
            dist[k] /= n;
        return dist;
    }
    
    public static int throwDice(){
        return StdRandom.uniform(1,SIDES+1) + StdRandom.uniform(1,SIDES+1);
    }
    
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        
        double[] exact = getExact();
        
        for(int i = 2; i <= 2 * SIDES; i++)
            System.out.printf("%7d",i);
        System.out.println();
        
        for(int i = 2; i <= 2 * SIDES; i++)
            System.out.printf("%7.3f", exact[i]);
        System.out.println();
        
        double[] experim = getExperim(n); 
        
        for (int i = 2; i <= 2*SIDES; i++)
            StdOut.printf("%7.3f", experim[i]);
        StdOut.println();
    }
}
// N has to be 10000000
//..\BasicProgrammingModel > java-algs4 Exercise1_1_34 10000000
//      2      3      4      5      6      7      8      9     10     11     12
//  0.028  0.056  0.083  0.111  0.139  0.167  0.139  0.111  0.083  0.056  0.028
//  0.028  0.056  0.083  0.111  0.139  0.167  0.139  0.111  0.083  0.056  0.028