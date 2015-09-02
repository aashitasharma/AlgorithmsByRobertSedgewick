import java.util.Arrays;
public class Exercise1_4_12{
//    public static void printAll(int[] a, int[] b){
//        if(a[0] <= b[0]){
//            for(int i = 0; i< a.length; i++){
//                if(rank(a[i], b) != -1)
//                    System.out.print(a[i] + " ");
//            }           
//        }
//        else{
//            for(int i = 0; i< a.length; i++){
//                if(rank(b[i], a) != -1)
//                    System.out.print(b[i] + " ");
//            }  
//        }
//    }
    
    public static void printAll(int[] a, int[] b){
        int ai =0, bi=0;
        while(ai < a.length || bi < b.length){
            if(bi == b.length)
                System.out.print(a[ai++] + " ");
            else if(ai == a.length)
                System.out.print(b[bi++] + " ");
            else if(a[ai] < b[bi])
                ai++;
            else if(a[ai] > b[bi])
                bi++;
            else{
                System.out.print(a[ai] + " ");
                ai++;
                bi++;
            }
        }
    }
    public static int rank(int key, int[] a){
        int lo = 0;
        int hi = a.length - 1;
        
        while(lo <=  hi){
            int mid = (lo+hi)/2;
            if(key > a[mid]) lo = mid+1;   
            else if(key < a[mid]) hi = mid-1;   
            else return mid;   
        }
        return -1;
        
    }
    public static void main(String[] args){
        In in = new In();
        int[] a = in.readInts(args[0]);
        int[] b = in.readInts(args[1]);
       
        
        Arrays.sort(a);
        
        Arrays.sort(b);
        
        for(int i =0; i<a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        for(int i =0; i<b.length; i++)
            System.out.print(b[i] + " ");
        System.out.println();
        printAll(a,b);
    }
}