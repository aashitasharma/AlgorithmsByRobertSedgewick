public class LinearProbingHashST<Key, Value>{
    private int N;
    private int M = 10;
    private Key[] keys;
    private Value[] vals;
    public LinearProbingHashST(int cap){
        this.M = cap;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }
    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }
    private void resize(int cap){
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<Key, Value>(cap);
        for(int i = 0; i < M; i++){
            if(keys[i] != null)
                t.put(keys[i], vals[i]);
            keys = t.keys;
            vals = t.vals;
            M = t.M;
        }
    }
    public void put(Key key, Value val){
        if(N >= M/2) resize(2*M);
        int i;
        System.out.println("Hash of " + key + " is "+hash(key));
        for(i = hash(key); keys[i] != null; i =(i+1)%M){
            if(keys[i].equals(key)){
                   vals[i] = val;
                   return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }
    public Value get(Key key){
        for(int i = hash(key); keys[i] != null; i = (i+1)%M){
            if(keys[i].equals(key))
                return vals[i];
        }
        return null;
    }
    public boolean contains(Key key){
        for(int i = hash(key); keys[i] != null; i = (i+1)%M){
            if(keys[i].equals(key))
                return true;
        }
        return false;
    }
    public void delete(Key key){
        if(!contains(key)) return;
        int i = hash(key);
        while(!key.equals(keys[i])){
            i = (i+1)%M;
        }
        keys[i] = null;
        vals[i] = null;
        while(keys[i] != null){
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i+1)%M;
        }
        N--;
        if(N > 0 && N == M/8) resize(M/2);
    }
    public void printHST(){
        for(int i = 0; i < M; i++){
            System.out.println(i+ " : " +keys[i] + ", " + vals[i]);
        }
    }
    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<Key>();
        for(int i = 0; i < M; i++)
            queue.enqueue(keys[i]);
        return queue;
    }
    public int size(){
        return M;
    }
    public static void main(String[] args){        
        LinearProbingHashST<String, Integer> hst = new LinearProbingHashST<String, Integer>(5);
        int i = 0;
        while(!StdIn.isEmpty()){
            hst.put(StdIn.readString(), i);
            i++;
        }
        hst.printHST();
        //hst.delete("Q");
        System.out.println();
        //hst.printHST();
    }
    
}