package algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 22 括号生成
 *
 * @author shuaishuai.wang
 * @date 2022-03-09
 **/
public class GenerateParenthesis_22 {

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n < 0) {
            return ans;
        }
        getParenthesis("", n, n);
        return ans;
    }

    private void getParenthesis(String s, int left, int right) {
        if (left == 0 && right == 0) {
            ans.add(s);
            return;
        }
        if (left == right) {
            getParenthesis(s + "(", left - 1, right);
        } else if (left < right) {
            if (left > 0) {
                getParenthesis(s + "(", left - 1, right);
            }
            getParenthesis(s + ")", left, right - 1);
        }
    }

    // public List<String> generateParenthesis(int n) {
    //     List<String> ans = new ArrayList<>();
    //     if (n == 0) {
    //         ans.add("");
    //     } else {
    //         for (int k = 1; k <= n; k++) {
    //             List<String> aList = generateParenthesis(k - 1);
    //             List<String> bList = generateParenthesis(n - k);
    //             for(String a : aList) {
    //                 for (String b : bList) {
    //                     ans.add("(" + a + ")" + b);
    //                 }
    //             }
    //         }
    //     }
    //
    //     return ans;
    // }
}
