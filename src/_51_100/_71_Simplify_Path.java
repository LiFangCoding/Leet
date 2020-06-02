package _51_100;

import java.util.*;

public class _71_Simplify_Path {

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
