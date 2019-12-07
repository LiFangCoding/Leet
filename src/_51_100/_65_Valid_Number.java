package _51_100;

/**
 * Validate if a given string can be interpreted as a decimal number.
 * <p>
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * <p>
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:
 * <p>
 * Numbers 0-9
 * Exponent - "e"
 * Positive/negative sign - "+"/"-"
 * Decimal point - "."
 * Of course, the context of these characters also matters in the input.
 */
public class _65_Valid_Number {
    public static void main(String[] args) {
        _65_Valid_Number test = new _65_Valid_Number();
        System.out.println(test.isNumber("0"));
    }

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        char[] sc = s.trim().toCharArray();
        boolean hasDot = false;
        boolean hasE = false;
        boolean hasDigit = false;
        boolean hasDigitAfterE = false;

        for (int i = 0; i < sc.length; i++) {
            char c = sc[i];
            if (Character.isDigit(c)) {
                hasDigit = true;
                if (hasE) {
                    hasDigitAfterE = true;
                }
                continue;
            }

            switch (c) {
                case '+': // intend to fall through
                case '-':
                    if (i != 0 && sc[i - 1] != 'e') {
                        return false;
                    }
                    break;
                case 'e':
                    if (hasE || !hasDigit) {
                        return false;
                    }
                    hasE = true;
                    break;
                case '.':
                    if (hasDot || hasE) {
                        return false;
                    }
                    hasDot = true;
                    break;
                default:
                    return false;
            }
        }
        return hasE ? hasDigit && hasDigitAfterE : hasDigit;
    }
}
