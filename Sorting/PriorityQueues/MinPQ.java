public class MinPQ<Key extends Comparable<Key>>{
    private int N = 0;
    private Key[] pq;
    
    public MinPQ(){
    }
    public MinPQ(int maxN){
        pq = (Key[])new Comparable[maxN+1];
    }
    
    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }
    public Key min(){
        return pq[1];
    }
    public Key delMin(){
        Key min = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null;
        return min;
    }
    
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    
    private void swim(int k){
        while(k > 1 && less(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }
    private void sink(int k){
        while(2*k <= N){
            int j = 2*k;
            if(j < N && less(j, j+1)) j++;
            if(!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    
    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) > 0;
    }
//    private void swim(int k){
//        while(k > 1 && more(k/2, k)){
//            exch(k/2, k);
//            k = k/2;
//        }
//    }
//    private void sink(int k){        
//        while(2*k <= N){
//            int j = 2*k;
//            if(j < N && more(j+1, j)) j++;
//            if(!more(k, j)) break;
//            exch(k, j);
//            k = j;
//        }
//    }
//    
//    private boolean more(int i, int j){
//        return pq[i].compareTo(pq[j]) > 0;
//    }
    private void exch(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }          
     public void show(){
        for(int i = 1; i <= N; i++){
            System.out.printf("%.4f ",pq[i]);                
        }
        System.out.println();
    }
     public static void main(String[] args){
        int M = 10;
        MinPQ<Double> pq = new MinPQ<Double>(M+1);
        for(int i = 0; i < 15; i++){
            pq.insert(StdRandom.uniform());
            if(pq.size() > M)
                System.out.println(pq.delMin());            
        }
        
        pq.show();
    }
}