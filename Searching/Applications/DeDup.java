public class DeDup{
    public static void main(String[] args){
        SET<String> set = new SET<String>();
        while(!StdIn.isEmpty()){
            String key = StdIn.readString();
            if(!set.contains(key)){
                set.add(key);
                System.out.println(key);
            }
        }
    }
}