import java.util.Arrays;

public class Exercise1_1_22 {
    
    public static int rank(int key, int[] a, int lo, int hi,int depth) {
        StdOut.println("At depth = " + depth + " lo = " + lo + " hi = " + hi);
        if(lo > hi) return -1;
        int mid  = lo+(hi-lo)/2;
        //StdOut.println("mid = " + mid);
        if(key < a[mid]){
            depth ++; 
            return rank(key,a, lo, mid-1,depth);
            
        }
        else if(key > a[mid]){
            depth++; 
            return rank(key,a,mid+1, hi, depth);
        }
        else return mid;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] whiteList = In.readInts(args[0]);
        
        Arrays.sort(whiteList);
        for(int i = 0; i < whiteList.length; i++){
            System.out.print(whiteList[i] + " ");
        }
        System.out.println();
        while(!StdIn.isEmpty()){
            int key = StdIn.readInt();
            if(rank(key,whiteList, 0, whiteList.length-1, 0) < 0){
                StdOut.println(key);
            }
        }
    }
    
}