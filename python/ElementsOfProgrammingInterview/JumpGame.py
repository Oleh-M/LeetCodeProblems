from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) == 1:
            return True

        max_reach = nums[0]
        for i in range(len(nums) - 1):
            if i > max_reach:
                return False
            max_reach = max(max_reach, i + nums[i])
            if max_reach >= len(nums) - 1:
                return True

        return False

    def canJump2(self, nums: List[int]) -> bool:
        if len(nums) == 1:
            return True

        max_reach = nums[0]
        i = 0

        while i <= max_reach and max_reach < len(nums) - 1:
            max_reach = max(max_reach, i + nums[i])
            i += 1

        return max_reach >= len(nums) - 1


if __name__ == '__main__':
    Solution().canJump([5,4,0,2,0,1,0,1,0])