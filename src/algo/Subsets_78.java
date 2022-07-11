package algo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 78 子集
 * @author shuaishuai.wang
 * @date 2022-03-09
 **/
public class Subsets_78 {

    private List<List<Integer>> ans = new ArrayList<>();

    private List<Integer> chosen = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        recur(0, nums);
        return ans;
    }

    private void recur(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(chosen));
            return;
        }
        chosen.add(nums[cur]);
        recur(cur + 1, nums);
        chosen.remove(chosen.size() - 1);
        recur(cur+ 1,nums);

     }


}
