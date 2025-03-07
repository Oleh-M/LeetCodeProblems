class Solution:
    def countPrimes(self, n: int) -> int:
        if n <= 2:
            return 0

        is_prime = [False, False] + [True] * (n - 2)

        for p in range(2, int(n ** 0.5) + 1):
            if is_prime[p]:
                for i in range(p * p, n, p):
                    is_prime[i] = False

        return sum(is_prime)