package algo.dp;

/**
 * 72 edit-distance	编辑距离
 *
 * @author shuaishuai.wang
 **/
public class EditDistance_72 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        word1 = " " + word1;
        word2 = " " + word2;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            f[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            f[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int temp = word1.charAt(i) == word2.charAt(j) ? 0 : 1;
                f[i][j] = Math.min(Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1),
                        f[i - 1][j - 1] + temp);
            }
        }
        return f[n][m];
    }
}
