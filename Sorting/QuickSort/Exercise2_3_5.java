public class Exercise2_3_5{
    public static void sort(Comparable[] a){
        int i = partition(a, 0, a.length-1);
    }
    private static int partition(Comparable[] a, int lo, int hi){
        int lt = lo;        
        int gt = hi;
        
        int i = lo;
        
        while(i <= gt){
            Comparable v = a[lo];
            
            System.out.println("For v = " + v);
            int cmp = a[i].compareTo(v);
            
            if(cmp < 0) exch(a, lt++, i++);
            else if(cmp >0) exch(a, i, gt--);
            else i++;           
        }
        return lt;
    }
      private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    
    private static void exch(Comparable[] a , int i, int j){
        System.out.println("exchanging i = " + i + "j = " + j);
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;           
    }
    
    public static boolean isSorted(Comparable[] a){
        for(int i = 1; i < a.length; i++)
            if(less(a[i],a[i-1])) return false;
        return true;
    }
    
    public static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
    
    public static void main(String[] args){
        String[] a = In.readStrings();
        show(a);
        sort(a);
        assert isSorted(a);
        show(a);            
    }
}