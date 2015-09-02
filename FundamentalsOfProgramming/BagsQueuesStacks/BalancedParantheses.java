public class BalancedParantheses{
    public static void printParantheses(int N){
        
        String s = "";
        printParantheses(s,0,0,N);
    }
    private static void printParantheses(String s, int openP, int closeP, int N){
        if(openP == N && closeP == N ){            
            System.out.println(s);
        }
        else{
            if(openP < N){
                System.out.println("Calling on = " + s+ "(");
                printParantheses(s+"(", openP+1, closeP, N);
            }
            if(closeP < openP){
                System.out.println("Calling on = " + s+ ")");
                printParantheses(s+")", openP, closeP+1, N);
            }
        }
    }
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        printParantheses(N);
    }
}