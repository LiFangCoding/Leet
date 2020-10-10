package leet._351_400;

import java.util.ArrayList;
import java.util.List;

public class _386_Lexicographical_Numbers {
    class Solution {
        // trie来做
        // 字符串排序，用trie,能省一个logn
        // 树的遍历。 从小到大来搜索，一定是排序的
        // 遍历树的时间浮渣度 nlogn. n个数， 一个数logn长度
        // 写的时候不用插入。搜的时候，假装每个分支都有，当前分支大于n,不用继续搜索了

        List<Integer> res;

        public List<Integer> lexicalOrder(int n) {
            res = new ArrayList<>();
            for (int i = 1; i <= 9; i++) {
                dfs(i, n);
            }
            return res;
        }

        void dfs(int cur, int n) {
            if (cur <= n) {
                res.add(cur);
            } else {
                return;
            }

            for (int i = 0; i <= 9; i++) {
                dfs(cur * 10 + i, n);
            }
        }
    }
}
