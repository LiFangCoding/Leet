import java.util.ArrayList;
import java.util.List;

public class _990_Satisfiability_Equation_Equations {
    /**
     * 2ms
     */
    public boolean equationsPossible(String[] equations) {
        // step 1, build uf of all possible equal
        UF uf = new UF(26);
        List<Integer> notEqualList = new ArrayList<>();
        for (int i = 0; i < equations.length; i++) {
            String equation = equations[i];
            if (equation.charAt(1) == '!') {
                notEqualList.add(i);
            } else {
                // decode
                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';
                uf.union(a, b);
            }
        }
        // step 2, loop not equal, if find same, return false
        for (int i = 0; i < notEqualList.size(); i++) {
            String equation = equations[notEqualList.get(i)];
            int a = equation.charAt(0) - 'a';
            int b = equation.charAt(3) - 'a';
            if (uf.query(a, b)) {
                return false;
            }
        }
        return true;
    }

    class UF {
        int[] parents;
        int count;

        UF(int count) {
            parents = new int[count + 1];
            for (int i = 1; i <= count; i++) {
                parents[i] = i;
            }
        }

        int find(int p) {
            if (p == parents[p]) return p;
            return parents[p] = find(parents[p]);
        }

        void union(int p, int q) {
            int root_p = find(p);
            int root_q = find(q);
            if (root_p != root_q) {
                parents[root_p] = root_q;
            }
        }

        boolean query(int p, int q) {
            int root_p = find(p);
            int root_q = find(q);
            return root_p == root_q;
        }
    }
}
