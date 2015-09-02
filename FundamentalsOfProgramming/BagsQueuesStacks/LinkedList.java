import java.util.Iterator;
public class LinkedList<Item> implements Iterable<Item>{
    private Node first;
    private Node last;
    private int N;
    
    private class Node{
        Item item;
        Node next;
    }
    
    public LinkedList(){
        first = null;
        last = null;
    }
    
    public LinkedList(Item[] a){
        for(Item t: a)
            append(t);
    }
    
    public LinkedList(Iterable<Item> a){
        for(Item t : a)
            append(t);
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public int size(){
        return N;
    }
    
    public Item first(){
        if(isEmpty()) throw new RuntimeException("List is empty");
        return first.item;
    }
    
    public Item last(){
        if(isEmpty()) throw new RuntimeException("List is empty");
        return last.item;
    }
    
    public Item removeFirst(){
        if(isEmpty()) throw new RuntimeException("List is empty");       
        Item item = first.item;
        first = first.next;
        N--;
        if(isEmpty()) last = null;
        return item;
    }
    
    public void prepend(Item item){
        Node n = new Node();
        n.item = item;
        n.next = null;
        if(isEmpty()) {
            first = n;
            last = n;
        }
        else{
            n.next = first;
            first = n;
        }        
        N++;
    }
    
    public void append(Item item){
        Node n = new Node();
        n.item = item;
        n.next = null;
        if(isEmpty()){
            first = n;
            last = n;
        }
        else{
            last.next = n;
            last = n;
        }
        N++;
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(Item item : this)
            s.append(item+" ");
        return s.toString();
    }
    
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    
    public class ListIterator implements Iterator<Item> {
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
    
    /*
     * Exercise1_3_19
     */
    public Item removeLast(){
        if(isEmpty()) throw new RuntimeException("List is empty");
        if(first == last) return removeFirst();
        Item item = last.item;
        
        Node prev = null;
        Node current = first;
        while(current.next != null){
            prev = current;
            current = current.next;
        }
        prev.next = null;
        last = prev;
        N--;
        
        return item;
    }
      
    /*
     * Exercise1_3_20
     */
    public Item delete(int k){
        if(isEmpty()) throw new RuntimeException("List is empty");
        
        if(k < 0) k = 0;
        if(k > N) k = N;
        
        if(k == 0) return removeFirst();
        if(k == N) return removeLast();
        
        Node prev = null;
        Node current = first;
        for(int i = 1; i < k && current != null; i++){
            prev = current;
            current = current.next;
        }
        
        if(current != null){
            if(prev == null)
                first = current.next;
            else
                prev.next = current.next;
            
            if(current.next == null)
                last = prev;
            
            N--;
            
            return current.item;
        }
        else
            return null;
    }
    
    
    /*
     * Exercise1_3_21
     */
    public boolean find(Item item){      
        if(isEmpty()) throw new RuntimeException("List is empty");
        Node current = first;
        while(current != null && !current.item.equals(item)){
            current = current.next;
        }
        return current != null;
    }
    /*
     * Operation on Nodes
     */
    public Node node(int k){
        if(k < 1) return null;
        
        int i = 1;
        Node current = first;
        while(i < k && current != null)
        {
            current = current.next;
            i++;
        }
        return current;
    }
    public Node createNode(Item item){
        Node node = new Node();
        node.item = item;
        return node;
    }
    /*
     * Exercise1_3_24
     */ 
    
    public void removeAfter(Item item){
        if(isEmpty()) throw new RuntimeException("List is empty");
        if(last.item.equals(item)){
            
        }
        Node current = first;
        while(current.next != null){
            if(current.item.equals(item))
                current.next = current.next.next;
            current = current.next;
        }    
        N--;
    }
    
    public void removeAfter(Node node){
        if(node != null && node.next != null){
            if(node.next.next == null)
                last = node;
            node.next = node.next.next;
            N--;
        }
    }
    
    /*
     * Exercise1_3_25
     * Insert Item2 after item1
     */
    public void insertAfter(Item item1, Item item2){
        if(isEmpty()) throw new RuntimeException("List is empty");
        if(last.item.equals(item1)){ append(item2); return;}
        Node n = new Node();
        n.item = item2;
        n.next = null;
        Node current = first;
        while(current.next != null){
            if(current.item.equals(item1)){
                Node temp = current.next;
                current.next = n;
                n.next = temp;
            }
            current = current.next;
        }       
        N++;
    }
    public void insertAfter(Node a, Node b){
        if(a != null && b != null){
            if(last == a)
                last = b;
            b.next = a.next;
            a.next = b;
            N++;
        }
    }
    
    /*
     * Exercise1_3_26
     */
    public void remove(Item item){
        //Store all the indexes of the nodes equal to item and then delete using delete method
        LinkedList<Integer> idx = new LinkedList<Integer>();
        int i = 1;
        for(Item x : this){
            if(x.equals(item))
                idx.prepend(i);
            i++;
        }
        for(int k : idx)
            delete(k);
    }
    
    /*
     * Exercise1_3_27
     */
    public Item max(Node node){
        if(node == null) throw new RuntimeException("List is empty");
        return max(node, null);
    }
    public Item max(Node node, Item def){
        if(node == null) return def;
        Item maxResult =node.item;
        Node current = node;
        while(current.next != null){
            current = current.next;
            if(((Comparable)maxResult).compareTo(current.item) < 0)
                maxResult = currrent.item;
        }
        return maxResult;
    }
    
    /*
     * Exercise1_3_28
     */
    public Item maxRec(Node node, Item def){
        if(node == null) return def;
        else return maxRec(node);        
    }
    public Item maxRec(Node node){
        if(node == null) throw new RuntimeException("List is empty");
        if(node.next == null) return node.item;
        else{
            Item maxResult = maxRec(node.next);
            return ((Comparable)node.item).compareTo(maxResult) > 0 ? node.item : maxResult;
        }        
    }
    
    /*
     * Exercise1_3_29
     * Separate file
     */
    
    /*
     * Exercise1_3_30
     */
    public Node reverseIterative(Node x){
        Node first = x;
        Node reverse = null;
        while(first != null){
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }
    public Node reverseRecursive(Node first){
        if(first == null) return null;
        if(first.next == null) return first;
        Node second = first.next;
        Node rest = reverseRecursive(second);
        second.next = first;
        first.next = null;
        return rest;
    }
    
    
    public static void main(String[] args){
        LinkedList<String> l =  new LinkedList<String>();
        while(!StdIn.isEmpty()){
            l.append(StdIn.readString());
        }
        //System.out.println(l.delete(2));
        System.out.println(l);
        
//        if(l.find("that")){
//            System.out.println("Found the given key");
//        }
//        else{
//            System.out.println("Not Found the given key");
//        }
        
        l.removeAfter("a");
        System.out.println(l);
        
        l.insertAfter("a","it");
        System.out.println(l);
        
        l.insertAfter("at","it");
        System.out.println(l);
        
    }
}
/*
 * 1_3_20
 C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 LinkedList < list.txt
 it
 at be a was the is we
 
 * 1_3_21
 C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 LinkedList < list.txt
 at be it a was the is we
 Found the given key
 
 C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>javac-algs4 LinkedList.java
 C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 LinkedList < list.txt
 at be it a was the is we
 Not Found the given key
 
 * 1_3_24
 C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 LinkedList < list.txt
we is the was a it be at
we is the was a be at

* 1_3_25
C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 LinkedList < list.txt
we is the was a it be at
we is the was a be at
we is the was a it be at
we is the was a it be at it

 * 1_3_26
 * 1_3_27
 * 1_3_28
 * 1_3_29
 * 1_3_30
 * 1_3_31
 * 
 */