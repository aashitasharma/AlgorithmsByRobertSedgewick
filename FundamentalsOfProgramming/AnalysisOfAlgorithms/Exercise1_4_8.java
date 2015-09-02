import java.util.Arrays;
public class Exercise1_4_8{
    public static int countQuadratic(int[] a){
        int N = a.length;
        int cnt=0;
        for(int i = 0; i< N;i++){
            for(int j = i+1; j< N; j++){
                if(a[i] == a[j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    public static int count(int[] a){
        int N = a.length;
        int cnt = 0;
        Arrays.sort(a);
        
        for(int i = 0; i < N-1; i++){
            if(a[i] == a[i+1])
                cnt++;
        }
        return cnt;
    }
    
    public static void main(String[] args){
        //int N = Integer.parseInt(args[0]);
        int[] a = {1,2,4,2,3,1,5,6,6,3};       
        System.out.println("Quadratic: " + countQuadratic(a));
        System.out.println("Fast: " + count(a));
    }
}