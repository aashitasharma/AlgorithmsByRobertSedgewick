public class BSTNoRecursive<Key extends Comparable<Key>, Value>{
    private Node root;
    private class Node{
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int N;
        
        public Node(Key key, Value val, int N){
            this.key = key;
            this.val = val;
            this.N = N;            
        }
    }
    
    public int size(){
        return size(root);
    }    
    private int size(Node x){
        if(x == null) return 0;
        else return x.N;
    }
    
    public Value get(Key key){
        Node x = root;
        while(x != null){
            int cmp = key.compareTo(x.key);
            if(cmp == 0) return x.val;
            else if(cmp < 0) x= x.left;
            else if(cmp > 0) x=x.right;            
        }
        return null;
    }
    
    public void put (Key key, Value val){
        Node z = new Node(key, val, 1);
        Node x = root;
        if(x == null){
            root = z;
            return;
        }
        Node parent = null;
        while(x != null){
            parent = x;
            int cmp = key.compareTo(x.key);
            if(cmp == 0){ x.val = val; return;}
            else if(cmp < 0) x = x.left;
            else if(cmp > 0) x = x.right; 
        }
        int cmp = key.compareTo(parent.key);
        if(cmp < 0) parent.left = z;
        else parent.right = z;
        x.N = 1 + size(x.left) + size(x.right);
    }
    
    public Key min(){
        Node x = min(root);
        if(x == null) return null;
        return x.key;
    }
    private Node min(Node x){
        Node t = x;
        while(t != null){
            if(t.left == null) break;
            t = t.left;
        }
        return t;
    }
    
    public Key max(){
        Node x = max(root);
        if(x == null) return null;
        return x.key;
    }
    private Node max(Node x){
        Node t = x;
        while(t != null){
            if(t.right == null) break;
            t = t.right;
        }
        return t;
    }
    
    public Key floor(Key key){
        Node x = floor(root, key);
        if(x == null) return null;
        return x.key;
    }
    private Node floor(Node x, Key key){
        Node t = null;
        Node r = x;
        while(r != null){
            int cmp = key.compareTo(r.key);
            if(cmp == 0) return r;
            else if(cmp < 0) r = r.left;
            else{
                t = r;
                r = r.right;
            }
        }
        return t;
    }
    
    public Key ceiling(Key key){
        Node x = ceiling(root, key);
        if(x == null) return null;
        return x.key;
    }
    private Node ceiling(Node x, Key key){
        Node t = null;
        Node r = x;
        while(r != null){
            int cmp = key.compareTo(r.key);
            if(cmp == 0) return r;
            else if(cmp > 0) r = r.right;
            else{
                t = r;
                r = r.left;
            }
        }
        return t;
    }
    
    public Key select(int k){
        Node t = select(root, k);
        if(t == null) return null;
        return t.key;
    }
    private Node select(Node x, int k){
        int t = k;
        Node r = x;
        while(r != null){
            int s = size(r.left);
            if(s == t) return r;
            else if(s > t) r = r.left;
            else{
                t = t - s + 1;
                r = r.right;
            }
        }
        return null;
    }
    
    public int rank(Key key){
        return rank(root, key);
    }
    private int rank(Node x, Key key){
        int t  = 0;
        Node r = x;
        while(r != null){
            int cmp = key. compareTo(r.key);
            if(cmp == 0)
                return t + size(r.left);                
            else if(cmp < 0) 
                r = r.left;                           
            else {
                t += size(r.left) + 1;
                r = r.right;
            }
        } 
        return t;
    }
    
    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        Node x = root;
        Stack<Node> s = new Stack<Node>();
        while(x != null || !s.isEmpty()){
            if(x != null){
                s.push(x);
                x = x.left;
            }else{
                x = s.pop();
                q.enqueue(x.key);
                x = x.right;
            }
        }
        return q;
    }
    
    public void show() {
        Iterable<Key> s = keys();
        for (Key key : s) {
            System.out.print(key + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args){
        BSTNoRecursive<String, Integer> st = new BSTNoRecursive<String, Integer>();
        for(int i = 0; !StdIn.isEmpty(); i++){
            String key = StdIn.readString();
            st.put(key, i);
        }
        for(String s: st.keys()){
            System.out.println(s + " " + st.get(s));
        }
        System.out.println("Minimum Element " + st.min());
        System.out.println("Maximum Element " + st.max());
//        System.out.println("Floor of Element " + args[0] + " is " + st.floor(args[0]));
//        System.out.println("Ceiling of Element " + args[0] + " is " + st.ceiling(args[0]));
        
        st.show();
    }
}