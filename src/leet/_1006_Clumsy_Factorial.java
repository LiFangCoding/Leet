package leet;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _1006_Clumsy_Factorial {
    Stack<Integer> nums;
    Stack<Character> ops;

    public int clumsy(int N) {
        nums = new Stack<>();
        ops = new Stack<>();
        char[] opArray = {'*', '/', '+', '-'};
        Map<Character, Integer> map = new HashMap<>();
        map.put('*', 2);
        map.put('/', 2);
        map.put('+', 1);
        map.put('-', 1);

        for (int i = N, k = 0; i >= 1; i--) {
            if (i == 1) {
                nums.push(1);
                continue;
            }

            nums.push(i);
            char curOp = opArray[k];
            k = (k + 1) % 4;

            while (!ops.isEmpty() && map.get(ops.peek()) >= map.get(curOp)) {
                eval();
            }
            ops.push(curOp);
        }

        while (!ops.isEmpty()) eval();
        return nums.peek();
    }

    private void eval() {
        char op = ops.pop();
        int b = nums.pop();
        int a = nums.pop();

        int res = 0;
        if (op == '*') {
            res = a * b;
        } else if (op == '/') {
            res = a / b;
        } else if (op == '+') {
            res = a + b;
        } else if (op == '-') {
            res = a - b;
        }
        nums.push(res);
    }
}
