public class BitwiseArithmetic{
    public static int add(int a , int b){
        while(b != 0){
            int carry = (a & b);
            //System.out.println("Carry: " + carry);
            
            a = a ^ b;
            //System.out.println("a: " + a);
            
            b = carry << 1;
            //System.out.println("b: " + b);
            
            System.out.println();
        }
        return a;
    }
    public static int subtract(int a, int b){
        while(b != 0){
            int borrow = (~a) & b;
            System.out.println("~a = " + a + ", " +(~a));
            System.out.println("Borrow: " + borrow);
            a = a ^ b;
            System.out.println("a: " + a);
            b = borrow << 1;
            System.out.println("b: " + b);
            System.out.println();
        }
        return a;
    }
    
    public static void code16(){
        int a = 11 & 17;
        int b = 11 ^ 17;
        int c = 11 | 17;
        int d = ~11;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
    }
    
    public static void code17(int a, int b){
        int c = 0;
        while (b > 0) {
            if ((b & 1) == 1) c = c + a;
            b = b >> 1;
            a = a << 1;
        }
        System.out.println(c);
    }
    
    public static void code18(int a, int b){
        System.out.println(" a = " + a + "\n b = " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        
        System.out.println(" a = " + a + "\n b = " + b); 
    }
    public static void code21(int x){
        x = - ~x;
        System.out.println(" x = - ~x " + x);
        x = ~ -x;
        System.out.println(" x = ~ -x " + x);
    }
    public static void main(String[] args){
        //System.out.println("Adding: " +BitwiseArithmetic.add(-32766, -366));
        // System.out.println("Subtracting: " +BitwiseArithmetic.subtract(9, 11));
        int a = 2147483647;   // 2^31 - 1
        int b = a + 1;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        
        int c = -5 >>  3;
        int d = -5 >>> 3;
        System.out.println(c);
        System.out.println(d);
        System.out.println();
        
//        while(a != (a >> 1)){
//            a = a >> 1;
//            System.out.println(a);
//        }
        BitwiseArithmetic.code16();
        BitwiseArithmetic.code17(2, 3);
        BitwiseArithmetic.code18(2, 2);
        BitwiseArithmetic.code21(2);
        
    }
}