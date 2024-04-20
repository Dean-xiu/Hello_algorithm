package simulation;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/string-to-integer-atoi/description/">string-to-integer-atoi</a>
 */
public class StringToIntegerAtoi {
    public static int myAtoi(String s) {
        char[] chars = s.trim().toCharArray();
        if (chars.length == 0) return 0;

        int bndry = Integer.MAX_VALUE / 10;

        int i = 1, sign = 1;
        if (chars[0] == '-') {
            sign = -1;
        } else if (chars[0] != '+') {
            i = 0;
        }

        int sum = 0;
        for (int j = i; j < chars.length; j++) {
            if (chars[j] >= '0' && chars[j] <= '9') {
                //MAX_VALUE is 2147483647  MIN_VALUE is -2147483648
                if (sum > bndry || sum == bndry && chars[j] > '7') {
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                sum = sum * 10 + (chars[j] - '0');
            } else {
                break;
            }
        }

        return sum * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
    }
}
