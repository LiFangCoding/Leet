package acwing_basic_alg._05_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2_01 {
    public static void main(String[] args) {
        int i = 0, j = 1;
        int[][] f = new int[2][2];
//        System.out.printf("i %d j d% f %d %n", i, j, f[i][j]);
        System.out.printf("i %d, j %d %n", i, j);
    }

    // f[i][v] = max(f[i - 1][v], f[i - 1][v - vi] + wi)
    public static class Main {
        static int N, V;
        static int[] v, w;
        static int[][] f;

        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String[] strs = bf.readLine().split(" ");
            N = Integer.parseInt(strs[0]);
            V = Integer.parseInt(strs[1]);

            v = new int[N + 1];
            w = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                String[] vm = bf.readLine().split(" ");
                v[i] = Integer.parseInt(vm[0]);
                w[i] = Integer.parseInt(vm[1]);
            }

            f = new int[N + 1][V + 1];
            // f[0][v] = 0, f[n][0] = 0;
            for (int i = 1; i < N; i++) {
                for (int j = 1; j <= V; j++) {
                    System.out.printf("i %d j d% f %d \n", i, j, f[i][j]);
                    f[i][j] = f[i - 1][j];
                    if (j >= v[i]) {
                        f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i]] + w[i]);
                    }
                }
            }

            System.out.println(f[N][V]);
        }
    }
}
