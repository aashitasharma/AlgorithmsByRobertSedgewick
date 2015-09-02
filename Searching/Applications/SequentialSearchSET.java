public class SequentialSearchSET<Key extends Comparable<Key>> {
    private Node first;
    private int N;
    private class Node{
        private Key key;
        Node next;
        public Node(Key key, Node next) {
            this.key = key;
            this.next = next;
        }
    }
    public void add(Key key) {
        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.key)) return;
        first = new Node(key, first);
        N++;
    }
    public int size(){
        return N;
    }
    public boolean contains(Key key) {
        for(Node x = first; x != null; x = x.next){
            if(key.equals(x.key))
                return true;
        }
        return false;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    public void delete(Key key) {
        first = delete(first, key);
    }
    private Node delete(Node x, Key key){
        if(x == null) return null;
        if(key.equals(x.key)) return x.next;
        return delete(x.next, key);
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
            s = s + " " + key.toString();
        return s;
    }
    public static void main(String[] args){
        SequentialSearchSET<String> set = new SequentialSearchSET<String>();
        
        while(!StdIn.isEmpty()){
            String key = StdIn.readString();
            if(!set.contains(key)){
                set.add(key);
                //StdOut.println(key);
            }
        }
        System.out.println(set.toString());
    }
}