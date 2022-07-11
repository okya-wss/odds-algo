package algo;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 树的中序遍历
 *
 * @author shuaishuai.wang
 * @date 2022-03-09
 **/
public class InorderTraversal_94 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                ans.add(root.val);
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            root = cur.right;
        }
        return ans;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }




    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    //     if (root == null) {
    //         return ans;
    //     }
    //     dfs(root, ans);
    //     return ans;
    // }
    //
    // private void dfs(TreeNode root, List<Integer> ans) {
    //     if (root == null) {
    //         return;
    //     }
    //
    //     dfs(root.left, ans);
    //     ans.add(root.val);
    //     dfs(root.right, ans);
    // }
}
