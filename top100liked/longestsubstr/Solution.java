package longestsubstr;

/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Example 4:

Input: s = ""
Output: 0

Constraints:

    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.
 */

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab")); // 2
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(lengthOfLongestSubstring("")); // 0
        System.out.println(lengthOfLongestSubstring(" ")); // 1
        System.out.println(lengthOfLongestSubstring("anviaj")); // 5
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        Set<Character> resSet = new HashSet<>();
        int i = 0;
        int longest = 0;
        int j = 0;
        while(j < s.length()) {
            if (!resSet.contains(s.charAt(j))) {
                resSet.add(s.charAt(j));
                j++;
                longest = Math.max(longest, resSet.size());
            } else {
                resSet.remove(s.charAt(i));
                i++;
            }
        }

        return longest;
    }
}
