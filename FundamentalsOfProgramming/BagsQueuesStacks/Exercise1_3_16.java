public class Exercise1_3_16{
    public static Date[] readDates(String name)
    {
        In in = new In(name);
        Queue<Date> q = new Queue<Date>();
        while (!in.isEmpty())
            q.enqueue(new Date(in.readString()));
        int N = q.size();
        Date[] a = new Date[N];
        for (int i = 0; i < N; i++)
            a[i] = q.dequeue();
        return a;
    }
    
    public static void main(String[] args){
        Date[] a = readDates(args[0]);
        for(Date i : a){
            System.out.println(i);
        }
    }
}

