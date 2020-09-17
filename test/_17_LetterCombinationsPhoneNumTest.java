import leet._1_50._17_LetterCombinationsPhoneNum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _17_LetterCombinationsPhoneNumTest {
    _17_LetterCombinationsPhoneNum test = new _17_LetterCombinationsPhoneNum();

    @Test
    void letterCombinations() {
        String[] res = {"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};

        assertArrayEquals(res, test.letterCombinations("23").toArray());
    }
}