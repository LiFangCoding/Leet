package leet._151_200;

/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * <p>
 * Return 0 if the array contains less than 2 elements.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either
 *              (3,6) or (6,9) has the maximum difference 3.
 * Example 2:
 * <p>
 * Input: [10]
 * Output: 0
 * Explanation: The array contains less than 2 elements, therefore return 0.
 */
public class _164_Maximum_Gap {
    class Sol_ac {
        //TODO
        //区间内部最大差都不能扩到长度
        // 假设区间长度x，(]. (0, x] 任何两数最大差值是

        public int maximumGap(int[] nums) {
            int n = nums.length;
            int Min = Integer.MAX_VALUE;
            int Max = Integer.MIN_VALUE;

            for (int x : nums) {
                Min = Math.min(Min, x);
                Max = Math.max(Max, x);
            }
            if (n < 2 || Min == Max) return 0;
            Range[] r = new Range[n - 1];
            for (int i = 0; i < r.length; i++) {
                r[i] = new Range();
            }
            //  cannot Arrays.fill(r, new Range()). it will be same object
            int len = (Max - Min + n - 2) / (n - 1);
            for (int x : nums) {
                if (x == Min) continue;
                int k = (x - Min - 1) / len;
                //  System.out.println("k is " + k + " x is" + x + " r[k] min " + r[k].min + " rk max " + r[k].max);
                r[k].used = true;
                r[k].min = Math.min(r[k].min, x);
                r[k].max = Math.max(r[k].max, x);
                //  System.out.println("updated k is " + k + " x is" + x + " r[k] min " + r[k].min + " rk max " + r[k].max);
            }

            int res = 0;
            for (int i = 0, last = Min; i < n - 1; i++) {
                if (r[i].used) {
                    //  System.out.println("min " + r[i].min + " last " + last);
                    res = Math.max(res, r[i].min - last);
                    last = r[i].max;
                }
            }
            return res;
        }

        class Range {
            int min, max;
            boolean used;

            public Range() {
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
                used = false;
            }
        }
    }

    class Sol_old {
        public int maximumGap(int[] A) {
            if (A == null || A.length < 2) {
                return 0;
            }

            int mini = A[0];
            int maxi = A[0];

            for (int num : A) {
                mini = Math.min(mini, num);
                maxi = Math.max(maxi, num);
            }

            int bucketSize = Math.max(1, (maxi - mini) / (A.length - 1));
            int bucketNum = (maxi - mini) / bucketSize + 1;
            Bucket[] buckets = new Bucket[bucketNum];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new Bucket();
            }

            for (int num : A) {
                int bucketIdx = (num - mini) / bucketSize;
                buckets[bucketIdx].used = true;
                buckets[bucketIdx].minval = Math.min(num, buckets[bucketIdx].minval);
                buckets[bucketIdx].maxval = Math.max(num, buckets[bucketIdx].maxval);
            }

            int prevBucketMax = mini, maxGap = 0;

            for (Bucket bucket : buckets) {
                if (!bucket.used) {
                    continue;
                }

                maxGap = Math.max(maxGap, bucket.minval - prevBucketMax);
                prevBucketMax = bucket.maxval;
            }

            return maxGap;
        }

        public class Bucket {
            boolean used = false;
            int minval = Integer.MAX_VALUE;
            int maxval = Integer.MIN_VALUE;
        }
    }
}