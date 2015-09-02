public class Exercise1_3_5{
    public static void binaryRepresentation(int N){
        Stack<Integer> stack = new Stack<Integer>();
        while (N > 0)
        {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack) StdOut.print(d);
        StdOut.println();
    }
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        binaryRepresentation(N);
    }
}
/*
C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 Exercise1_3_5 100
1100100

C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 Exercise1_3_5 50
110010
 */