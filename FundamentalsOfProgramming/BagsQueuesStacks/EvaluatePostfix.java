public class EvaluatePostfix{
    public static void main(String[] args){
        Stack<Double> vals = new Stack<Double>();
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s.equals("+")){
                double v = vals.pop();
                vals.push(vals.pop() + v);
            }
            else if(s.equals("-")){
                double v = vals.pop();
                vals.push(vals.pop()- v);
            }
            else if(s.equals("*")){
                double v = vals.pop();
                vals.push(vals.pop() * v);
            }
            else if(s.equals("/")){
                double v = vals.pop();
                vals.push(vals.pop() / v);
            }
            else if(s.equals("sqrt")){
                double v = vals.pop();
                vals.push(Math.sqrt(v));
            }            
            else
                vals.push(Double.parseDouble(s));
        }
        System.out.println(vals.pop());
    }
}
/*
1 2 + 3 4 - 5 6 - * *
C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 EvaluatePostfix<expression.txt
3.0

1 2 + sqrt
C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 EvaluatePostfix<expression.txt
1.7320508075688772
 */
