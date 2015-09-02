public class Exercise2_3_8{
        private static int numComp = 0;
    public static int sort(Comparable[] a){
        StdRandom.shuffle(a);
        numComp  = 0;
        sort(a,0, a.length-1);
        return numComp;
    }
    
    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo) return;
        
        int j = partition(a, lo, hi);
        sort(a,lo, j-1);
        sort(a, j+1, hi);        
    }
    
    public static int partition(Comparable[] a , int lo, int hi){
        int i = lo;
        int j = hi+1;
        while(true){
            Comparable v = a[lo];
            while(less(a[++i],v)){
                numComp++;
                if(i == hi) break;
            }
            while(less(v,a[--j])){ 
                numComp++;
                if(j == lo) break;
            }
            if(i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    
    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;         
    }
    
    public static void main(String[] args){
       int N = Integer.parseInt(args[0]);
       Integer[] a = new Integer[N];
       for(int i = 0; i< N; i++){
           a[i] = 10;
       }
       System.out.println("Number of compares for N = " + N + " is "+ sort(a));
    }
}
/*
 * C:\Users\ngunti\algs4\Sorting\QuickSort>java-algs4 Exercise2_3_8 10
Number of compares for N = 10 is 0

C:\Users\ngunti\algs4\Sorting\QuickSort>java-algs4 Exercise2_3_8 100
Number of compares for N = 100 is 0

C:\Users\ngunti\algs4\Sorting\QuickSort>java-algs4 Exercise2_3_8 1000
Number of compares for N = 1000 is 0

 */