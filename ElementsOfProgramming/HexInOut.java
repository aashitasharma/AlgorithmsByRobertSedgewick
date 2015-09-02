public class HexInOut { 
   public static void main(String[] args) { 
      short a = (short) Integer.parseInt(StdIn.readString(), 16);
      System.out.println("Decimal: " + a);
      System.out.println("Hex:     " + Integer.toHexString(a));

      a =  StdIn.readShort();
      System.out.println("Decimal: " + a);
      System.out.println("Hex:     " + Integer.toHexString(a));

   }
}
