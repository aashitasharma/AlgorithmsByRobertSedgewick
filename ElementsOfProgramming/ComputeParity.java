/*
 * Write program to compute parity bit for nonnegative integers
 * The parity bit of a sequence of bits is 1 if the number of 1s in sequence is odd, otherwise 0.
 */
public class ComputeParity{
    public int compute(long N){
        //int a = 1;
        int result = 0;
        while(N != 0){
            result ^= 1;
            N &= (N-1);
        }
        return result;        
    }
    public void evenNumbers(int x){
        int i = 1;
        int num = 0;
        System.out.println(x);
        for(i = 1; num < x; i++){
            num = i << 1;
            System.out.print(num + " ");
        }
    }
    
    public static int bitCount(int input) {
        int count = 0;
        for (int i = 0; i < 32; i++){
            //System.out.println("input >>> i & 1   for " + i + " = " + (input >>> i & 1));
            count = count + (input >>> i & 1);
            //System.out.println("Count = " + count);
        }
        return count;
    }
    public static void main(String[] args){
        ComputeParity c = new ComputeParity();
        System.out.println("Parity of " + args[0] + " is:  " + c.compute(Integer.parseInt(args[0])));
        //c.evenNumbers(Integer.parseInt(args[0]));
        
        System.out.println(bitCount(3));
        
        int b0 = 0xAB; 
        int b1 = 0xCD; 
        int d = ((b0 << 8) | b1);
        System.out.println(Integer.toHexString(d));
    }
}