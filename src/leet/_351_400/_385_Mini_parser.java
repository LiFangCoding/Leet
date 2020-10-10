package leet._351_400;

import java.util.List;

public class _385_Mini_parser {
    public class NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return false;
        }

        public Integer getInteger() {
            return null;
        }

        public void setInteger(int value) {

        }

        public void add(NestedInteger ni) {

        }

        public List<NestedInteger> getList() {
            return null;
        }
    }

    class Solution {
        int u = 0;
        String s;

        // 遇到左括号，当前节点是内部节点，递归处理内部节点没一个儿子
        // 123, 叶节点。 处理下一个子节点，递归
        public NestedInteger deserialize(String _s) {
            s = _s;
            return dfs(s.toCharArray());
        }

        NestedInteger dfs(char[] sa) {
            NestedInteger res = new NestedInteger();

            // 内部节点
            if (sa[u] == '[') {
                // skip left
                u++;
                while (sa[u] != ']') res.add(dfs(sa));
                // skip right
                u++;
                // skip ,
                if (u < sa.length && sa[u] == ',') u++;
            } else {
                //找一个数
                int k = u;
                while (k < sa.length && sa[k] != ',' && sa[k] != ']') k++;
                res.setInteger(Integer.parseInt(s.substring(u, k)));
                // skip ,
                if (k < sa.length && sa[k] == ',') k++;
                u = k;
            }
            return res;
        }
    }
}
