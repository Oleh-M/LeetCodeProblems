from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(p) > len(s):
            return []

        p_frequency = [0] * 26
        s_frequency = [0] * 26

        for c in p:
            p_frequency[ord(c) - ord('a')] += 1

        for i in range(len(p)):
            s_frequency[ord(s[i]) - ord('a')] += 1

        res = []
        if p_frequency == s_frequency:
            res.append(0)

        for i in range(len(p), len(s)):
            s_frequency[ord(s[i - len(p)]) - ord('a')] -= 1

            s_frequency[ord(s[i]) - ord('a')] += 1

            if p_frequency == s_frequency:
                res.append(i - len(p) + 1)

        return res

if __name__ == '__main__':
    print(Solution().findAnagrams("cbaebabacd", "abc"))
