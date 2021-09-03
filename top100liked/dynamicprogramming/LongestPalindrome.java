package dynamicprogramming;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        String res = "";
        int resLength = 0;

        char[] symbols = s.toCharArray();
        int l, r;
        for (int i = 0; i < s.length(); i++) {
            l = i; r = i;

            // odd length
            while (l >= 0 && r < symbols.length && symbols[l] == symbols[r]) {
                if ((r - l + 1) > resLength) {
                    res = s.substring(l, r + 1);
                    resLength = r - l + 1;
                }
                l -= 1;
                r += 1;
            }

            // even length
            l = i; r = i + 1;
            while (l >= 0 && r < symbols.length && symbols[l] == symbols[r]) {
                if ((r - l + 1) > resLength) {
                    res = s.substring(l, r + 1);
                    resLength = r - l + 1;
                }
                l -= 1;
                r += 1;
            }
        }

        return res;
    }
}
