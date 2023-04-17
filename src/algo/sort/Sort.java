package algo.sort;

/**
 * @author shuaishuai.wang
 * @date 2021-03-04
 **/
public class Sort {

    public static void insertSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] <= value) {
                    break;
                } else {
                    a[j + 1] = a[j];
                }
            }
            a[j + 1] = value;
        }
    }

    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; ++i) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void selectionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(array,left,right);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = left + (int) (Math.random() * (right - left + 1));
        int pivotVal = array[pivot];
        while (left <= right) {
            while (array[left] < pivotVal) {
                left++;
            }
            while (array[right] > pivotVal) {
                right--;
            }
            if (left == right) {
                break;
            }
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        return right;
    }

    public static void mergerSort(int[] a, int n) {
        int[] tmp = new int[n];
        mergerSortInternally(a, 0, n - 1, tmp);
    }

    private static void mergerSortInternally(int[] a, int left, int right, int[] tmp) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergerSortInternally(a, left, mid, tmp);
        mergerSortInternally(a, mid + 1, right, tmp);
        merge(a, left, mid, right, tmp);
    }

    private static void merge(int[] a, int left, int mid, int right, int[] tmp) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        while (j <= right) {
            tmp[k++] = a[j++];
        }
        k = 0;
        while (left <= right) {
            a[left++] = tmp[k++];
        }
    }


}
