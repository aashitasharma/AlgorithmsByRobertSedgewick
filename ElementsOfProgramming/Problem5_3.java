public class Problem5_3{
    public static String changeBase(String s, int b1, int b2){
        if(s == null || s.isEmpty())
            return s;
        int x = parseInt(s, b1, s.length()-1);
        StringBuilder xInB2 = convertToBase(x, b2);
        return xInB2.toString();
    }
    private static int parseInt(String s, int base, int idx){
        if(idx < 0)
            return 0;
        final char ch = s.charAt(idx);
        if(ch == '-'){
            return -1;            
        }
        final int idxOfZeroInASCII = 48;
        int intVal = s.charAt(idx) - idxOfZeroInASCII;
        int sum = (int)(intVal*Math.pow(base, s.length()-1-idx));
        int val = parseInt(s, base, --idx);
        if(val != -1)
            sum += Math.abs(val);
        if(val < 0)
            sum *= -1;
        return sum;
    }
    
    private static StringBuilder convertToBase(int x, int b){
        StringBuilder buffer = new StringBuilder();
        buffer.insert(0, encode(x % b));
        if(x >= b)
            buffer.insert(0, convertToBase(x/b, b));
        return buffer;
    }
    
    private static String encode(int val){
        String encodedVal = null;
        switch(val){
            case 10 : 
                encodedVal = "A";
                break;
            case 11:
                encodedVal = "B";
                break;
            case 12:
                encodedVal = "C";
                break;
            case 13:
                encodedVal = "D";
                break;
            case 14:
                encodedVal = "E";
                break;            
            case 15:
                encodedVal = "F";
                break;
            default:
                encodedVal = String.valueOf(val);
                break;
        }
        return encodedVal;
    }
    public static void main(String[] args){
        int b1 = Integer.parseInt(args[0]);
        String s = args[1];
        int x = parseInt(s, b1,s.length()-1);
        System.out.println(s + " in base " + b1 + " = " + x);
        int b2 = Integer.parseInt(args[2]);
        String result = changeBase(s, b1, b2);
        System.out.println(s + " in base " + b2 + " = " + result);
    }
}