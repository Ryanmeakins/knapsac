public class driver {

   public static void main(String[] args) {
      int[] values = new int[]{91,60,61,9,79,46,19,57,8,84,20,72,32,31,28,81,55,43,100,27};
      int[] weights = new int[]{29,65,71,60,45,71,22,97,6,91,57,60,45,89,2,30,90,25,82,19};
      int cap = 524;

      brute foo = new brute();
      foo.findValue(values, weights, cap);

      //greedy bar = new greedy();
      //bar.findValue(values, weights, cap);

      dynamic dyn = new dynamic();
      dyn.findValue(values, weights, cap);
   }
}
