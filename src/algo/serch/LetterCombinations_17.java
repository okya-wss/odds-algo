package algo.serch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17 电话号码的字母组合
 *
 * @author shuaishuai.wang
 * @date 2022-03-17
 **/
public class LetterCombinations_17 {

    private final static Map<Character, String> PHONE_MAP = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        dfs(digits, 0, "");
        return ans;
    }

    private void dfs(String digits, int index, String s) {
        if (s.length() == digits.length()) {
            ans.add(s);
            return;
        }
        for (char c : PHONE_MAP.get(digits.charAt(index)).toCharArray()) {
            dfs(digits, index + 1, s + c);
        }
    }

}
