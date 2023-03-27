package algo.greedy;

import java.util.Arrays;

/**
 * 455 assign-cookies	分发饼干
 *
 * @author shuaishuai.wang
 * @date 2023-03-15
 **/
public class AssignCookies_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int res = 0;
        // 从胃口小的开始喂
        for (int cookie : s) {
            if (res < n && g[res] <= cookie) {
                res += 1;
            }
        }
        return res;
    }
}
