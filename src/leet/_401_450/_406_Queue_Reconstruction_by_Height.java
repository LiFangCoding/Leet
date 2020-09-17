package leet._401_450;

import java.util.Arrays;
import java.util.LinkedList;

public class _406_Queue_Reconstruction_by_Height {
    // TODO

    /**
     * 12ms
     * T = nlogn?
     * 解题思路：先排序再插入
     * * 1.排序规则：按照先H高度降序，K个数升序排序
     * * 2.遍历排序后的数组，根据K插入到K的位置上
     * *
     * * 核心思想：高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
     * *
     * <p>
     * 作者：pphdsny
     * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/406-gen-ju-shen-gao-zhong-jian-dui-lie-java-xian-p/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o2[0], o1[0]);
            }
        });

        LinkedList<int[]> list = new LinkedList<>();

        for (int[] i : people) {
            list.add(i[1], i);
        }

        return list.toArray(new int[list.size()][2]);
    }
}
