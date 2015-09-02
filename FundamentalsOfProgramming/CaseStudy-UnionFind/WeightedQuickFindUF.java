public class WeightedQuickFindUF{
    int[] id;
    int[] sz;
    int count;
    
    public WeightedQuickUnionUF(int N){
        id = new int[N];
        sz = new int[N];
        count = N;
        for(int i = 0; i < N; i++){
            id[i] = i;
            sz[i] = 1;
        }            
    }
    
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    
    public int count(){
        return count;
    }
    
    public int find(int p){
        while(p != id[p])
            p = id[p];
        return p;
    }
    
    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        
        if(i == j) return;
        
        if(sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }
        else{
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }
    public void printID(){
        System.out.print("********* ");
        for(int i = 0; i< id.length; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("ID array: ");
        for(int i = 0; i< id.length; i++){
            System.out.print(id[i]+ " ");
        }
        System.out.println();
        System.out.print("SZ array: ");
        for(int i = 0; i< sz.length; i++){
            System.out.print(sz[i]+ " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int N = StdIn.readInt();
        WeightedQuickFindUF uf = new WeightedQuickFindUF(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p,q)) continue;
            uf.union(p,q);
            System.out.println(p + " " + q);
        }
        uf.printID();
        System.out.println(uf.count() + " Components");
    }
}