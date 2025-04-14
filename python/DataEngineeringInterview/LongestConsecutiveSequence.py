from typing import List


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0

        nums_set = set(nums)
        longest = 0

        for i in nums:
            if i - 1 not in nums_set:
                current = 1
                while i + current in nums_set:
                    current += 1
                longest = max(longest, current)

        return longest


if __name__ == '__main__':
    val = Solution().longestConsecutive([1, 0, 1, 2])
    print(val)
