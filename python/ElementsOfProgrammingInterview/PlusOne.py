from typing import List


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        if len(digits) == 1 and digits[0] != 9:
            digits[0] += 1
            return digits
        elif len(digits) == 1:
            return [1, 0]

        index = len(digits) - 1

        while digits[index] == 9 and index >= 0:
            digits[index] = 0
            index -= 1

        if index == -1:
            digits.insert(0, 1)
        else:
            digits[index] += 1

        return digits

    def plusOneImproved(self, digits: List[int]) -> List[int]:
        for i in range(len(digits) - 1, -1, -1):
            if digits[i] < 9:
                digits[i] += 1
                return digits
            digits[i] = 0

        return [1] + digits



if __name__ == '__main__':
    Solution().plusOne([1,2,3])