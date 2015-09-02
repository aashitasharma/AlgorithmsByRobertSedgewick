import java.util.Arrays;
public class Exercise1_1_29{
    public static int rank(int key, int[] a){
        return rank(key, a, true);
    }
    public static int rank(int key, int[] a, boolean trace){
        int lo = 0;
        int hi = a.length - 1;
        
        while(lo <=  hi){
            int mid = lo+(hi -lo)/2;
            if(key > a[mid]) lo = mid+1;   
            else if(key < a[mid]) hi = mid-1;   
            else {
                while(--mid >= 0 && a[mid] == key);
                return mid+1;               
            }
        }
        return 0;
        
    }
    public static int count(int key, int[] a){
        int c = 0;
        for(int i = rank(key, a, false); i < a.length && a[i] == key; i++){
            c++;
        }
        return c;
    }
    
    public static boolean verify(int r, int c, int key, int[] a){
        for(int i = 0; i < a.length; i++){
            if((i < r || i > r+c-1) && a[i] == key ||
               (i >= r && i <= r+c-1) && a[i] != key)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        In in = new In();
        int[] whiteList = in.readInts(args[0]);
        Arrays.sort(whiteList);
        String indices = "",
            values = "";
        
        for(int i = 0; i < whiteList.length; i++){
            indices += String.format("%4d",i);
            values +=String.format("%4d",whiteList[i]);
        }
        StdOut.println(indices + "\n"+ values);
        
        while(!StdIn.isEmpty()){
            int key = StdIn.readInt();
            int r = rank(key,whiteList);
            //System.out.println(r);
            int c = count(key, whiteList);
            StdOut.printf("(%d, %d) - %s for key = %d \n", r, c,
                          verify(r, c, key, whiteList), key);
        }
    }
}
