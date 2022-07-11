package algo;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200 岛屿数量
 *
 * @author shuaishuai.wang
 * @date 2022-04-18
 **/
public class NumIslands_200 {
    private int m;
    private int n;
    private boolean[][] visit;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visit = new boolean[m][n];
        for (int i = 0; i < visit.length; i++) {
            for (int j = 0; j < visit[0].length; j++) {
                visit[i][j] = false;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1 && !visit[i][j]) {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int sx, int sy) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(sx, sy));
        visit[sx][sy] = true;
        while (!queue.isEmpty()) {
            int x = queue.peek().getKey();
            int y = queue.poll().getValue();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }
                if (grid[nx][ny] == '1' && !visit[nx][ny]) {
                    queue.offer(new Pair<>(nx,ny));
                    visit[nx][ny] = true;
                }
            }
        }
    }
}
