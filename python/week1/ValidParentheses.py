from collections import deque


class Solution:
    def isValid(self, s: str) -> bool:
        my_queue = deque()
        parenthesis_to_num = {
            '(': 1,
            '[': 2,
            '{': 3,
            ')': -1,
            ']': -2,
            '}': -3
        }

        for parenthesis in s:
            if len(my_queue) > 0 and my_queue[-1] + parenthesis_to_num.get(parenthesis) == 0:
                my_queue.pop()
            elif parenthesis_to_num.get(parenthesis) < 0:
                return False
            else:
                my_queue.append(parenthesis_to_num.get(parenthesis))

        return len(my_queue) == 0


if __name__ == '__main__':
    print(Solution().isValid("(){}}{"))
    print(Solution().isValid("()"))
    print(Solution().isValid("()[]{}"))
    print(Solution().isValid("(]"))
