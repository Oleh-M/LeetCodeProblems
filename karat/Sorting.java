import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] actual = { 5, 1, 6, 2, 3, 4 };

        mergeSort(actual, actual.length);

        System.out.println(Arrays.toString(actual));

        int[] ac = { 5, 1, 6, 2, 3, 4 };

        quickSort(ac, 0, ac.length - 1);

        System.out.println(Arrays.toString(ac));
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid]; // two halves
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i]; // fill halves with values that will be sorted later
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        mergeSort(l, mid); // sort left sub-array
        mergeSort(r, n - mid); // sort right sub-array
        merge(a, l, r, mid, n - mid);
    }

    private static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }

        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low > high) return;

        int partitionIndex = partition(arr, low, high);
        quickSort(arr, low, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, high);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if(arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = swapTemp;

        return i + 1;
    }
}
