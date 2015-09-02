public class BinarySearchSET<Key extends Comparable<Key>> {
    private Key[] keys;
    private int N;
    public BinarySearchSET(int capacity) {
        keys = (Key[])new Comparable[capacity];
    }
    public int size(){
        return N;
    }
    public void add(Key key) {
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0)
            return;
        for(int j = N; j > i; j--){
            keys[j] = keys[j-1];
        }
        keys[i] = key;
        N++;
    }
    public int rank(Key key) {
        int lo = 0;
        int hi = N-1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0)
                hi = mid -1;
            else if(cmp > 0)
                lo = mid + 1;
            else
                return mid;            
        }
        return lo;
    }
    public boolean contains(Key key) {
        return rank(key) != 0;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public void delete(Key key) {
        if(isEmpty()) return;
        int i = rank(key);
        if(i == N || keys[i].compareTo(key) != 0)
            return;
        for(int j = i; j < N; j++)
            keys[j] = keys[j+1];
        N--;
        keys[N] = null;
    }
}