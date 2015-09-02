public class Exercise1_3_17{
    public static Transaction[] readTransactions(String name)
    {
        In in = new In(name);
        Queue<Transaction> q = new Queue<Transaction>();
        while (!in.isEmpty())
            q.enqueue(new Transaction(in.readLine()));
        int N = q.size();
        Transaction[] a = new Transaction[N];
        for (int i = 0; i < N; i++)
            a[i] = q.dequeue();
        return a;
    }
    
    public static void main(String[] args){
        Transaction[] a = readTransactions(args[0]);
        for(Transaction i : a){
            System.out.println(i);
        }
    }
}
/*
 * C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 Exercise1_3_17 transaction.txt
Name: Jyothi
Date: 3/4/1988
Amount: 100.0

Name: Sravani
Date: 12/4/1991
Amount: 100.0

Name: xxxxxxx
Date: 1/3/2015
Amount: 98.0

 */