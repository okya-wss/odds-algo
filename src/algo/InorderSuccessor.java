package algo;

import structure.TreeNode;

/**
 * 后继者 04.06
 *
 * @author shuaishuai.wang
 * @date 2022-04-20
 **/
public class InorderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return findSuc(root, p.val);
    }

    private TreeNode findSuc(TreeNode root, int val) {
        TreeNode curr = root;
        TreeNode ans = null;
        while (curr != null) {
            if (curr.val > val) {
                if (ans == null || ans.val > curr.val) {
                    ans = curr;
                }
            }
            if (curr.val == val) {
                if (curr.right != null) {
                    curr = curr.right;
                    while (curr.left != null) {
                        curr = curr.left;
                    }
                    return curr;
                }
                break;
            }
            if (curr.val > val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return ans;
    }
}
