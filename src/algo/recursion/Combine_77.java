package algo.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 77 组合
 *
 * @author shuaishuai.wang
 * @date 2022-03-09
 **/
public class Combine_77 {

    private List<List<Integer>> ans = new ArrayList<>();

    private List<Integer> chosen = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        recur(1, n, k);
        return ans;
    }


    private void recur(int cur, int n, int k) {
        if (chosen.size() + (n - cur + 1) < k) {
            return;
        }
        if (chosen.size() == k) {
            ans.add(new ArrayList<>(chosen));
            return;
        }
        chosen.add(cur);
        recur(cur + 1, n, k);
        chosen.remove(chosen.size() - 1);
        recur(cur + 1, n, k);

    }
}
