import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _996_Number_of_Squareful_Arrays {
    int ans;
    List<Integer> cur;
    boolean[] marked;

    public static void main(String[] args) {
        _996_Number_of_Squareful_Arrays test = new _996_Number_of_Squareful_Arrays();
        int[] A = new int[]{65, 44, 5, 11};

        System.out.println(test.isSquare(11, 44));

        System.out.println(test.numSquarefulPerms(A));
    }

    public int numSquarefulPerms(int[] A) {
        ans = 0;
        cur = new ArrayList<>();
        marked = new boolean[A.length];

        // make same values together
        Arrays.sort(A);
        dfs(A);
        return ans;
    }

    private void dfs(int[] A) {
        if (cur.size() == A.length) {
            System.out.println("find ans, the list is " + cur);
            ans++;
            return;
        }

        System.out.println("cur list is " + cur);

        for (int i = 0; i < A.length; i++) {
            // avoid duplicates [2,2]
            if (i > 0 && A[i] == A[i - 1] && !marked[i - 1]) {
                continue;
            }
            if (!marked[i]) {
                // check perfect square
                boolean isSquareful = (cur.size() > 0 && isSquare(cur.get(cur.size() - 1), A[i]));
                if (cur.size() == 0 || isSquareful) {
                    marked[i] = true;
                    cur.add(A[i]);
                    dfs(A);
                    cur.remove(cur.size() - 1);
                    marked[i] = false;
                }
            }
        }
    }

    private boolean isSquare(int a, int b) {
        int sum = a + b;
        double root = Math.sqrt(sum);
        return root - (int) root == 0;
    }
}
