package binarysearch;

public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
        System.out.println(nextGreatestLetter(new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'}, 'e'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int mid, left = 0, right = letters.length - 1;
        char smallest = letters[0];

        while (left < right) {
            mid = left + (right - left) / 2;
            if (letters[mid] <= target) left = mid + 1;
            else {
                smallest = letters[right];
                right = mid;
            }
        }

        if(left != letters.length && letters[left] > target) return letters[left];

        return smallest;
    }
}
