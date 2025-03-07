from typing import List


class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        result = ['']

        for i in s:
            if i.isalpha():
                result = [prev + c for prev in result for c in [i.upper(), i.lower()]]
            else:
                result = [prev + i for prev in result]

        return result


if __name__ == '__main__':
    Solution().letterCasePermutation("a1b2")