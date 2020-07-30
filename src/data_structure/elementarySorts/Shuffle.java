package data_structure.elementarySorts;

import java.util.Arrays;
import java.util.Random;

public class Shuffle {
    // linear time
    public static void shuffle(int[] a) {
        int N = a.length;

        Random rand = new Random();
        // In iteration i, pick integer r between 0 and i uniformly at random
        // swap a[i] and a[r]
        // left to the i is shuffled, i is itself. right to i is not seen yet
        for (int i = 0; i < N; i++) {
            int r = rand.nextInt(i + 1);
            exch(a, i, r);
        }
    }

    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5, 6 };

        for (int i = 0; i < 10; i++) {
            Shuffle.shuffle(A);
            System.out.println(Arrays.toString(A));
        }
    }
}
