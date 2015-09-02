public class Shell{
    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while(h < N/3) h = 3*h + 1;
        show(a);
        while(h >= 1){
            for(int i = h; i < N; i++){
                for(int j = i; j >= h && less(a[j],a[j-h]); j -= h)
                    exch(a, j, j-h);               
            }
            show(a);
            h = h/3;
        }
    }
    
    public static void numberOfComparesPerArraySize(Double[] a){
        int compares = 0;
        int N = a.length;
        int h = 1;
        while(h < N/3) h = 3*h + 1;
        while(h >= 1){
            for(int i = h; i < N; i++){
                for(int j = i; j >= h && less(a[j],a[j-h]); j -= h){
                    compares++;
                    exch(a, j, j-h);               
                }
            }
            h = h/3;
        }
        
        System.out.printf("Number of compares per array size %d / %d \n",compares,N);
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
        int N = a.length;
        for(int i = 1; i < N; i++)
            if(less(a[i],a[i-1])) return false;
        return true;
    }
    
    public static void show(Comparable[] a){
        int N = a.length;
        for(int i = 0; i < N; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
    
    public static void main(String[] args){
//        String[] a  = In.readStrings();
//        sort(a);
//        assert isSorted(a);
        for(int N = 100; true; N = N*10){
            Double[] d = new Double[N];
            for(int i =0; i<N; i++)
                d[i] = StdRandom.uniform();
            numberOfComparesPerArraySize(d);
            
        }
    }
}
/*
 * Exercise2.1.9
 * C:\Users\ngunti\algs4\Sorting\ElementarySorts>java-algs4 Shell<shellsort.txt
 E A S Y S H E L L S O R T Q U E S T I O N
 E A E S S H E L L S O R T Q U S Y T I O N
 E A E L L H E O N Q I R S S O S T T U S Y
 A E E E H I L L N O O Q R S S S S T T U Y
 
 Exercise2.1.12
 C:\Users\ngunti\algs4\Sorting\ElementarySorts>java-algs4 Shell
Number of compares per array size 487 / 100
Number of compares per array size 9339 / 1000
Number of compares per array size 171368 / 10000
Number of compares per array size 2878332 / 100000
Number of compares per array size 52808015 / 1000000
Number of compares per array size 934265520 / 10000000
 */