package _1_50;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place and use only constant extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * <p>
 * 1,2,3
 * 1,3,2
 * 2,1,3
 * 2,3,1
 * 3,1,2
 * 3,2,1
 *
 * 1,2,3,4
 * 1,2,4,3
 * 1,3,2,4
 * 1,3,4,2
 * 1,4,2,3
 * 1,4,3,2
 * 2,1,3,4
 * 2,1,4,3
 * 2,3,1,4
 * 2,3,4,1
 * 2,4,1,3
 * 2,4,3,1
 */
public class _31_NextPermutation {
    public static void main(String[] args) {
        _31_NextPermutation test = new _31_NextPermutation();

        int[] nums = {1, 3, 5, 4, 8, 7, 6};
        test.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(',');
        }
    }

    /**
     * This is to find the smallest of A that are larget than A.
     * If it is largest, return the reverse version.
     * <p>
     * 1,3,5,4,8,7,6
     * 1,3,5,6,4,7,8
     * <p>
     * 1,6,7
     * 1,7,6
     * <p>
     * 1,7,7
     * 7,1,7
     * 7,7,1
     * <p>
     * Consider edge case problem
     * 1
     * 1,1
     *
     * @param A
     */
    public void nextPermutation(int[] A) {
        /**
         * https://www.acwing.com/solution/content/103/
         * 找下一个排列就是从后往前寻找第一个出现降的地方，把这个地方的数字与后边某个比它大的的数字交换，再把该位置之后整理为升序。
         *
         * 否则从数组末尾往前找，找到 第一个 位置 j，使得 nums[j] < nums[j + 1]。
         * 如果不存在这样的 j，则说明数组是不递增的，直接将数组逆转即可。
         * 如果存在这样的 j，则从末尾找到第一个位置 i > j，使得 nums[i] > nums[j]。
         * 交换 nums[i] 与 nums[j]，然后将数组从 j + 1 到末尾部分逆转。
         * 时间复杂度
         * 线性遍历数组常数次，时间复杂度为 O(n)O(n)。
         * 空间复杂度
         * 没有使用任何额外的数组空间，故空间复杂度为 O(1)O(1)。
         *
         * 作者：wzc1995
         * 链接：https://www.acwing.com/solution/content/103/
         * 来源：AcWing
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        if (A == null || A.length == 0) {
            return;
        }

        int len = A.length;

        int idxSmall = len - 2;
        while (idxSmall >= 0) {
            if (A[idxSmall] < A[idxSmall + 1]) {
                break;
            }
            idxSmall--;
        }

        if (idxSmall < 0) {
            reverse(A, 0, len - 1);
            /** Do not forget return.
             * else error: [1], [1,1]
             */
            return;
        }

        int idxLarge = len - 1;

        while (A[idxLarge] <= A[idxSmall]) {
            idxLarge--;
        }

        int temp = A[idxSmall];
        A[idxSmall] = A[idxLarge];
        A[idxLarge] = temp;

        reverse(A, idxSmall + 1, len - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
