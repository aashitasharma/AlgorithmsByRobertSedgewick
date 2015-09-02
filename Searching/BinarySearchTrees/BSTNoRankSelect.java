public class BSTNoRankSelect<Key extends Comparable<Key>,Value>{
    private Node root;
    private class Node{
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        
        public Node(Key key, Value val){
            this.key = key;
            this.val = val;
        }
    }
    
    public int size(){
        return size(root);
    }
    public int size(Node x){
        if(x == null) return 0;
        return 1 + size(x.left) +  size(x.right);
    }
    
    public Value get(Key key){
        return get(root, key);
    }
    private Value get(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp<0) return get(x.left, key);
        else if(cmp>0) return get(x.right, key);
        else return x.val;
    }
    
    public void put(Key key, Value val){
        root = put(root, key, val);
    }
    private Node put(Node x, Key key, Value val){
        if(x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = put(x.left, key, val);
        else if(cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        return x;
    }
    
    public Key min(){
        return min(root).key;
    }
    private Node min(Node x){
        if(x.left == null) return x;
        return min(x.left);
    }
    
    public Key max(){
        return max(root).key;
    }
    private Node max(Node x){
        if(x.right == null) return x;
        return max(x.right);
    }
    
    public Key floor(Key key){ 
        Node x = floor(root, key); 
        if(x == null) return null;
        return x.key;
    }
    private Node floor(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        else if(cmp < 0) return floor(x.left, key);
        else{
            Node t = floor(x.right,key);
            if(t != null) return t;
            else return x;
        }
    }
    
    public Key ceiling(Key key){
        Node x = celing(root, key);
        if(x == null) return null;
        return x.key;
    }
    private Node celing(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        else if(cmp > 0) return floor(x.right, key);
        else{
            Node t = celing(x.left, key);
            if(t != null) return t;
            else return x;
        }
    }
    
    public void deleteMin(){
        root = deleteMin(root);
    }
    private Node deleteMin(Node x){
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }
    
    public void deleteMax(){
        root = deleteMax(root);
    }
    private Node deleteMax(Node x){
        if(x.right == null) return x.left;
        x.right = deleteMax(x.right);
        return x;
    }
    
    public void delete(Key key){
        root = delete(root, key);
    }
    private Node delete(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = delete(x.left, key);
        else if(cmp > 0) x.right = delete(x.right, key);
        else{
            if(x.right == null) return x.left;
            if(x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }
    
    public void show(){
        Iterable<Key> l = this.keys();
        for (Key k : l) {
            System.out.printf(k + " ");
        }
        System.out.println();
    }
    
    public Iterable<Key> keys(){
        return keys(min(), max());
    }
    public Iterable<Key> keys(Key lo,Key hi){
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi){
        if(x == null) return ;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if(cmplo < 0) keys(x.left, queue, lo, hi);
        if(cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if(cmphi > 0) keys(x.right, queue, lo, hi);
    }
    
    public static void main(String[] args){
        BSTNoRankSelect<String, Integer> st = new BSTNoRankSelect<String, Integer>();
        for(int i = 0; !StdIn.isEmpty(); i++){
            String key = StdIn.readString();
            st.put(key, i);
        }
        for(String s: st.keys()){
            System.out.println(s + " " + st.get(s));
        }
         System.out.println("Minimum Element " + st.min());
        System.out.println("Maximum Element " + st.max());
        System.out.println("Floor of Element " + args[0] + " is " + st.floor(args[0]));
        System.out.println("Ceiling of Element " + args[0] + " is " + st.ceiling(args[0]));
        
        st.delete(args[0]);
        System.out.println("After deleting " + args[0]);
        st.show();
        st.deleteMax();
        System.out.println("After deleting Max ");
        st.show();
        st.deleteMin();
        System.out.println("After deleting Min ");
        st.show();
    }
    
}

/*
 * Exercise3_2_12
 * C:\Users\ngunti\algs4\Searching\BinarySearchTrees>java-algs4 BSTNoRankSelect  M < 321.txt
A 1
E 6
I 9
N 11
O 10
Q 4
S 7
T 8
U 5
Y 3
Minimum Element A
Maximum Element Y
Floor of Element M is I
Ceiling of Element M is I
After deleting M
A E I N O Q S T U Y
After deleting Max
A E I N O Q S T U
After deleting Min
E I N O Q S T U
 */