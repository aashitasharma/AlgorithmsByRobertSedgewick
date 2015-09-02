public class InfixToPostfix{
    public static void main(String[] args){
        Stack<String> vals = new Stack<String>();
        Stack<String> ops = new Stack<String>();
        
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s.equals("("));
            else if(s.equals("+")|| 
                    s.equals("-") || 
                    s.equals("*") ||
                    s.equals("/")||
                    s.equals("sqrt")) ops.push(s);
            else if(s.equals(")")){
                String o = ops.pop();
                String v = vals.pop();
                if(o.equals("+") ||
                   o.equals("-")||
                   o.equals("*")||
                   o.equals("*"))
                    v = String.format("%s %s %s",vals.pop(), v, o);
                else if(o.equals("sqrt"))
                    v = String.format("%s %s",v,o);
                vals.push(v);                    
            }
            else{
                vals.push(s);
            }
            
        }
        System.out.println(vals.pop());
    }
}
/*( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 * C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 InfixToPostfix < expression.txt
 1 2 + 3 4 - 5 6 - * *
 
 C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 InfixToPostfix < expression.txt
 1 2 + sqrt
 */