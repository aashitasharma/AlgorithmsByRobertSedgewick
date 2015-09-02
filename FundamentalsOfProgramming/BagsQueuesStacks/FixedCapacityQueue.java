public class FixedCapacityQueue<Item>{
    private Item[] a;
    private int N;
    private int first = 0;
    private int last = 0;
    public FixedCapacityQueue(int cap){
        a = (Item[])new Object[cap];
    }
    public void enqueue(Item item){
        a[last++] = item;
        N++;
    }
    public Item dequeue(){
        N--;
        return a[first++];
        
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public static void main(String[] args){
        FixedCapacityQueue<String> q = new FixedCapacityQueue<String>(100);
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-"))
                q.enqueue(item);
            else{
                if(!q.isEmpty()) System.out.print(q.dequeue() + " ");
            }
        }
        System.out.println();
        System.out.println("Size left on the Queue is " + q.size()); 
    }
}