import java.util.Iterator;
/*
 * Exercise1_3_29
 */
public class CircularLinkedListQueue<Item> implements Iterable<Item>{
    private int N;
    private Node last;
    
    private class Node{
        Item item;
        Node next;
    }
    
    public CircularLinkedListQueue(){
        last = null;
    }
    
    public boolean isEmpty(){
        return last == null;
    }
    
    public int size(){
        return N;
    }
    
    /**
     * Return the item least recently added to the queue.
     * Throw an exception if the queue is empty.
     */
    public Item peek(){
        if(isEmpty()) 
            throw new RuntimeException("Queue is Empty");
        return last.next.item;
    }
    
    /*
     * Add an item to queue
     */
    public void enqueue(Item item){
        Node n = new Node();
        n.item = item;
        
        if(isEmpty())
            n.next = n;
        else{
            n.next = last.next;
            last.next = n;
        }
        last = n;
        N++;    
    }
    
    /*
     * Remove an item from queue
     */
    public Item dequeue(){
        if(isEmpty()) 
            throw new RuntimeException("Queue is Empty");
        Item item = last.next.item;
        if(last.next == last)
            last = null;
        else{
            last.next = last.next.next;
        }
        N--;
        return item;
        
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(Item t: this)
            s.append(t + " ");
        return s.toString();
    }
    
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    
    public class ListIterator implements Iterator<Item>{
        private Node current = last;
        private int n = N;
        public boolean hasNext(){
            return n>0;
        }
        public Item next(){
            Item item = current.next.item;
            current = current.next;
            n--;
            return item;
        }
        public void remove(){}
    }
    
    public static void main(String[] args){
        CircularLinkedListQueue<String> q = new CircularLinkedListQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue: [ " + q + "])");
    }
    
}