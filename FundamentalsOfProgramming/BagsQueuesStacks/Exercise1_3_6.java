public class Exercise1_3_6{
    public static void main(String[] args){
        Queue<String> q = new Queue<String>();
        q.enqueue("1");
        q.enqueue("2");
        q.enqueue("3");
        q.enqueue("4");
        q.enqueue("5");
        System.out.println("Initial Queue");
        for(String s : q){
            System.out.print(s+" ");
        }
        System.out.println();
        Stack<String> stack = new Stack<String>();
        while (!q.isEmpty())
            stack.push(q.dequeue());
        while (!stack.isEmpty())
            q.enqueue(stack.pop());
        System.out.println("After Reversing Queue");
        for(String s : q){
            System.out.print(s+" ");
        }
    }
}
/*
C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 Exercise1_3_6
Initial Queue
1 2 3 4 5
After Reversing Queue
5 4 3 2 1
 */