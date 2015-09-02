import java.io.File;
public class FileIndex{
    public static void main(String[] args){
        RedBlackBST<String, SET<File>> st = new RedBlackBST<String, SET<File>>();
        for(String filename : args){
            File file = new File(filename);
            In in = new In(file);
            while(!in.isEmpty()){
                String word = in.readString();
                if(!st.contains(word))
                    st.put(word, new SET<File>());
                SET<File> set = st.get(word);
                set.add(file);
            }
        }
        while(!StdIn.isEmpty()){
            String query = StdIn.readString();
            if(st.contains(query)){
                SET<File> set = st.get(query);
                for(File file : set)
                    System.out.println(" " +file.getName());
            }
        }
    }
}