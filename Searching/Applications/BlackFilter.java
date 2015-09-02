public class BlackFilter{
    public static void main(String[] args){
        SET<String> set = new SET<String>();
        In in = new In(args[0]);
        while(!in.isEmpty()){
            String key = in.readString();
            set.add(key);
        }
        while(!StdIn.isEmpty()){
            String word = StdIn.readString();
            if(!set.contains(word))
                System.out.println(word);
        }
    }
}