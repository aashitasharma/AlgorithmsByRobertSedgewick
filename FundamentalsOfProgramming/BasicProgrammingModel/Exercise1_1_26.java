public class Exercise1_1_26{
    //T is being used as a temp variable for swapping and arranding the 
    //3 numbers in ascending order
    public static void sortABC(int a, int b, int c, int t){
        if (a > b) { t = a; a = b; b = t; }
        if (a > c) { t = a; a = c; c = t; }
        if (b > c) { t = b; b = c; c = t; }
        System.out.println(a + ", " + b + ", " + c);
    }
    public static void main(String[] args){
        sortABC(4,3,2,1);
    }
}