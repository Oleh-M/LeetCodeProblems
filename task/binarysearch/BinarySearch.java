package binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(search(new int[] {-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(search(new int[] {-1, 0, 3, 5, 9, 12, 16}, 16));
        System.out.println(search(new int[] {2, 5}, 5));
        System.out.println(search(new int[] {-1,0,3,5,9,12}, 2));
        System.out.println(search(new int[] {-1,0,5}, 5));
    }

    public static int search(int[] nums, int target) {
        if(nums.length == 1) return nums[0] == target ? 0 : -1;

        for (int i = 0, j = nums.length / 2;
             i < nums.length / 2 && j < nums.length;
             i++, j++) {

            if (nums[i] == target) {
                return i;
            } else if (nums[j] == target) {
                return j;
            }
        }

        return -1;
    }
}
