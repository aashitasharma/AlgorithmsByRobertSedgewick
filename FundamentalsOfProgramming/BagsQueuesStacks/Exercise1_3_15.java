public class Exercise1_3_15{
    public static void main(String[] args){
        int k = Integer.parseInt(args[0]);
        ResizingArrayQueue<String> q = new ResizingArrayQueue<String>();
        q.enqueue("1");
        q.enqueue("2");
        q.enqueue("3");
        q.enqueue("4");
        q.enqueue("5");
        q.enqueue("6");
        q.enqueue("7");
        System.out.println(q.kthFromLast(k));
    }
}