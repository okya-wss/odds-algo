package algo;

import java.util.Deque;
import java.util.LinkedList;

/**
 * // 239 sliding-window-maximum	滑动窗口最大值
 *
 * @author shuaishuai.wang
 * @date 2022-04-20
 **/
public class SlidingWindowMaximum_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int right = 0; right < nums.length; right++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[right]) {
                queue.removeLast();
            }
            queue.addLast(right);
            int left = right - k + 1;
            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }
            if (right + 1 > k) {
                res[left] = queue.peekFirst();
            }
        }
        return res;
    }
}
