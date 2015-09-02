public class Problem6_2{
    public static int findBatteryCapacity(int[] a){
        //need to maintain the running minimum of the sequence
        int capacity = 0;
        int minHeight = Integer.MAX_VALUE;
        for(int i = 0; i <  a.length; i++) {
            int height = a[i];
            capacity = Math.max(capacity, height - minHeight);
            minHeight = Math.min(minHeight, height);
        }
        return capacity;
    }
    public static void main(String[] args){
        int[] a = new int[StdIn.readInt()];
        int i = 0;
        int maxLen = 0;
        int count = 0;
        while(!StdIn.isEmpty()){
            a[i] = StdIn.readInt();
            i++;
        }
        
//        for(i = 0; i < a.length - 1; i++){
//            System.out.println("Count in outerloop = " + count);
//            for(int j = i + 1; j < a.length; j++){
//                System.out.println("Count in innerloop = " + count);
//                if(a[i] == a[j])
//                    count++;
//                else
//                    count = 0;
//                if(count > maxLen){
//                    maxLen = count;
//                    System.out.println("maxLen = " + maxLen);
//                }
//            }
//        }
        System.out.println("Battery Capacity: " + findBatteryCapacity(a));
            
    }
}