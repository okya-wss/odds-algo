package algo.dp.树形dp;

import structure.TreeNode;

/**
 * 337 house-robber-iii	打家劫舍 III
 *
 * @author shuaishuai.wang
 * @date 2022-07-19
 **/
public class HouseRobberIii_337 {
    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dp(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] res = new int[2];
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }
}
