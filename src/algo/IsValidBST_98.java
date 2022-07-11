package algo;

/**
 * 98 验证二叉搜索树
 *
 * @author shuaishuai.wang
 * @date 2022-03-09
 **/
public class IsValidBST_98 {


    public boolean isValidBST(TreeNode root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean check(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        if (root.val > right || root.val < left) {
            return false;
        }
        return check(root.left, left, (long) root.val - 1) &&
                check(root.right, (long) root.val + 1, right);

    }
}
