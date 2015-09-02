public class SparseVector{
    private LinearProbingHashST<Integer, Double> st;
    public SparseVector(){
        this.st = new LinearProbingHashST<Integer, Double>();
    }
    public int size(){
        return st.size();
    }
    public void put(int i, double x){
        st.put(i, x);
    }
    public double get(int i){
        if(!st.contains(i)) return 0.0;
        else return st.get(i);
    }
    public double dot(double[] that){
        double sum = 0.0;
        for(int i : st.keys())
            sum += this.get(i)*that[i];
        return sum;
    }
    public static void main(String[] args){
        int N = 10;
        SparseVector[] a = new SparseVector[N];
        double[] x = new double[N];
        double[] b = new double[N];
        for(int i = 0; i < N; i++)
            b[i] = a[i].dot(x);
    }
}