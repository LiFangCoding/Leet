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
    public static void main(String[] args) {
        _164_Maximum_Gap test = new _164_Maximum_Gap();

        int[] A = new int[] { 3, 6, 9, 1 };
        System.out.println(test.maximumGap(A));
    }

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