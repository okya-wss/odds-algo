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



}
