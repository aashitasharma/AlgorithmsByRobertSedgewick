public class SeparateChainingHashST<Key, Value>{
    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] st;
    public SeparateChainingHashST(){
        this(997);
    }
    public SeparateChainingHashST(int M){
        this.M = M;
        st = (SequentialSearchST<Key, Value>[])new SequentialSearchST[M];
        for(int i = 0; i < M; i++){
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }
    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }
    private Value get(Key key){
        return (Value)st[hash(key)].get(key);
    }
    public void put(Key key, Value val){
        st[hash(key)].put(key, val);
        N++;
    }
    public void delete(Key key){
        int i = hash(key);
        System.out.println("Hash Function : " + i);
        if(st[i].contains(key)){
            System.out.println("Delete");
            st[i].delete(key);
            System.out.println("Deleted");
            N--;
        }
        //if(M > 997 && N <= 2*M) resize(M/2);
    }
//    private void resize(int cap){
//        SeparateChainingHashST<Key, Value> t = new SeparateChainingHashST<Key, Value>(cap);
//        for(int i = 0; i < M; i++)
//            t.st[i] = st[i];
//        st = t.st;
//        M = t.M;
//    }
    
    public void printHST(){        
        for(int i = 0; i < M; i++){
            System.out.print(i + " : ");
            for(Key key: st[i].keys()){
              System.out.print("[" +key + ", " + st[i].get(key)+"] ");
            }
            System.out.println();
        }
    }
//    public Iterable<SequentialSearchST> keys(){
//        for(int i = 0; i < M; i++)
//            
//    }
    public static void main(String[] args){        
        SeparateChainingHashST<String, Integer> hst = new SeparateChainingHashST<String, Integer>(5);
        int i = 0;
        while(!StdIn.isEmpty()){
            hst.put(StdIn.readString(), i);
            i++;
        }
        hst.printHST();
        hst.delete("Q");
        System.out.println();
        hst.printHST();
    }


}