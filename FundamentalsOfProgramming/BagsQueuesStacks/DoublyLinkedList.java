import java.util.Iterator;
public class DoublyLinkedList<Item> implements Iterable<Item>{
    private DoubleNode first;
    private DoubleNode last;
    private int N;
    
    private class DoubleNode{
        private DoublyLinkedList<Item> parent = list();
        Item item;
        DoubleNode prev;
        DoubleNode next;
    }
    private DoublyLinkedList<Item> list()
    {
        return this;
    }
    
    public DoublyLinkedList(){
        first = null;
        last = null;
    }
    
    public DoublyLinkedList(Item[] a){
        for(Item t : a)
            append(t);
    }
    
    public DoublyLinkedList(Iterable<Item> a){
        for(Item t : a)
            append(t);
    }
    public boolean isEmpty(){
        return first == null;
    }
    
    public int size(){
        return N;
    }
    
    public Item first()
    {
        if(isEmpty()) throw new RuntimeException("List is Empty");
        return first.item;
    }
    
    public Item last(){
        if(isEmpty()) throw new RuntimeException("List is Empty");
        return last.item;
    }
    
    public DoubleNode node(int k){
        DoubleNode current = null;
        int i = 1;
        if(k > 0){
            current = first;
            while(i < k && current != null){
                current = current.next;
                i++;
            }
        }
        else if(k < 0){
            k = -k;
            current = last;
            while(i < k && current != null){
                current = current.prev;
                i++;
            }
        }
        return current;
    }
    
    //Insert at the beginning
    public void prepend(Item item){
        DoubleNode n = new DoubleNode();
        n.item = item;
        if(isEmpty()){
            first = n;
            last = n;
        }
        else{
            n.next = first;
            first.prev = n;
            first = n;
        }
        N++;
    }
    
    /*
     * Insert at end
     */
    public void append(Item item){
        DoubleNode n = new DoubleNode();
        n.item = item;
        if(isEmpty()){
            first = n;
            last = n;
        }
        else{
            last.next = n;
            n.prev = last;
            last = n;
        }
        N++;
    }
    
    /*
     * Remove from the begining
     */
    public Item removeFirst(){
        if(isEmpty()) throw new RuntimeException("List is Empty");
        
        Item item = first.item;
        first.parent = null;
        
        if(first.next != null) first.next.prev = null;
        first = first.next;
        N--;
        
        if(first == null) last = null;
        return item;
    }
    
    /*
     * Remove from the end
     */
    public Item removeLast(){
        if(isEmpty()) throw new RuntimeException("List is Empty");
        
        Item item = last.item;
        last.parent = null;
        
        if(last.prev != null) last.prev.next = null;
        last = last.prev;
        N--;
        
        if(last == null) first = null;
        return item;
    }
    
    /*
     * Insert before a given node
     */
    public void insertBefore(DoubleNode node, Item item){
        if(node.parent != this)
            throw new RuntimeException("Node does not belong to list");
        if(node == first)
            prepend(item);
        else{
            DoubleNode prev = node.prev; // prev=3--- n=4---node=5
            
            DoubleNode n = new DoubleNode();            
            n.item = item;                        
            n.prev = prev;
            n.next = node;
            
            prev.next = n;
            node.prev = n;
            N++;
        }                
    }
    
    /*
     * Insert after a given node
     */
    public void insertAfter(DoubleNode node, Item item){
        if(node.parent != this)
            throw new RuntimeException("Node does not belong to list");
        if(node == last)
            append(item);
        else{
            DoubleNode next = node.next; // node=3 --- n=4 ---- next=5 
            
            DoubleNode n = new DoubleNode(); 
            n.item = item;
            n.prev = node;
            n.next = next;
            
            node.next = n;
            next.prev = n;
            N++;
        }
    }
    
    /*
     * Remove a given Node
     */
    public Item remove(DoubleNode node){
        if(node.parent != this)
            throw new RuntimeException("Node does not belong to list");
        if(node == first) return removeFirst();
        else if(node == last) return removeLast();
        else {
            node.parent = null;
            
            //prev = 3 ---- node=4 ---- next=5
            DoubleNode prev = node.prev;
            DoubleNode next = node.next;
            
            prev.next = next;
            next.prev = prev;
            N--;
            return node.item;
        }
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(Item t : this)
            s.append(t + "  ");
        return s.toString();
    }
    
    public Iterator<Item> iterator(){
        return new DoubleListIterator();
    }
    public class DoubleListIterator implements Iterator<Item>{
        DoubleNode current = first;
        public boolean hasNext(){
            return current.next != null;
        }
        public Item next(){
            Item item = current.item;
            current  = current.next;
            return item;
        }
        public void remove(){}              
    }
    
     /**
     * Used in unit tests, to verify that the list is double-linked correctly.
     */
    public Iterable<Item> reversed()
    {
        return new ReverseIterable();
    }
    
    private class ReverseIterable implements Iterable<Item>
    {
        public String toString()
        {
            StringBuilder s = new StringBuilder();
            for (Item item : this)
                s.append(item + " ");
            return s.toString();
        }
        
        public Iterator<Item> iterator()
        {
            return new ReverseListIterator();  
        }
    
        private class ReverseListIterator implements Iterator<Item>
        {
            private DoubleNode current = last;
    
            public boolean hasNext()  { return current != null;                     }
            public void remove()      { throw new UnsupportedOperationException();  }
    
            public Item next()
            {
                //if (!hasNext()) throw new NoSuchElementException();
                Item item = current.item;
                current = current.prev;
                return item;
            }
        }
    }
    
    
    //Unit Tests
    private static void testPrepend()
    {
        StdOut.println("prepend:");
        
        int[] a = { 2, 4, 6, 8, 10 };
        DoublyLinkedList<Integer> lst = new DoublyLinkedList<Integer>();
        
        for (int i = 0; i < a.length; i++)
            lst.prepend(a[i]);
        showList(lst);
        StdOut.println();
    }
    
    private static void testAppend()
    {
        StdOut.println("append:");
        
        int[] a = { 2, 4, 6, 8, 10 };
        DoublyLinkedList<Integer> lst = new DoublyLinkedList<Integer>();
        
        for (int i = 0; i < a.length; i++)
            lst.append(a[i]);
        showList(lst);
        StdOut.println();
    }
    
    private static void testRemoveFirst()
    {
        StdOut.println("removeFirst:");
        DoublyLinkedList<Integer> lst = new DoublyLinkedList<Integer>(new Integer[] { 6, 8, 12 });
        StdOut.println(lst + "[initial]\n");
        
        while (!lst.isEmpty())
        {
            StdOut.println("removeFirst(): " + lst.removeFirst());
            showList(lst);
        }
        StdOut.println();
    }
    
     private static void testRemoveLast()
    {
        StdOut.println("removeLast:");
        DoublyLinkedList<Integer> lst = new DoublyLinkedList<Integer>(new Integer[] { 6, 8, 12 });
        StdOut.println(lst + "[initial]\n");
        
        while (!lst.isEmpty())
        {
            StdOut.println("removeLast(): " + lst.removeLast());
            showList(lst);
        }
        StdOut.println();
    }
    
    private static void testRemove()
    {
        StdOut.println("remove:");
        DoublyLinkedList<Integer> lst = new DoublyLinkedList<Integer>(new Integer[] { 2, 4, 6, 8 });
        StdOut.println(lst + "[initial]\n");
        
        int[] k = { 2, -1, 1, 1 };
        
        for (int i = 0; i < k.length; i++)
        {
            StdOut.printf("remove(node(%d)): %d\n", k[i], lst.remove(lst.node(k[i])));
            showList(lst);
        }
        StdOut.println();
    }
    
    private static void testInsertBefore()
    {
        StdOut.println("insertBefore:");
        DoublyLinkedList<Integer> lst = new DoublyLinkedList<Integer>(new Integer[] { 2, 4, 6, 8 });
        StdOut.println(lst + "[initial]\n");
        
        int[] k = {  3,  2,  1, -1 },
              x = { 10, 12, 14, 16 };
        
        for (int i = 0; i < k.length; i++)
        {
            StdOut.printf("insertBefore(node(%d), %d):\n", k[i], x[i]); 
            lst.insertBefore(lst.node(k[i]), x[i]);
            showList(lst);
        }
        StdOut.println();
    }
    
    private static void testInsertAfter()
    {
        StdOut.println("insertAfter:");
        DoublyLinkedList<Integer> lst = new DoublyLinkedList<Integer>(new Integer[] { 1, 3, 5, 7 });
        StdOut.println(lst + "[initial]\n");
        
        int[] k = { 2, -2, -1,  1 },
              x = { 9, 11, 13, 15 };
        
        for (int i = 0; i < k.length; i++)
        {
            StdOut.printf("insertAfter(node(%d), %d):\n", k[i], x[i]); 
            lst.insertAfter(lst.node(k[i]), x[i]);
            showList(lst);
        }
        StdOut.println();
    }
    
    private static void showList(DoublyLinkedList lst)
    {
        StdOut.println(lst);
        StdOut.println(lst.reversed() + "[in reverse]");
        if (!lst.isEmpty())
            StdOut.printf("Size: %d, First: %s, Last: %s\n\n", lst.size(), lst.first(), lst.last());
        else
            StdOut.printf("Size: %d\n\n", lst.size());
    }
    
    public static void main(String[] args){
//        testPrepend();
//        testAppend();
//        testRemoveFirst();
//        testRemoveLast();
//        testRemove();
        testInsertBefore();
        testInsertAfter();
        
    }
}