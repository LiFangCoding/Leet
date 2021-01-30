package acwing_basic_alg;

public class test {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            try {
                System.out.println(i++);
                if (i > 3) {
                    throw new Exception("hell");
                }
                return;
            } catch (Exception e) {
                System.out.println("here is error");
            }

        }
    }
}
