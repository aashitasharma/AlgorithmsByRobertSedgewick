public class FixedCapacityStack<Item>{
    private Item[] a;
    private int N;
    public FixedCapacityStack(int cap){
        a = (Item[])new Object[cap];
    }
    public void push(Item item){
        a[N++] = item;
    }
    public Item pop(){
        return a[--N];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public static void main(String[] args){
        FixedCapacityStack<String> s = new FixedCapacityStack<String>(100);
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-"))
                s.push(item);
            else{
                if(!s.isEmpty()) System.out.print(s.pop() + " ");
            }
        }
        System.out.println();
        System.out.println("Size left on the stack is " + s.size()); 
    }
}
/*
C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 FixedCapacityStack < tobe.txt
to be not that or be
Size left on the stack is 2
 */