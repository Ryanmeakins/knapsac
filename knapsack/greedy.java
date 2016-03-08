
import java.util.*;
public class greedy {

   public void findValue(int[] values, int[] weights, int cap) {
      int items = values.length;
      double[] valToWeight = new double[items];
      int[] item = new int[items];

      for(int i =0; i<items; i++) {
         item[i] = i;
      }      

      for(int i=0; i<items; i++) {
         valToWeight[i] = (double)values[i]/(double)weights[i];
      }
     
      for(int n=0; n<items; n++) {
         for(int m=0; m<items-1-n;m++) {
            if(valToWeight[m] < valToWeight[m+1]) {
               int swap = values[m];
               values[m] = values[m+1];
               values[m+1] = swap;

               swap = weights[m];
               weights[m] = weights[m+1];
               weights[m+1] = swap;

               double s = valToWeight[m];
               valToWeight[m] = valToWeight[m+1];
               valToWeight[m+1] = s;

               swap = item[m];
               item[m] = item[m+1];
               item[m+1] = swap;

            }
         }
      }

      int curWeight = 0;
      int curVal = 0;
      ArrayList<Integer> inSac = new ArrayList<Integer>();

      for(int i=0; i<items; i++) {
         //System.out.println("item "+(item[i]+1));
         //System.out.println("value "+values[i]);
         //System.out.println("weight "+weights[i]);
         if(curWeight+weights[i]<=cap) {
            inSac.add(item[i]+1);
            curVal += values[i];
            //System.out.println("curval "+curVal);
            curWeight += weights[i];
            //System.out.println("curweight "+curWeight);
         }
      }

      System.out.println("final items in sac");

      for(Integer x: inSac) {
         System.out.println(x);
      }     
 
      System.out.println("value; "+curVal);
      System.out.println("weight; "+curWeight);
     
   }
}
