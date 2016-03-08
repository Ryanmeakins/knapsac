

import java.util.*;
public class brute {

   public void findValue(int[] values, int[] weights, int cap) {
      int items = values.length;
      int[] bits = new int[items];
      int[] bestItems = new int[items];
      int bestValue=0, bestWeight=0;
      for(int i =0; i<Math.pow(2, items); i++) {
         int j=items-1;
         int tmpWeight=0;
         int tmpValue=0;
         while(bits[j] !=0 && j>0) {
            bits[j] = 0;
            j--;
         }
         bits[j]=1;
         for(int k=0; k<items; k++) {
            if(bits[k]==1) {
               tmpWeight += weights[k];
               tmpValue += values[k];
            }
         }
         if((tmpValue>bestValue)&&(tmpWeight<=cap)) {
            bestValue = tmpValue;
            bestWeight = tmpWeight;

            for(int t=0;t<items;t++) {
               bestItems[t] = bits[t];
            }
         }
      }
      System.out.println("best value; "+bestValue);
      System.out.println("weight; "+bestWeight);
      for(int x=0; x<items; x++) {
         System.out.print(bestItems[x]);
      }
      for(int i=0; i<items; i++) {
         if(bestItems[i] == 1) {
            System.out.println("\nitem "+(i+1)+" is in the sack");
         }
      }
   }
}
