class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        char_to_count_s, char_to_count_t = {}, {}
        for char_s, char_t in zip(s, t):
            char_to_count_s[char_s] = char_to_count_s.get(char_s, 0) + 1
            char_to_count_t[char_t] = char_to_count_t.get(char_t, 0) + 1

        for char in s:
            if char_to_count_s[char] != char_to_count_t.get(char, 0):
                return False
        return True


if __name__ == '__main__':
    res1 = Solution().isAnagram("rat", "car")
    res2 = Solution().isAnagram("anagram", "nagaram")

    print()
