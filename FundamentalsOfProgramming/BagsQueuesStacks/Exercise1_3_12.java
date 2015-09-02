public class Exercise1_3_12{
    public static Stack<String> copy(Stack<String> s){
        Stack<String> c = new Stack<String>();
        for(String i: s){
            c.push(i);
        }
        return c;
    }
    public static void main(String[] args){
        Stack<String> s = new Stack<String>();
        s.push("1");
        s.push("2");
        s.push("3");
        s.push("4");
        s.push("5");
        Stack<String> c = copy(s);
        for(String i : c){
            System.out.print(i + " ");
        }
    }
}