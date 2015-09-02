public class MergeBU{
    private static Comparable[] aux;
    public static void sort(Comparable[] a){
        aux =  new Comparable[a.length];
        int N = a.length;

        for(int sz = 1; sz < N; sz = sz + sz){
            System.out.println("For sz = " + sz +" ");
            for(int lo = 0; lo < N-sz; lo += sz+sz){
                System.out.printf("merge(a, %d, %d, %d)\n",lo,lo+sz-1, Math.min(lo+sz+sz-1, N-1));
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
                //show(a);
            }
        }
    }
    
    public static void merge(Comparable[] a, int lo, int mid, int hi){

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
        for(int i = 1; i < a.length; i++)
            if(less(a[i], a[i-1])) return false;
        return true;
    }
    
    public static void show(Comparable[] a){
        for(int i = 0; i< a.length; i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    
    public static void main(String[] args){
        String[] a = In.readStrings();
        show(a);
        sort(a);
        assert isSorted(a);
        show(a);
        Double[] d = new Double[39];
        for(int i = 0; i < 39; i++){
            d[i] = StdRandom.uniform();
        }
        sort(d);
    }
}
/*
 * Exercise2.2.3
C:\Users\ngunti\algs4\Sorting\MergeSort>java-algs4 MergeBU<222.txt
E A S Y Q U E S T I O N
For sz = 1
merge(a, 0, 0, 1)       A E S Y Q U E S T I O N
merge(a, 2, 2, 3)       A E S Y Q U E S T I O N
merge(a, 4, 4, 5)       A E S Y Q U E S T I O N
merge(a, 6, 6, 7)       A E S Y Q U E S T I O N
merge(a, 8, 8, 9)       A E S Y Q U E S I T O N
merge(a, 10, 10, 11)    A E S Y Q U E S I T N O
For sz = 2
merge(a, 0, 1, 3)       A E S Y Q U E S I T N O
merge(a, 4, 5, 7)       A E S Y E Q U S I T N O
merge(a, 8, 9, 11)      A E S Y E Q U S I N T O
For sz = 4
merge(a, 0, 3, 7)       A E E S Q Y U S I N T O
For sz = 8
merge(a, 0, 7, 11)      A E E I S N Q Y U T O S
A E E I S N Q Y U T O S

Exercise 2.2.5
C:\Users\ngunti\algs4\Sorting\MergeSort>java-algs4 MergeBU
For sz = 1
merge(a, 0, 0, 1)
merge(a, 2, 2, 3)
merge(a, 4, 4, 5)
merge(a, 6, 6, 7)
merge(a, 8, 8, 9)
merge(a, 10, 10, 11)
merge(a, 12, 12, 13)
merge(a, 14, 14, 15)
merge(a, 16, 16, 17)
merge(a, 18, 18, 19)
merge(a, 20, 20, 21)
merge(a, 22, 22, 23)
merge(a, 24, 24, 25)
merge(a, 26, 26, 27)
merge(a, 28, 28, 29)
merge(a, 30, 30, 31)
merge(a, 32, 32, 33)
merge(a, 34, 34, 35)
merge(a, 36, 36, 37)
For sz = 2
merge(a, 0, 1, 3)
merge(a, 4, 5, 7)
merge(a, 8, 9, 11)
merge(a, 12, 13, 15)
merge(a, 16, 17, 19)
merge(a, 20, 21, 23)
merge(a, 24, 25, 27)
merge(a, 28, 29, 31)
merge(a, 32, 33, 35)
merge(a, 36, 37, 38)
For sz = 4
merge(a, 0, 3, 7)
merge(a, 8, 11, 15)
merge(a, 16, 19, 23)
merge(a, 24, 27, 31)
merge(a, 32, 35, 38)
For sz = 8
merge(a, 0, 7, 15)
merge(a, 16, 23, 31)
For sz = 16
merge(a, 0, 15, 31)
For sz = 32
merge(a, 0, 31, 38)
 */