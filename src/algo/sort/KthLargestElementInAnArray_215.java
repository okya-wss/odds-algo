package algo.sort;

/**
 * // 215 kth-largest-element-in-an-array 数组中的第K个最大元素
 *
 * @author shuaishuai.wang
 * @date 2023-04-17
 **/
public class KthLargestElementInAnArray_215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length < k) {
            return -1;
        }
        int partition = partition(nums, 0, nums.length - 1);
        while (partition + 1 != k) {
            if (partition + 1 < k) {
                partition = partition(nums, partition + 1, nums.length - 1);
            } else {
                partition = partition(nums, 0, partition - 1);
            }
        }
        return partition;
    }

    private int partition(int[] nums, int p, int r) {
        int pivotVal = nums[p];
        int i = p;
        for (int j = i; j < r; j++) {
            if (nums[j] <= pivotVal) {
                if (i < j) {
                    swap(nums, i, j);
                }
                i++;
            }
        }
        swap(nums, i, r);
        return i;
    }

    private void swap(int[] nums, int i, int j) {

    }
}
