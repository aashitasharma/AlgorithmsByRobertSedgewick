import java.util.Iterator;
public class ResizingArrayStack<Item> implements Iterable<Item>{
    private Item[] a = (Item[]) new Object[1];
    private int N=0;
    
    public void push(Item item){
        if(N == a.length) resize(2*a.length);
        a[N++] = item;
    }
    public Item pop(){
        Item item = a[--N];
        a[N] = null; //avoid loitering;
        if(N > 0 && N == a.length/4) resize(a.length/2);
        return item;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void resize(int max){
        System.out.println("Resized array to " +  max);
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }
    
    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }
    
    public class ReverseArrayIterator implements Iterator<Item>{
        private int i = N;
        public boolean hasNext(){ return i>0;}
        public Item next(){ return a[--i];}
        public void remove(){}
    }
    
    public static void main(String[] args){
        ResizingArrayStack<String> s = new ResizingArrayStack<String>();
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
C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 ResizingArrayStack < tobe.txt
Resized array to 2
Resized array to 4
Resized array to 8
to
be
not
that
Resized array to 4
or
Resized array to 2
be
Size left on the stack is 2
 */