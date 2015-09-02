public class ExtractFileName{
    public static void extract(String s){
        int dot = s.rank(".");
        String fileName = s.substring(0, dot);
        String extension = s.substring(dot+1,s.length());
        System.out.println("fileName is " + fileName);
        System.out.println("extension is " + extension);
    }
    public static void main(String[] args){
        String fileNameExt = args[0];
        extract(fileNameExt);
    }
}
/*
 * 
 */