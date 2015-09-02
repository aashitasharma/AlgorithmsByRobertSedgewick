public class Insertion{
    public static void sort(Comparable[] a){
        int N = a.length;
        show(a);
        for(int i = 1; i < N; i++){
            for(int j = i; j > 0 && less(a[j],a[j-1]); j--)
                exch(a, j, j-1);
            show(a);
        }
    }
    
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    
    private static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static boolean isSorted(Comparable[] a){
        for(int i = 1; i< a.length; i++)
            if(less(a[i], a[i-1])) return false;
        return true;
    }
    
    public static void show(Comparable[] a){
        int N = a.length;
        for(int i = 0; i < N; i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    
    public static void main(String[] args){
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        //show(a);
    }
}
/*
 * Exercise 2.1.4
 * C:\Users\ngunti\algs4\Sorting\ElementarySorts>java-algs4 Insertion<211.txt
E A S Y Q U E S T I O N
A E S Y Q U E S T I O N
A E S Y Q U E S T I O N
A E S Y Q U E S T I O N
A E Q S Y U E S T I O N
A E Q S U Y E S T I O N
A E E Q S U Y S T I O N
A E E Q S S U Y T I O N
A E E Q S S T U Y I O N
A E E I Q S S T U Y O N
A E E I O Q S S T U Y N
A E E I N O Q S S T U Y
 */