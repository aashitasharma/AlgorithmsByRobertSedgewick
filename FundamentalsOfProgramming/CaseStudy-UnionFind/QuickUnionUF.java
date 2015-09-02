public class QuickUnionUF{
    private int[] id;
    private int count;
    
    public QuickUnionUF(int N){
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++)
            id[i] = i;
    }
    
    public int count(){
        return count;
    }
    
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    
    public int find(int p){
        while(p != id[p])
            p = id[p];
        return p;
    }
    
    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
        
        id[pRoot] = qRoot;
        count--;
    }
    public void printID(){
        for(int i = 0; i< id.length; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 0; i< id.length; i++){
            System.out.print(id[i]+ " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args){
        int N = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p,q)) continue;
            uf.union(p,q);
            
            System.out.println(p + " " + q);

        }

        uf.printID();
        System.out.println();
        System.out.println(uf.count() + " Components");
    }
}
/*Exercise1_5_2
 *
 C:\Users\ngunti\algs4\FundamentalsOfProgramming\CaseStudy-UnionFind>java-algs4 QuickUnionUF<exercise.txt
9 0
3 4
5 8
7 2
2 1
5 7
0 3
4 2
0 1 2 3 4 5 6 7 8 9
4 1 1 4 1 8 6 2 1 0

2 Components
 */