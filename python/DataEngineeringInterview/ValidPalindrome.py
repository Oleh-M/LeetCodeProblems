class Solution:
    def isPalindrome(self, s: str) -> bool:
        cleaned_str = ''.join(ch.lower() for ch in s if ch.isalnum())
        left = 0
        right = len(cleaned_str) - 1

        while left < right:
            if cleaned_str[left] != cleaned_str[right]:
                return False
            left += 1
            right -= 1

        return True