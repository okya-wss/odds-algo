package structure;

/**
 * @author shuaishuai.wang
 * @date 2021-03-05
 **/
public class Bsearch {


    /**
     * 1.1 查找后继者
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (right + left) >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    /**
     * 1.2 查找前驱
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (right + left) >> 1;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public int bsearch1(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                high = mid - 1;
            } else if (a[mid] > value) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int bsearch2(int[] a, int n, int value) {
        return bsearchInternally(a, 0, n - 1, value);
    }

    private int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid + 1, high, value);
        } else if (a[mid] > value) {
            return bsearchInternally(a, low, mid - 1, value);
        }
        return -1;
    }


}
