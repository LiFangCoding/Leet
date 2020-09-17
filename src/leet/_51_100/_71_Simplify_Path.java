package leet._51_100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 * <p>
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level.
 * <p>
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
 * <p>
 * Example 1:
 * <p>
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * Example 2:
 * <p>
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * Example 3:
 * <p>
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * Example 4:
 * <p>
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 * Example 5:
 * <p>
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 * Example 6:
 * <p>
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/simplify-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _71_Simplify_Path {
    //TODO
    class Sol_Deque {
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

    /**
     * 15ms
     * T = n
     */
    class Sol_Stack {
        public String simplifyPath(String path) {
            if (path == null || path.length() == 0) {
                return "/";
            }

            String[] strs = path.split("/+");
            // we need to remove from the last
            // a b c   /a/b/c   c/b/a/
            Stack<String> stack = new Stack<>();

            for (String s : strs) {
                if (s.equals("") || s.equals(".")) {
                    continue;
                }

                if (s.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(s);
                }
            }

            List<String> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
            Collections.reverse(list);
            return "/" + String.join("/", list);
            //        StringBuilder sb = new StringBuilder();
            //
            //        while (!stack.isEmpty()) {
            //            sb.append(stack.pop());
            //            sb.append("/");
            //        }
            // important. cannot use sb.reverse() "/home/" actual: "/emoh"
            //        sb.reverse();
            //        if (sb.length() == 0) {
            //            return "/";
            //        }
            //
            //        return sb.toString();
        }
    }
}
