public class FixedCapacityStackOfStrings{
    private String[] a;
    private int N;
    public FixedCapacityStackOfStrings(int cap){
        a = new String[cap];
    }
    public void push(String item){
        a[N++] = item;
    }
    public String pop(){
        return a[--N];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public boolean isFull(){
        return N == a.length;
    }
    public static void main(String[] args){
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-"))
                s.push(item);
            else{
                if(!s.isEmpty()) System.out.println(s.pop() + " ");
            }
        }
        System.out.println("Size left on the stack is " + s.size()); 
    }
}
/*
C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>javac-algs4 FixedCapacityStackOfStrings.java
C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 FixedCapacityStackOfStrings < tobe.txt
to be not that or be 
Size left on the stack is 2

it was - the best - of times - - - it was - the - -
C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 Stack <tobe.txt
was best times of the was the it
Size left on the stack is 1

 */