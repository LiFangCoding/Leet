package _51_100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _71_Simplify_Path {
    public static void main(String[] args) {
        String s = "/usr/stories//hello/../work///for";
        _71_Simplify_Path test = new _71_Simplify_Path();
        System.out.println(Arrays.toString(s.split("/+")));
        System.out.println(test.simplifyPath(s));
    }

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }

        Deque<String> deque = new ArrayDeque<>();
        String[] dirs = path.split("/+");

        /**
         * !!! dir is "". But dir == "" is false. We need dir.equals().
         */
        for (String dir : dirs) {
            if (dir.equals("") || dir.equals(".")) {
                continue;
            }

            if (dir.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.removeFirst();
                }
            } else {
                deque.addFirst(dir);
            }
        }

        if (deque.isEmpty()) {
            return "/";
        }
        /**
         * !!! careful. If deque is empty, it should be "/".
         */
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/");
            sb.append(deque.removeLast());
        }

        return sb.toString();
    }

}
