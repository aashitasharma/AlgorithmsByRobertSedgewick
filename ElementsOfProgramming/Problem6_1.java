public class Problem6_1{
    public static void partition(Comparable[] a, int j){
        Comparable v = a[j];
        int lt = 0;
        int i = 0;
        int gt = a.length - 1;
        while(i <= gt){
            int cmp = a[i].compareTo(v);
            if(cmp < 0)
                exch(a, lt++, i++);
            else if(cmp > 0)
                exch(a, i, gt--);
            else
                i++;
        }
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
                            
    public static void main(String[] args){
        int index = Integer.parseInt(args[0]); 
        String[] a = In.readStrings();
        partition(a,index);
        show(a);
    }
    
    
}