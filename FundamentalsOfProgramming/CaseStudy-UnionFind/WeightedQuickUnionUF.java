public class WeightedQuickUnionUF{
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
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
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
/*
 * Exercise 1_5_3
 * C:\Users\ngunti\algs4\FundamentalsOfProgramming\CaseStudy-UnionFind>java-algs4 WeightedQuickUnionUF < exercise.txt
 9 0
 3 4
 5 8
 7 2
 2 1
 5 7
 0 3
 4 2
 0 1 2 3 4 5 6 7 8 9
 ID array: 9 7 7 9 3 7 6 7 5 7
 SZ array: 1 1 1 2 1 2 1 9 1 4
 2 Components
 
 Exercise1_5_4
 C:\Users\ngunti\algs4\FundamentalsOfProgramming\CaseStudy-UnionFind>java-algs4 WeightedQuickUnionUF < tinyUF.txt
4 3
3 8
6 5
9 4
2 1
5 0
7 2
6 1
********* 0 1 2 3 4 5 6 7 8 9
ID array: 6 2 6 4 4 6 6 2 4 4
SZ array: 1 1 3 1 4 1 6 1 1 1
2 Components

 */