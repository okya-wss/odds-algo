package algo;

/**
 * // 26 remove-duplicates-from-sorted-array	删除有序数组中的重复项
 *
 * @author shuaishuai.wang
 * @date 2022-02-23
 **/
public class RemoveDuplicatesFromSortedArray_26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                //如果相差是1 则不需要原地复制
                if (fast-slow > 1) {
                    nums[slow + 1] = nums[fast];
                }
                slow++;
            }
            fast++;
        }
        return slow + 1;
    }
}
