from collections import Counter


class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        magazine_dict = {}

        for m in magazine:
            magazine_dict[m] = magazine_dict.get(m, 0) + 1

        for r in ransomNote:
            if magazine_dict.get(r, 0) == 0:
                return False
            else:
                magazine_dict[r] = magazine_dict.get(r, 0) - 1

        return True

    def canConstruct2(self, ransomNote: str, magazine: str) -> bool:
        magazine_counter = Counter(magazine)

        for r in ransomNote:
            if magazine_counter[r] <= 0:
                return False
            else:
                magazine_counter[r] -= 1

        return True


if __name__ == '__main__':
    Solution().canConstruct2("aa", "ab")
    Solution().canConstruct2("aa", "aab")
    Solution().canConstruct2("a", "b")
