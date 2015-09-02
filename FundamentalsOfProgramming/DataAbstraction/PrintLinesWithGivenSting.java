public class PrintLinesWithGivenSting{
    public static void main(String[] args){
        String query = args[0];
        while(!StdIn.isEmpty()){
            String s = StdIn.readLine();
            if(s.contains(query))
                System.out.println(s);
        }
    }
}
/*
 * java-algs4 PrintLinesWithGivenSting season < tinyTale.txt
 * the season of light it was
 * the season of darkness
 */