import leet._1_50._22_GenerateParentheses;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _22_GenerateParenthesesTest {
    _22_GenerateParentheses test = new _22_GenerateParentheses();

    @Test
    void generateParenthesis() {
        String[] res = {
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"};

        assertArrayEquals(res, test.generateParenthesis(3).toArray());
    }
}