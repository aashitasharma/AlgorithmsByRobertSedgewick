import java.util.Iterator;
public class Bag<Item> implements Iterable<Item>{
    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public void add(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N == 0;
    }
    
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    
    public class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current != null;
        }
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove(){
        }
    }
    public static void main(String[] args)
    {
        Bag<Double> numbers = new Bag<Double>();
        while (!StdIn.isEmpty())
            numbers.add(StdIn.readDouble());
        int N = numbers.size();
        double sum = 0.0;
        for (double x : numbers)
            sum += x;
        double mean = sum/N;
        sum = 0.0;
        for (double x : numbers)
            sum += (x - mean)*(x - mean);
        double std = Math.sqrt(sum/(N-1));
        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
    
}

/*
 * C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 Bag < doubles.txt
Mean: 34.50
Std dev: 42.30
 */