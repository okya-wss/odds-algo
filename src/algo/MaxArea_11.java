package algo;

/**
 * * https://leetcode-cn.com/problems/container-with-most-water/?version=3.7.5&from=mac_yunguanjia&privilege=
 * 11. 盛最多水的容器
 *
 * @author shuaishuai.wang
 * @date 2021-07-27
 **/
public class MaxArea_11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = Math.min(height[left], height[right]) * (right - left);
        while (right >= left) {
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
            int ans = Math.min(height[left], height[right]) * (right - left);
            area = Math.max(area, ans);
        }
        return area;
    }
}
