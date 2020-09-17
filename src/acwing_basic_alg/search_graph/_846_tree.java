package acwing_basic_alg.search_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _846_tree {
    static int n;
    static int res;
    static Set<Integer> st = new HashSet<>();
    static List<Integer>[] g;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        g = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]), b = Integer.parseInt(line[1]);
            g[a].add(b);
            g[b].add(a);
        }

        res = n;
        dfs(1);
        System.out.println(res);
    }

    static int dfs(int u) {
        st.add(u);

        int cnt = 1;
        int max = 0;
        for (int i : g[u]) {
            if (!st.contains(i)) {
                int subcnt = dfs(i);
                cnt += subcnt;
                max = Math.max(subcnt, max);
            }
        }

        max = Math.max(max, n - cnt);
        // System.out.println("max point is " + max);
        res = Math.min(res, max);
        // System.out.println("min max point is " + res);
        return cnt;
    }
}
