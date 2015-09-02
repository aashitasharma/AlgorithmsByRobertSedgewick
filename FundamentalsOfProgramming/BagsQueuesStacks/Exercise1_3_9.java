public class Exercise1_3_9{
    public static void main(String[] args){
        Stack<String> vals = new Stack<String>();
        Stack<String> ops = new Stack<String>();
        
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s.equals("("));
            else if(s.equals("+")) ops.push(s);
            else if(s.equals("-")) ops.push(s);
            else if(s.equals("*")) ops.push(s);
            else if(s.equals("/")) ops.push(s);
            else if(s.equals("sqrt")) ops.push(s);
            else if(s.equals(")")){
                String o = ops.pop();
                String v = vals.pop();
                if(o.equals("+") ||
                   o.equals("-")||
                   o.equals("*")||
                   o.equals("*"))
                    v = String.format("( %s %s %s )",vals.pop(), o, v);
                else if(o.equals("sqrt"))
                    v = String.format("( %s %s )",o,v);
                vals.push(v);                    
            }
            else{
                vals.push(s);
            }
                  
        }
        System.out.println(vals.pop());
    }
}

/*
For 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 Exercise1_3_9<expression.txt
( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )

For sqrt 1 + 2 ) )
C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 Exercise1_3_9<expression.txt
( sqrt ( 1 + 2 ) )

 */