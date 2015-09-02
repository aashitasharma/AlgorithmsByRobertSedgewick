public class Parentheses{
    public static void main(String[] args){
        Stack<String> stack = new Stack<String>();
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s.equals("[") || s.equals("(") || s.equals("{")){
                System.out.println("Pushed " + s);
                stack.push(s);
            }
            else{
                String item = stack.peek();
                //System.out.println("Peeking " + item); 
                if((s.equals("]") && item.equals("["))||
                   (s.equals(")") && item.equals( "("))||
                   (s.equals("}") && item.equals("{"))){
                    System.out.println("Poped " + stack.pop());                   
                }
            }
        }
        if(stack.isEmpty()){
            System.out.println("Parentheses are balanced");
        }
        else{
            System.out.println("Parentheses are not balanced");
        }
    }
}
/*
[ ( ) ] { } { [ ( ) ( ) ] ( ) }
C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 Parentheses < Parenthe.txt
Pushed [
Pushed (
Poped (
Poped [
Pushed {
Poped {
Pushed {
Pushed [
Pushed (
Poped (
Pushed (
Poped (
Poped [
Pushed (
Poped (
Poped {
Parentheses are balanced

[ ( ] )
C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 Parentheses < Parenthe.txt
Pushed [
Pushed (
Poped (
Parentheses are not balanced
 */