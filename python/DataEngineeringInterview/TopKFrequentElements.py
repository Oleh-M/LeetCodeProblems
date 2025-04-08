from collections import Counter
from heapq import heappush, heappop
from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        heap = []
        counters = Counter(nums)
        for key, value in counters.items():
            heappush(heap, (-value, key))

        res = []
        while len(res) < k:
            res.append(heappop(heap)[1])

        return res


if __name__ == '__main__':
    print(Solution().topKFrequent([1,1,1,2,2,3], 2))
    print(Solution().topKFrequent([1], 1))