from typing import List


class Solution:
    def insert(self, intervals: List[List[int]], new_interval: List[int]) -> List[List[int]]:
        result = []

        for interval in intervals:
            if new_interval[1] < interval[0]:
                result.append(new_interval)
                new_interval = interval
            elif new_interval[0] > interval[1]:
                result.append(interval)
            else:
                new_interval[0] = min(new_interval[0], interval[0])
                new_interval[1] = max(new_interval[1], interval[1])

        result.append(new_interval)

        return result


if __name__ == '__main__':
    Solution().insert([[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]], [4, 8])
