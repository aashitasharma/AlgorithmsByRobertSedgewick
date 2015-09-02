public class SeparateChainingHashSTNew<Key, Value>{
    private int M = 97;
    private static int N;
    private Node[] st = new Node[M];
    private static class Node{
        private Object key;
        private Object val;
        private Node next;
        private int k;
        public Node(Object key, Object val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
            this.k = N++;
        }
        private void print(){
            System.out.printf("Node :  %s %d %x %d\n", key, val, next, k);
        }
    }
//    public SeparateChainingHashSTNew(int M){
//        this.M = M;
//        st = (SequentialSearchST<Key, Value>[])new SequentialSearchST[M];
//        for(int i = 0; i < M; i++){
//            st[i] = new Node();
//        }
//    }
    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public Value get(Key key){
        int i = hash(key);
        for(Node x = st[i]; x != null; x = x.next)
            if(key.equals(x.key)) return (Value)x.val;
        return null;
    }
    public boolean contains(Key key){
        return get(key) != null;
    }
    public void put(Key key, Value val){
        int i = hash(key);
        for(Node x = st[i]; x != null; x = x.next){
            if(key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        st[i] = new Node(key, val, st[i]);
    }
    
    public void printHST(){        
        for(int i = 0; i < M; i++){
            if(st[i] != null)
            System.out.println("At " + i + "[" + st[i].key +","+st[i].val+"] " + st[i].k); 
            
        }
    }
    public static void main(String[] args){        
        SeparateChainingHashSTNew<String, Integer> hst = new SeparateChainingHashSTNew<String, Integer>();
        int i = 0;
        while(!StdIn.isEmpty()){
            hst.put(StdIn.readString(), i);
            i++;
        }
        hst.printHST();
        
    }
}
/*
 * C:\Users\ngunti\algs4\Searching\HashTables>java-algs4 SeparateChainingHashSTNew < 341.txt
At 65[A,1]
At 69[E,0]
At 73[I,7]
At 78[N,9]
At 79[O,8]
At 81[Q,4]
At 83[S,2]
At 84[T,6]
At 85[U,5]
At 89[Y,3]
 */