import re


class Solution:
    def isPalindrome(self, s: str) -> bool:
        if not s: return True
        cleaned_string = re.sub(r'[^a-zA-Z0-9]', '', s)
        return cleaned_string == cleaned_string[::-1]

    def isPalindrome2(s: str) -> bool:
        s = ''.join(filter(str.isalnum, s)).lower()
        return s == s[::-1]


if __name__ == '__main__':
    Solution().isPalindrome("A man, a plan, a canal: Panama")
    Solution().isPalindrome("race a car")
    Solution().isPalindrome(" ")
