package algo.sort;

/**
 * @author shuaishuai.wang
 * @date 2023-04-02
 **/
public class MergeSort {


    public void mergerSortInternally(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right - left) / 2 + left;
        mergerSortInternally(a, left, mid);
        mergerSortInternally(a, mid + 1, right);
        merge(a, left, mid, right);
    }


    private static void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        for (int k = 0; k < tmp.length; k++) {
            if (j > right || (i <= mid && a[i] <= a[j])) {
                tmp[k] = a[i++];
            } else {
                tmp[k] = a[j++];
            }
        }
        System.arraycopy(tmp, 0, a, left, tmp.length);
    }

}
