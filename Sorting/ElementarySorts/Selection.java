public class Selection{
    public static void sort(Comparable[] a){
        int N = a.length;
        show(a);
        for(int i = 0; i < N; i++){
            int min = i;
            for(int j = i+1; j < N; j++)
                if(less(a[j], a[min])) min = j;
            exch(a,i, min);
            show(a);
        }       
    }
    
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    
    private static void exch(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static boolean isSorted(Comparable[] a){
        for(int i = 1; i< a.length; i++)
            if(less(a[i], a[i-1])) return false;
        return true;
    }
    
    public static void show(Comparable[] a){
        for(int i = 0; i< a.length; i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    
    public static void main(String[] args){
        String[] a  = In.readStrings();
        sort(a);
        assert isSorted(a);
        //show(a);
    }
}
/*
 * Exercise 2.1.1
 * C:\Users\ngunti\algs4\Sorting\ElementarySorts>java-algs4 Selection< 211.txt
E A S Y Q U E S T I O N
A E S Y Q U E S T I O N
A E S Y Q U E S T I O N
A E E Y Q U S S T I O N
A E E I Q U S S T Y O N
A E E I N U S S T Y O Q
A E E I N O S S T Y U Q
A E E I N O Q S T Y U S
A E E I N O Q S T Y U S
A E E I N O Q S S Y U T
A E E I N O Q S S T U Y
A E E I N O Q S S T U Y
A E E I N O Q S S T U Y


 */