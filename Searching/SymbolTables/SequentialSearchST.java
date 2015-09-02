public class SequentialSearchST<Key, Value>{
    private Node first;
    private class Node{
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }    
    public Value get(Key key){
        for(Node x = first; x != null; x = x.next){
            if(key.equals(x.key))
                return x.val;
        }
        return null;
    }
    
    public void put(Key key, Value val){
        for(Node x = first; x != null; x = x.next){
            if(key.equals(x.key))
                x.val = val;
        }
        first = new Node(key, val, first);
    }
    
//    public boolean contains(Key key){
//        for(Node x = first; x != null; x = x.next){
//            if(key.equals(x.key))
//                return true;
//        }
//        return false;
//    }
//    
//    public void delete(Key key){
//       Node x = first;
//       Node p = x.next;
//       while(x.next != null){
//           if(key.equals(p.key)){
//                x.next = p.next;
//                return;
//           }         
//           else{
//               x = p;
//               p = p.next;
//           }                
//       }
//    }
    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<Key>();
        for(Node x = first; x != null; x = x.next)
                queue.enqueue(x.key);
        return queue;
            
    }
    public static void main(String[] args){
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        int i = 0;
        while(!StdIn.isEmpty()){
            st.put(StdIn.readString(), i);
            i++;
        }
        for(String key: st.keys())
            System.out.println(key + " " + st.get(key));
    }
}