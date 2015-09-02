public class QuickFindUF{
    private int[] id;
    private int count;
    
    public QuickFindUF(int N){
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
        return id[p];
    }
    
    public void union(int p, int q){
        int pID = find(p);
        int qID = find(q);
        
        if(pID == qID) return;
        for(int i = 0; i < id.length; i++)
            if(id[i] == pID) id[i] = qID;
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
    }
    public static void main(String[] args){
        int N = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(N);
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

/*
 * Exercise 1_5_1
 * C:\Users\ngunti\algs4\FundamentalsOfProgramming\CaseStudy-UnionFind>java-algs4 QuickFindUF 10 < exercise.txt
9 0
3 4
5 8
7 2
2 1
5 7
0 3
4 2
0 1 2 3 4 5 6 7 8 9
1 1 1 1 1 1 6 1 1 1
2 Components
 */