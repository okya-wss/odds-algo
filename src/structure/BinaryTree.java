package structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shuaishuai.wang
 * @date 2021-03-08
 **/
public class BinaryTree {

    /**
     * 广度优先遍历
     *
     * @param root 根结点
     * @return 遍历结果
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode treeNode = queue.poll();
                level.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                ret.add(level);
            }
        }
        return ret;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        levelHelper(ret, root, 0);
        return ret;
    }

    private void levelHelper(List<List<Integer>> ret, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level >= ret.size()) {
            ret.add(new ArrayList<>());
        }
        ret.get(level).add(root.val);
        levelHelper(ret, root.left, level + 1);
        levelHelper(ret, root.right, level + 1);
    }

    /**
     * 自顶向下
     *
     * @param root
     * @return
     */
    public static boolean isBalance1(TreeNode root) {

        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalance1(root.left) && isBalance1(root.right);
        }
    }

    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }


    /**
     * 判断是否是平衡二叉树
     * 自下而上
     *
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        return balanced(root) >= 0;
    }

    private static int balanced(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = balanced(root.left);
        int rightHeight = balanced(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }


    /**
     * 合并二叉树   深度优先
     *
     * @param root1
     * @param root2
     * @return
     */
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        TreeNode mergeNode = new TreeNode(root1.val + root2.val);
        mergeNode.left = mergeTrees(root1.left, root2.left);
        mergeNode.right = mergeTrees(root1.right, root2.right);
        return mergeNode;
    }



}
