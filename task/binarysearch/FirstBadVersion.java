package binarysearch;

public class FirstBadVersion {
    public static int definedVersion = 1;

    public static void main(String[] args) {
        System.out.println(firstBadVersion(1));
        System.out.println(firstBadVersion(2));
        System.out.println(firstBadVersion(23));
    }

    public static int firstBadVersion(int n) {
        int mid, left = 1, right = n;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // Post-processing:
        // End Condition: left == right
        if (isBadVersion(left)) return left;

        return -1;
    }

    public static boolean isBadVersion(int version) {
        return version >= definedVersion;
    }
}
