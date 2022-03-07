package dynamicprogramming;

public class Stock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{8, 5, 2, 4, 54, 1, 3, 12, 32, 4, 5, 6, 7, 7, 43, 4, 2}));
    }

    public static int maxProfit(int[] prices) {
        int left = 0,
                right = 1,
                currentProfit = 0;

        while (right < prices.length) {
            currentProfit = Math.max(currentProfit, prices[right] - prices[left]);
            if (prices[left] > prices[right]) {
                left = right;
            }
            right++;
        }

        return currentProfit;
    }
}
