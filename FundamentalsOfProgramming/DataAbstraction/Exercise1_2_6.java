public class Exercise1_2_6{
    public static boolean detectCircularRotation(String s, String t){
        if(s.length() == t.length()){
            String temp = s.concat(s);
            if(temp.indexOf(t) > 0)
                return true;
        }
        return false;
    }
    public static void main(String[] args){
        String s = args[0];
        String t = args[1];
        if(detectCircularRotation(s,t))
            System.out.println(s + " is Ciruclar rotation of " +  t);
        else
            System.out.println(s + " is not Ciruclar rotation of " +  t);
    }
}
/*
 * C:\Users\ngunti\algs4\FundamentalsOfProgramming\DataAbstraction>java-algs4 Exercise1_2_6 ACTGACG TGACGA
 * ACTGACG is not Ciruclar rotation of TGACGA
 * C:\Users\ngunti\algs4\FundamentalsOfProgramming\DataAbstraction>java-algs4 Exercise1_2_6 ACTGACG TGACGAC
 * ACTGACG is Ciruclar rotation of TGACGAC
 */