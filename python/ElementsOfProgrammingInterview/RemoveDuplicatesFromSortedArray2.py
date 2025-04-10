from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        replace_index = 1
        count = 1

        for i in range(1, len(nums)):
            if nums[i] == nums[i - 1]:
                count += 1
            else:
                count = 1

            if count <= 2:  # we are inserting here
                nums[replace_index] = nums[i]
                replace_index += 1

        return replace_index