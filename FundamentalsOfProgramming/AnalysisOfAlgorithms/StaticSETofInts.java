import java.util.Arrays;
public class StaticSETofInts{
    private int[] a;
    
    public StaticSETofInts(int[] keys){
        a = new int[keys.length];
        for(int i = 0; i < keys.length; i++)
            a[i] = keys[i];
        Arrays.sort(a);
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
    public boolean contains(int key){
        return rank(key) != -1;
    }
    
    private int rank(int key){
        int lo = 0;
        int hi = a.length - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(key < a[mid]) hi = mid-1;
            else if(key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    
    public int howMany(int key){
        
        int cnt = 0;               
        for (int i = rank(key); i != -1 && i < a.length && a[i] == key; i++)
            cnt++;
        return cnt;
    }
    
    public static void main(String[] args){
        int[] w = In.readInts(args[0]);
        StaticSETofInts set = new StaticSETofInts(w);
        while(!StdIn.isEmpty()){
            int key = StdIn.readInt();
            System.out.println("How many of " + key + " = " + set.howMany(key));
//            if(set.rank(key) == -1)
//                System.out.println(key);
        }
        
        
    }
}