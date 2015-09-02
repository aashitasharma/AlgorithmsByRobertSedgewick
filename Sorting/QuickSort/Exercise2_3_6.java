public class Exercise2_3_6{
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
        for(int k = 100; k <= 10000; k *= 10){
            System.out.println("For k = " + k);
            Double a[] = new Double[k];
            for(int i = 0; i< k; i++){
                a[i] = StdRandom.uniform();
            }
            System.out.print("Actual Compares = " + sort(a) + "\t");
            System.out.println("Average Compares (2NLogN) = " + Math.floor(2*a.length*Math.log((double)a.length)));
            System.out.println();
        }
    }
}
/*
 * C:\Users\ngunti\algs4\Sorting\QuickSort>java-algs4 Exercise2_3_6
For k = 100
Actual Compares = 498   Average Compares (2NLogN) = 921.0

For k = 1000
Actual Compares = 8685  Average Compares (2NLogN) = 13815.0

For k = 10000
Actual Compares = 102019        Average Compares (2NLogN) = 184206.0

 */