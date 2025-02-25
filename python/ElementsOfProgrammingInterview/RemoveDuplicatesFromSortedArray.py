from typing import List


class Solution:
    def deleteDuplicates(self, nums: List[int]):
        insert_position = 1

        for i in range(1, len(nums)):
            if nums[i] != nums[i - 1]:
                nums[insert_position] = nums[i]
                insert_position += 1

        return insert_position