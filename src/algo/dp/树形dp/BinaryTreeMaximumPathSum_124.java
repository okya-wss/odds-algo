package algo.dp.树形dp;

import structure.TreeNode;

/**
 * 124 binary-tree-maximum-path-sum	二叉树中的最大路径和
 * @author shuaishuai.wang
 * @date 2023-02-22
 **/
public class BinaryTreeMaximumPathSum_124 {

    private Integer maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxSum;
    }

    public int pathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(pathSum(root.left), 0);
        int rightSum = Math.max(pathSum(root.right), 0);

        // 本级的
        int pricePath = root.val + leftSum + rightSum;
        maxSum = Math.max(maxSum, pricePath);
        // 如果左右子节点都计算上 是无法返回给上级节点的， 一个子节点加上本身才能继续向上；
        return root.val + Math.max(leftSum, rightSum);
    }
}
