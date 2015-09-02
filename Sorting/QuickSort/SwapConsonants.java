public class SwapConsonants{
    public static String swapCons(String s){
        int hi = s.length();
        for(int i = 0; i < s.length()/2; i++){
            if(!isVowel(s.charAt(i)) && !isVowel(s.charAt(hi))){
                exch(s, i++, hi--);
            }
        }
        return s;
        
    }
    private static void exch(String s, int i, int j){
        char c  = s.charAt(i);
        s.charAt(i) = s.charAt(j);
        s.charAt(j) = c;
    }
    private static boolean isVowel(char c){
        if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
           c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        String s = In.readString(args[0]);
        System.out.println("Result = " + swapCons(s));
        
    }
}