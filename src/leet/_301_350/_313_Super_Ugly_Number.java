package leet._301_350;

import java.util.PriorityQueue;

/**
 * Write a program to find the nth super ugly number.
 * <p>
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 * <p>
 * Example:
 * <p>
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
 * super ugly numbers given primes = [2,7,13,19] of size 4.
 * Note:
 * <p>
 * 1 is a super ugly number for any given primes.
 * The given numbers in primes are in ascending order.
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _313_Super_Ugly_Number {
    class Node {

    }

    /**
     * k 个指针，找出最小值*字数， nlogk
     */
    class Sol_ac {
        public int nthSuperUglyNumber(int n, int[] primes) {
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
            for (int x : primes) {
                pq.add(new Node(x, 0));
            }

            int[] q = new int[n];
            q[0] = 1;
            for (int i = 1; i < n; ) {
                Node t = pq.remove();
                if (t.val != q[i - 1]) {
                    q[i++] = t.val;
                }
                int idx = t.idx;
                int p = t.val / q[idx];
                pq.add(new Node(p * q[idx + 1], idx + 1));
            }
            return q[n - 1];
        }

        class Node {
            int val;
            int idx;

            public Node(int _x, int _y) {
                val = _x;
                idx = _y;
            }
        }
    }
}
