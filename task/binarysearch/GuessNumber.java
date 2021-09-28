package binarysearch;


public class GuessNumber {
    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }

    static int PICK = 6; // test value

    /**
     * Forward declaration of guess API.
     * @param  n   your guess
     * @return 	     -1 if num is lower than the guess number
     *			      1 if num is higher than the guess number
     *               otherwise return 0
     * int guess(int num);
     */
    public static int guessNumber(int n) {
        int mid, left = 0, right = n;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (guess(mid) == 0) return mid;
            else if(guess(mid) == -1) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }

    public static int guess(int num) { // imitate test function
        if (num == PICK) return 0;
        else return num > PICK ? -1 : 1;
    }
}
