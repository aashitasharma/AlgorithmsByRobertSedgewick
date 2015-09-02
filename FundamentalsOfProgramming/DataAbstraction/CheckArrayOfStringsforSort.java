public class CheckArrayOfStringsforSort{
    public static boolean isSorted(String[] a){
        for(int i = 1; i < a.length; i++){
            if(a[i-1].compareTo(a[i]) > 0)
                   return false;
        }
        return true;
    }
    public static void main(String[] args){
        String input = StdIn.readAll();
        String[] words = input.split("\\s+");
        if(isSorted(words))
            System.out.println("The array of strings is sorted");
        else
            System.out.println("The array of strings is not sorted");
    }
}
/*
 * C:\Users\ngunti\algs4\FundamentalsOfProgramming\DataAbstraction>java-algs4 CheckArrayOfStringsforSort < tinyTale.txt
 * The array of strings is not sorted
 */