package algo.sort;

/**
 * @author shuaishuai.wang
 * @date 2023-04-01
 **/
public class InsertSort {

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
}
