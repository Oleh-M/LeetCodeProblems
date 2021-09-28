package binarysearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 4));
        System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 5));
        System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 6));
        System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 7));
        System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 1));
        System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 2));
        System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(search(new int[] {}, 123));
        System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 123));
    }

    public static int search(int[] nums, int target) {
        int mid, left = 0, right = nums.length - 1;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;

            else if(nums[mid] >= nums[left]) { // right pivot
                if(target < nums[left] || target > nums[mid]) {
                    left = mid + 1;
                } else right = mid - 1;

            } else if (nums[mid] < nums[right]) { // left pivot
                if (nums[right] < target || target < nums[mid]) {
                    right = mid - 1;
                } else left = mid + 1;
            }
        }

        return -1;
    }
}
