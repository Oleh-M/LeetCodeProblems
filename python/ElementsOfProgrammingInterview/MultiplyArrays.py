from typing import List


class Solution:
    def multiply(self, num1: List[int], num2: List[int]) -> List[int]:
        sign = -1 if (num1[0] < 0) ^ (num2[0] < 0) else 1

        if num1 == [0] or num2 == [0]:
            return [0]

        num1[0], num2[0] = abs(num1[0]), abs(num2[0])
        result = [0] * (len(num1) + len(num2))

        for i in range(len(num1) - 1, -1, -1):
            for j in range(len(num2) - 1, -1, -1):
                pos = i + j + 1
                result[pos] += num1[i] * num2[j]
                result[i + j] += result[pos] // 10
                result[pos] %= 10

        start = 0
        while start < len(result) - 1 and result[start] == 0:
            start += 1

        if sign < 0:
            result[0] = -result[0]

        return result[start:]


if __name__ == '__main__':
    print(Solution().multiply([2, 1, 2], [9, 5, 7, 6]))
