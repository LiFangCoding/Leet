package leet._351_400;

public class _390_Elimination_Game {
    // f[n] = 2g[n]
    // g[n] = n + 1  - f(n)
    // f(n) = 2(n/2 + 1 - f(n /2))
    public int lastRemaining(int n) {
        if (n == 1)
            return 1;
        return 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }
}
