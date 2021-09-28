package reverseinteger;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
        System.out.println(reverse(901000));
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        char[] strNum = String.valueOf(x).toCharArray();

        if(strNum.length == 1) return  x;

        int result = 0;
        int digit;
        for (int i = strNum.length - 1; i >= 0; i--) {
            if (strNum[i] != '-') {
                digit = strNum[i] - '0';
                if ((long) result * 10 + digit > 2147483647 || (long) result * 10 + digit < -2147483648) {
                    return 0;
                }
                result = result * 10 + digit;
            }
        }

        return result * (strNum[0] == '-' ? -1 : 1);
    }
}
