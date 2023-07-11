package algo.sort;

/**
 * @author shuaishuai.wang
 * @date 2023-04-02
 **/
public class QuickSort {

    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(array, left, right);
        quickSort(array, left, pivot);
        quickSort(array, pivot + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int pivot = left + (int) (Math.random() * (right - left + 1));
        int pivotVal = array[pivot];
        while (left <= right) {
            while (array[left] < pivotVal) {
                left++;
            }
            while (array[right] > pivotVal) {
                right--;
            }

            if (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        return right;
    }
}
