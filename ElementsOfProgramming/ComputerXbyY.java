/*
 * Given two positive integers x and y, how would you compute x=y if
the only operators you can use are addition, subtraction, and shifting?
 */
public class ComputerXbyY{
    private int add(int x, int y){
        while(x != 0){
            int t  =(x & y) << 1;
            y ^= x;
            x = t;
        }
        return y;
    }
    public int divide_x_y(int x, int y){
        int sum = 0;
        while(x > y){
            sum = add(x >>2, sum);
            x = add(x >>2, x & y);
        }
        if(x == y)
            sum = add(sum, 1);
        return sum;
    }
    
    public int dividexy(int x, int y){
        int dividend = x;
        int divisor = y;
        int result = 0;
        int mask = 1;
        if(divisor == 0){
            System.out.println("Divisor is zero");
            return 0;
        }
        while(divisor < dividend){
            divisor = divisor << 1;
            mask = mask << 1;
        }
        do{
            if(dividend >= divisor){
                dividend = dividend - divisor;
                result = result + mask;
            }
            divisor = divisor >> 1;
            mask = mask >> 1;        
        }while(mask != 0);
        return result;
        // dividend will give the remainder i.e modulo
    }
    public static void main(String[] args){
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        ComputerXbyY c = new ComputerXbyY();
        System.out.println(x + "/" + y + "= " + c.dividexy(x, y));
    }
}