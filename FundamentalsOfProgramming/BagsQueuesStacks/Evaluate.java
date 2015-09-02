public class Evaluate{  
    public static void main(String[] args){
        Stack<Double> vals = new Stack<Double>();
        Stack<String> ops = new Stack<String>();
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s.equals("(")) {}
            else if(s.equals("+")) ops.push(s);
            else if(s.equals("-")) ops.push(s);
            else if(s.equals("*")) ops.push(s);
            else if(s.equals("/")) ops.push(s);
            else if(s.equals("sqrt")) ops.push(s);
            else if(s.equals(")"))
            {
                String op = ops.pop();
                double v = vals.pop();
                if(op.equals("+")) v = vals.pop() + v;
                else if(op.equals("-")) v = vals.pop() - v;
                else if(op.equals("*")) v = vals.pop() * v;
                else if(op.equals("/")) v = vals.pop() / v;
                else if(op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }
            else vals.push(Double.parseDouble(s));
        }                       
        System.out.println(vals.pop());
    }        
}
/*
C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 Evaluate
( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
101.0

C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 Evaluate
( ( 1 + sqrt ( 5.0 ) ) / 2 )
1.618033988749895
*/