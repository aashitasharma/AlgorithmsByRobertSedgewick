public class Quick{
    public static void sort(Comparable[] a){        
        StdRandom.shuffle(a);
        sort(a,0, a.length-1);        
    }
    
    private static void sort(Comparable[] a, int lo, int hi){       
        if(hi <= lo) return;
        
        int j = partition(a, lo, hi);
        System.out.printf("%d \t %d \t %d \t", lo, j, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }
    
    private static int partition(Comparable[] a, int lo, int hi){
        System.out.printf("partition(a, %d , %d) \t",lo, hi);
        int i = lo;
        int j = hi+1;
        Comparable v = a[lo];
        while(true){
            while(less(a[++i], v))
                if(i == hi) break;
            while(less(v,a[--j]))
                if(j == lo) break;
            if(i >= j) break;
            exch(a,i, j);
        }
        exch(a, lo, j);
        show(a);
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
    public static void show(Comparable[] a){
        for(int i = 0; i< a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
    
    public static boolean isSorted(Comparable[] a){
        for(int i = 1; i< a.length; i++)
            if(less(a[i], a[i-1])) return false;
        return true;
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
 * Exercise2.3.1
 * C:\Users\ngunti\algs4\Sorting\QuickSort>java-algs4 Quick < 231.txt
E A S Y Q U E S T I O N
partition(a, 0 , 11)    E I E A N O S T U Q S Y
partition(a, 0 , 3)     E A E I N O S T U Q S Y
partition(a, 0 , 1)     A E E I N O S T U Q S Y
partition(a, 5 , 11)    A E E I N O S T U Q S Y
partition(a, 6 , 11)    A E E I N O Q S S U T Y
partition(a, 6 , 7)     A E E I N O Q S S U T Y
partition(a, 9 , 11)    A E E I N O Q S S T U Y
A E E I N O Q S S T U Y
 */