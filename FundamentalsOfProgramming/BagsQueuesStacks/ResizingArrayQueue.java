import java.util.Iterator;
public class ResizingArrayQueue<Item> implements Iterable<Item>{
    private Item[] a = (Item[]) new Object[2];
    private int N = 0;
    private int first = 0;
    private int last = 0;
    
    public void enqueue(Item item){
        if(N == a.length) resize(2*a.length);
        a[last++] = item;
        if(last == a.length) last = 0;
        N++;
    }
    public Item dequeue(){
        if(isEmpty()) throw new RuntimeException("Queue underflow");
        Item item =  a[first];
        a[first] = null;
        first++;
        N--;  
        
        if(first == a.length) first = 0;;
        if(N > 0 && N == a.length/4) resize(a.length/2);
        return item;
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public Item kthFromLast(int k) {
        if(N  >= k)
            return a[N - k];
        else 
            return null;
    }
    
    public void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < N; i++){
            temp[i] = a[(first + i) % a.length];
        }
        a = temp;
        first = 0;
        last = N;
    }
    
    public Iterator<Item> iterator(){
        return new QueueIterator();
    }
    
    public class QueueIterator implements Iterator<Item>{
        private int i = 0;
        public boolean hasNext(){
            return i < N;
        }
        public Item next(){
            //if(!hasNext()) throw new NoSuchElementException();
            Item item = a[i % a.length];
            i++;
            return item;
        }
        public void remove(){
        }
    }
    public static void main(String[] args){
        ResizingArrayQueue<String> q = new ResizingArrayQueue<String>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-"))
                q.enqueue(item);
            else{
                if(!q.isEmpty()) System.out.print(q.dequeue() + " ");
            }
        }
        System.out.println();
        System.out.println("Size left on the Queue is " + q.size()); 
    }
}