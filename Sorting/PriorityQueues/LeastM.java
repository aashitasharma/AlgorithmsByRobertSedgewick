public class LeastM{
    public static void main(String[] args){
        int M = Integer.parseInt(args[0]);
        MaxPQ<Transaction> pq = new MaxPQ<Transaction>(M+1);
        
        while(StdIn.hasNextLine()){
            pq.insert(new Transaction(StdIn.readLine()));
            if(pq.size() > M)
                pq.delMax();
        
        }
        Stack<Transaction> stack = new Stack<Transaction>();
        while(!pq.isEmpty()) stack.push(pq.delMax());
        for(Transaction t: stack)StdOut.println(t);
    }
}