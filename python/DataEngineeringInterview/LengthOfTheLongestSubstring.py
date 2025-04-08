class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        left = 0
        right = 0
        max_string = 0
        counter = ""

        while right < len(s):
            if s[right] not in counter:
                counter += s[right]
                right += 1
                max_string = max(max_string, len(counter))
            else:
                counter = counter[1:]
                left += 1

        return max_string

if __name__ == '__main__':
    Solution().lengthOfLongestSubstring("pwwkew")
    Solution().lengthOfLongestSubstring("bbbbbbb")
    Solution().lengthOfLongestSubstring("abcabcbb")
    Solution().lengthOfLongestSubstring("cdd")
    Solution().lengthOfLongestSubstring("au")