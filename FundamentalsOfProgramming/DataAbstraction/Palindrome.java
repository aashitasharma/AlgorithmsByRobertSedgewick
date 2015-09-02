public class Palindrome{
    public static boolean isPalindrome(String s){
        int n = s.length();
        for(int i = 0; i < n/2; i++){
            if(s.charAt(i) != s.charAt(n-1-i))
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        String s = args[0];
        if(isPalindrome(s))
            System.out.println(s + " is Palindrome");
        else
            System.out.println(s + " is not Palindrome");
    }
}
/*
 * >java-algs4 Palindrome aabbaa
 * aabbaa is Palindrome
 */