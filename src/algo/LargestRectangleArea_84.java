package algo;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * // 84 largest-rectangle-in-histogram	柱状图中最大的矩形
 *
 * @author shuaishuai.wang
 * @date 2022-03-01
 **/
public class LargestRectangleArea_84 {
    public static int largestRectangleArea(int[] heights) {
        int length = heights.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return heights[0];
        }

        int[] newHeights = new int[length + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, length);
        newHeights[length + 1] = 0;
        heights = newHeights;

        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int currHeight = heights[stack.pop()];
                //宽度要考虑左边
                int currWidth = i - stack.peek() - 1;
                res = Math.max(res, currHeight * currWidth);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 2}));
    }
}
