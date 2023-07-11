package algo.dp.dp优化;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 918 maximum-sum-circular-subarray	环形子数组的最大和
 *
 * @author shuaishuai.wang
 **/
public class MaximumSumCircularSubarray_918 {


    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] nums1 = new int[n + 1];
        nums1[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            nums1[i] = nums[i - 1];
        }
        //方法二 ： 滑动窗口
        int[] ss = new int[2 * n + 1];
        ss[0] = 0;
        for (int i = 1; i <= n; i++) {
            ss[i] = nums1[i] + ss[i - 1];
        }
        for (int i = n + 1; i < 2 * n + 1; i++) {
            ss[i] = ss[i - 1] + nums1[i - n];
        }
        // 单调递增的队列，  ss[i] - 队头的最小值
        Deque<Integer> q = new LinkedList<>();
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= 2 * n; i++) {
            while (!q.isEmpty() && q.peekFirst() < i - n) {
                q.pollFirst();
            }
            if (!q.isEmpty()) {
                ans = Math.max(ans, ss[i] - ss[q.peekFirst()]);
            }
            // 最大和 减去最小和， 进入队列的要求是最小和
            while (!q.isEmpty() && ss[q.peekLast()] >= ss[i]) {
                q.pollLast();
            }
            q.addLast(i);
        }
        return ans;
    }


    public int maxSubarraySumCircular2(int[] nums) {
        // case 1: 不跨越首尾
        int n = nums.length;
        int[] s = new int[n + 1];
        s[0] = 0;
        for (int i = 1; i < n; i++) {
            s[i] = nums[i] + s[i - 1];
        }
        int temp = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            temp = Math.min(temp, s[i - 1]);
            ans = Math.max(ans, s[i] - temp);
        }
        //case 2: 跨越首尾，开头取一段 结尾取一段， 最大和减去最小和

        temp = Integer.MIN_VALUE;
        int ansMin = Integer.MAX_VALUE;
        // ansMin 不能全取 即不能S[n] - s[0]
        for (int i = 2; i <= n; i++) {
            temp = Math.max(temp, s[i - 1]);
            ansMin = Math.min(ansMin, s[i] - temp);
        }

        return Math.max(ans, s[n] - ansMin);
    }

    public int test(int[] nums) {
        int n = nums.length;
        int[] num1 = new int[n + 1];
        num1[0] = 0;
        for (int i = 1; i <= n; i++) {
            num1[i] = nums[i - 1];
        }
        int[] ss = new int[2 * n + 1];
        for (int i = 1; i <= n; i++) {
            ss[i] = ss[i - 1] + num1[i];
        }
        for (int i = n + 1; i <= 2 * n; i++) {
            ss[i] = ss[i - 1] + num1[i - n];
        }
        Deque<Integer> deque = new LinkedList<>();
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= 2 * n; i++) {
            while (!deque.isEmpty() && i - deque.peekFirst() < n) {
                deque.pollFirst();
            }
            if (!deque.isEmpty()) {
                ans = Math.max(ans, ss[i] - ss[deque.peekFirst()]);
            }
            while (!deque.isEmpty() && ss[i] <= ss[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return ans;
    }

}