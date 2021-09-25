package dynamicprogramming;

public class NumArray {

    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        if (left == right) return nums[left];

        int sum = nums[left];
        while (left != right) {
            sum += nums[right--];
        }

        return sum;
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(left,right);
     */
}

class Main {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 4, -6});

        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(1, 2));
        System.out.println(numArray.sumRange(0, 1));
    }
}
