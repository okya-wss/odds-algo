package algo.dp.dp优化;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1499 max-value-of-equation	满足不等式的最大值
 *
 * @author shuaishuai.wang
 **/
public class MaxValueOfEquation_1499 {

    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            // 下界
            while (!deque.isEmpty() &&  points[i][0] - points[deque.peekFirst()][0] > k) {
                deque.pollFirst();
            }
            if (!deque.isEmpty()) {
                ans = Math.max(ans,
                        Math.abs(points[deque.peekFirst()][0] - points[i][0]) + points[deque.peekFirst()][1] + points[i][1]);
            }
            // 放入队列的时机 也就是寻找 y -x 的最大值
            while (!deque.isEmpty() && points[deque.peekLast()][1] - points[deque.peekLast()][0] <= (points[i][1] - points[i][0])) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] points = {{1,3},{2,0},{5,10},{6,-10}};
        MaxValueOfEquation_1499 max = new MaxValueOfEquation_1499();
        max.findMaxValueOfEquation(points,1);

    }
}