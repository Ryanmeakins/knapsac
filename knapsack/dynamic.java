
import java.util.*;
public class dynamic {

   public void findValue(int[] values, int[] weights, int cap) {
      int items = values.length;
      int[][] table = new int[items+1][cap+1];
      for(int i=1; i<=items; i++) {
         for(int j=0; j<=cap; j++) {
            if(j<weights[i-1]) {
                  table[i][j] = table[i-1][j];
            }
            else {
               table[i][j] = Math.max(table[i-1][j], values[i-1]+table[i-1][j-weights[i-1]]);
            }
         }
      }
      System.out.println("dynamic: "+table[items][cap]);

      int ms = items;
      int c = cap;
      int sacW = 0;
      ArrayList<Integer> inSac = new ArrayList<Integer>();
      while(c>0) {
         if(table[ms][c] == table[ms-1][c]) {
            ms--;
         }
         else {
            inSac.add(ms);
            c -= weights[ms];
            sacW += weights[ms];
            ms--;
         }
      }
      for(Integer x: inSac) {
         System.out.println(x);
      }
      System.out.println("dynamic weight: "+sacW);
   }
}
