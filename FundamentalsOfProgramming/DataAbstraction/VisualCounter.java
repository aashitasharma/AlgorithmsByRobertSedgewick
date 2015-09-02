public class VisualCounter{
    private final int maxNumberOfOperations;
    private final int maxAbsVal;
    private int count;
    private int N;
    public VisualCounter(int N, int max){
        maxNumberOfOperations = N;
        maxAbsVal = max;
        StdDraw.setXscale(0, max);
        StdDraw.setYscale(0, N);
        StdDraw.setPenRadius(0.02);
    }
    
    public void increment(){
        if(count+1 <= maxAbsVal){
            if(N < maxNumberOfOperations){
                count++;
                N++;
                StdDraw.setPenColor(StdDraw.GREEN);
                StdDraw.point(count, count);
            }           
            else
            {
                System.out.println("Reached max Number of Operations");
            }
        }
        else{
            System.out.println("Count will exceed max AbsVal");
        }
    }
    
    public void decrement(){
        if(N < maxNumberOfOperations){
            count--;
            N++;
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(count,count);
        }     
        else{
            System.out.println("Reached max Number of Operations");
        }
    }
    
    public int tally(){        
        return count;
    }
    
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);
        VisualCounter v = new VisualCounter(N, max);
        for(int i = 0; i < N/2; i++){
            v.increment();
            System.out.println(v.tally());
        }
        for(int j = 0; j< N/4; j++)
        {
            v.decrement();
            System.out.println(v.tally());
        }
    }
    
}