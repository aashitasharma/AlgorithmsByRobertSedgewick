public class Problem5_4{
    public static int uniform_a_b(int a, int b){
        return a + StdRandom.uniform(b-a);
    }
    public static void main(String[] args){
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        System.out.println("Random number between " + p + " and " + q + " is " +
                           Problem5_5.uniform_a_b(p,q));
    }
}