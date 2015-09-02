public class LookupIndex{
    public static void main(String[] args){
        In in = new In(args[0]);
        String sp = args[1];
        RedBlackBST<String, Queue<String>> st = new RedBlackBST<String, Queue<String>>();
        RedBlackBST<String, Queue<String>> ts = new RedBlackBST<String, Queue<String>>();
        while(in.hasNextLine()){
            String[] a = in.readLine().split(sp);
            String key = a[0];
            for(int i = 1; i < a.length; i++){
                String val = a[i];
                if(!st.contains(key))
                    st.put(key, new Queue<String>());
                if(!ts.contains(val))
                    ts.put(val, new Queue<String>());
                st.get(key).enqueue(val);
                ts.get(val).enqueue(key);
            }
        }
        while(!StdIn.isEmpty()){         
            String query =StdIn.readLine();            
            System.out.println(query);
                        System.out.println();
            if(st.contains(query)){               
                for(String s: st.get(query))
                    System.out.println(s);
            }
            System.out.println();
            if(ts.contains(query)){
                for(String s: ts.get(query))
                    System.out.println(s);
            }
                        System.out.println();
        }
    }
}