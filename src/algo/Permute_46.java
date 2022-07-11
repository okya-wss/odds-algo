package algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 46全排列
 *
 * @author shuaishuai.wang
 * @date 2022-03-09
 **/
public class Permute_46 {

    private List<List<Integer>> ans = new ArrayList<>();

    private Deque<Integer> chosen = new ArrayDeque<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        recur(0, nums, used);
        return ans;
    }

    private void recur(int pos, int[] nums, boolean[] used) {
        if (chosen.size() == nums.length) {
            ans.add(new ArrayList<>(chosen));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                chosen.push(nums[i]);
                used[i] = true;
                recur(pos + 1, nums, used);
                chosen.pop();
                used[i] = false;
            }

        }
    }

    public static void main(String[] args) {
        Permute_46 p = new Permute_46();
        p.permute(new int[]{1,2,3});
    }
}
