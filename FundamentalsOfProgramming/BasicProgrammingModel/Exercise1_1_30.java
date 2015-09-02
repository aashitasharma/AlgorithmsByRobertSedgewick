public class Exercise1_1_30{
    public static void createBooleanArray(int N){
        Boolean[][] a = new Boolean[N][N];
        for(int i = 0; i< N;i++){
            for(int j = 0; j< N; j++){
                if(isRelativelyPrime(i,j)){
                    a[i][j] =  true;
                }
                else{
                    a[i][j] = false;
                }
            }
        }
        for(int i = 0; i< N;i++){
            for(int j = 0; j< N; j++){
                System.out.printf("(%d, %d)%-8s ",i,j,a[i][j]);
            }
            System.out.println();
        }
    
    }
    public static Boolean isRelativelyPrime(int i, int j){
        int c = 0;
        if(i > j) {
            c = i;
            i = j;
            j = c;
        }
        if(gcd(i,j) == 1)return true;
        else return false;
    }
    
     public static int gcd(int p, int q){        
        if(q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        createBooleanArray(N);
    }
}