public class Exercise1_2_7{
    public static String mystery(String s)
    {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return mystery(b) + mystery(a);
    }
    
    public static void main(String[] args){
        String s = args[0];
        String result = mystery(s);
        System.out.println("Mystery("+s+") is " + result);
    }
}
/* 
 * Reversing
 * C:\Users\ngunti\algs4\FundamentalsOfProgramming\DataAbstraction>java-algs4 Exercise1_2_7 abcdef
 * Mystery(abcdef) is fedcba
 */