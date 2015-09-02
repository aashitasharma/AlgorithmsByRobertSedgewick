public class Exercise2_2_9{

    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(aux, a, 0, a.length-1);
    }
    private static void sort(Comparable[] aux,Comparable[] a, int lo, int hi){
        if(hi <= lo) return;        
        int mid = lo + (hi-lo)/2;        
        sort(aux, a, lo, mid);
        sort(aux, a, mid+1, hi);
        System.out.printf("merge(aux,a, %d, %d, %d)\t",lo, mid, hi);       
        merge(aux, a, lo, mid, hi);
        show(a);
    }
    
    public static void merge(Comparable[] aux,Comparable[] a, int lo,int mid, int hi){
       int i = lo;
        int j = mid+1;
        for(int k = lo; k <= hi; k++)
            aux[k] = a[k];
        //show(aux);
        for(int k = lo; k <= hi; k++)
        {
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(less(aux[i],aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
    
    
    public static boolean isSorted(Comparable[] a){
        int N = a.length;
        for(int i = 1; i < N; i++)
            if(less(a[i],a[i-1])) return false;
        return true;
    }
    
    public static void show(Comparable[] a){
        int N = a.length;
        for(int i = 0; i < N; i++)
            System.out.print(a[i]+ " ");
        System.out.println();
    }
    
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    
        private static boolean lessOrEqual(Comparable v, Comparable w){
        return v.compareTo(w) < 0 || v.compareTo(w) == 0;
    }
    
    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void main(String[] args){
        String[] a = In.readStrings();
        show(a);
        sort(a);
        assert isSorted(a);        
        show(a);
    }
    
}
/*
 * C:\Users\ngunti\algs4\Sorting\MergeSort>java-algs4 Exercise2_2_9<tiny.txt
M E R G E S O R T E X A M P L E
merge(aux,a, 0, 0, 1)   E M R G E S O R T E X A M P L E
merge(aux,a, 2, 2, 3)   E M G R E S O R T E X A M P L E
merge(aux,a, 0, 1, 3)   E G M R E S O R T E X A M P L E
merge(aux,a, 4, 4, 5)   E G M R E S O R T E X A M P L E
merge(aux,a, 6, 6, 7)   E G M R E S O R T E X A M P L E
merge(aux,a, 4, 5, 7)   E G M R E O R S T E X A M P L E
merge(aux,a, 0, 3, 7)   E E G M O R R S T E X A M P L E
merge(aux,a, 8, 8, 9)   E E G M O R R S E T X A M P L E
merge(aux,a, 10, 10, 11)        E E G M O R R S E T A X M P L E
merge(aux,a, 8, 9, 11)  E E G M O R R S A E T X M P L E
merge(aux,a, 12, 12, 13)        E E G M O R R S A E T X M P L E
merge(aux,a, 14, 14, 15)        E E G M O R R S A E T X M P E L
merge(aux,a, 12, 13, 15)        E E G M O R R S A E T X E L M P
merge(aux,a, 8, 11, 15) E E G M O R R S A E E L M P T X
merge(aux,a, 0, 7, 15)  A E E E E G L M M O P R R S T X
A E E E E G L M M O P R R S T X
 */