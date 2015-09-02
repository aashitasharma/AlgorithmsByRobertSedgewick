public class Exercise1_2_4{
    public static void main(String[] args){
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);
    }
}
/*
 * C:\Users\ngunti\algs4\FundamentalsOfProgramming\DataAbstraction>java-algs4 Exercise1_2_4
 * world
 * hello
 */