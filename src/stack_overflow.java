public class stack_overflow {
  public static void getNum(int m, int target) {
    if (m == 0) {
      System.out.println(0);
    }

    System.out.println(target);
    getNum(m - 1, target  +1);
  }

  /**
   * stack overflow for around 7000 methods call
   * @param args
   */
  public static void main(String[] args) {
    getNum(Integer.MAX_VALUE, 0);
  }
}
