package twopointers;

import java.util.Arrays;

public class SquaresOfASortedArray {

    public static int[] sortedSquares(int[] nums) {
        if (nums.length == 1) {
            nums[0] = nums[0] * nums[0];
            return nums;
        }

        int posPointer = 0;

        while(nums[posPointer] < 0 && posPointer < nums.length - 1) {
            posPointer++;
        }
        int negativePointer = posPointer - 1;

        int[] squaredArr = new int[nums.length];
        int counter = 0;

        while(posPointer < nums.length && negativePointer >= 0) {
            if(nums[posPointer] * nums[posPointer] < nums[negativePointer] * nums[negativePointer]) {
                squaredArr[counter] = nums[posPointer] * nums[posPointer];
                posPointer++;
            } else {
                squaredArr[counter] = nums[negativePointer] * nums[negativePointer];
                negativePointer--;
            }
            counter++;
        }

        while(negativePointer >= 0) {
            squaredArr[counter++] = nums[negativePointer] * nums[negativePointer];
            negativePointer--;
        }

        while(posPointer < nums.length) {
            squaredArr[counter++] = nums[posPointer] * nums[posPointer];
            posPointer++;
        }


        return squaredArr;
    }

    public static void main(String[] args) {
        var arr1 = sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(arr1));
        var arr2 = sortedSquares(new int[]{-7, -3, 2, 3, 11});
        System.out.println(Arrays.toString(arr2));
        var arr3 = sortedSquares(new int[]{-5, -3, -2, -1});
        System.out.println(Arrays.toString(arr3));
        var arr4 = sortedSquares(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(arr4));
    }
}
