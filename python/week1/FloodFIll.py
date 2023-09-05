from typing import List


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image[sr][sc] == color:
            return image
        self.fill(image, sr, sc, color, image[sr][sc])
        return image

    def fill(self, image: List[List[int]], sr: int, sc: int, color: int, oldColor: int):
        if (sc < 0 or sr < 0 or sr >= len(image) or sc >= len(image[sr]) or image[sr][sc] != oldColor):
            return None
        image[sr][sc] = color
        self.fill(image, sr - 1, sc, color, oldColor)
        self.fill(image, sr + 1, sc, color, oldColor)
        self.fill(image, sr, sc - 1, color, oldColor)
        self.fill(image, sr, sc + 1, color, oldColor)


if __name__ == '__main__':
    res1 = Solution().floodFill([[1, 1, 1], [1, 1, 0], [1, 0, 1]], 1, 1, 2)
    print()
