package leet._351_400;

import java.util.*;

public class _381_Insert_Delete_random_duplicates_allowed {
    static class RandomizedCollection {
        Map<Integer, Set<Integer>> map;
        List<Integer> list;
        Random rand;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            map = new HashMap<>();
            list = new ArrayList<>();
            rand = new Random();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int x) {
            boolean res = !map.containsKey(x);
            list.add(x);
            if (!map.containsKey(x)) {
                map.put(x, new HashSet<>());
            }
            map.get(x).add(list.size() - 1);
            return res;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int x) {
            // important > 0
            if (map.containsKey(x) && map.get(x).size() > 0) {
                int px = map.get(x).iterator().next();
                int py = list.size() - 1;
                int y = list.get(py);

                list.set(px, y);
                list.set(py, x);

                map.get(x).remove(px);
                map.get(x).add(py);
                map.get(y).remove(py);
                map.get(y).add(px);

                list.remove(list.size() - 1);
                map.get(x).remove(py);
                return true;
            }
            return false;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
}
