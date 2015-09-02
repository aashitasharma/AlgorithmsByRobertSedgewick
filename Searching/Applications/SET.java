import java.util.Iterator;
public class SET<Key> implements Iterable<Key>{
    private Node first;
    private int N;
    private class Node{
        Key key;
        Node next;
        public Node(Key key, Node next){
            this.key = key;
            this.next = next;
        }
    }
    public void add(Key key){
        if(!contains(key)){
            first = new Node(key, first);
            N++;
        }
    }
    public void delete(Key key){
        first = delete(first, key);
    }
    private Node delete(Node x, Key key){
        if(x == null) return null;
        if(key.equals(x.key))
            return x.next;
        return delete(x.next, key);
    }
    public boolean contains(Key key){
        for(Node x = first; x != null; x = x.next){
            if(key.equals(x.key))
                return true;
        }
        return false;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public int size(){
        return N;
    }
    public Iterable<Key> keys(){
        Stack<Key> stack = new Stack<Key>();
        for(Node x = first; x != null; x = x.next)
            stack.push(x.key);
        return stack;
    }
    public String toString(){
        String s = " ";
        for(Key key : keys())
            s = s + key.toString();
        return s;
    }
     public Iterator<Key> iterator(){
        return new ListIterator();
    }
    
    public class ListIterator implements Iterator<Key>{
        private Node current = first;
        public boolean hasNext(){
            return current != null;
        }
        
        public Key next(){
            Key key = current.key;
            current =  current.next;
            return key;
        }
        
        public void remove(){}
    }
    public static void main(String[] args){
        SET<String> set = new SET<String>();
        while(!StdIn.isEmpty()){
            String key = StdIn.readString();
            if(!set.contains(key)){
                set.add(key);
                StdOut.println(key);
            }
        }
        System.out.println(set.toString());
    }
}