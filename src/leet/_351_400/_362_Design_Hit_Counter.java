package leet._351_400;

import java.util.PriorityQueue;

public class _362_Design_Hit_Counter {
    class HitCounter {
        PriorityQueue<Integer> pq;

        /**
         * Initialize your data structure here.
         */
        public HitCounter() {
            pq = new PriorityQueue<>();
        }

        /**
         * Record a hit.
         *
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public void hit(int timestamp) {
            pq.add(timestamp);
        }

        /**
         * Return the number of hits in the past 5 minutes.
         *
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public int getHits(int timestamp) {
            while (!pq.isEmpty() && timestamp - pq.peek() >= 5 * 60) {
                pq.remove();
            }
            return pq.size();
        }
    }
}
