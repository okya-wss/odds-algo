package algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * // 329 longest-increasing-path-in-a-matrix	矩阵中的最长递增路径
 * @author shuaishuai.wang
 * @date 2022-04-20
 **/
public class LongestIncreasingPathInAMatrix_329 {

    private int n;
    private int m;
    List<List<Integer>> to = new ArrayList<>();


    public int longestIncreasingPath(int[][] matrix) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        m = matrix.length;
        n = matrix[0].length;
        for (int i = 0; i < n * m; i++) {
            to.add(new ArrayList<>());
        }
        int[] degree = new int[n * m];
        int[] depth = new int[n * m];
        for (int i = 0; i < n * m; i++) {
            depth[i] = 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || matrix[nx][ny] <= matrix[i][j]) {
                        continue;
                    }
                    to.get(i * n + j).add(nx * n + j);
                    degree[i * n + j]++;
                }
            }
        }
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y : to.get(x)) {
                degree[y]--;
                if (degree[y] == 0) {
                    queue.add(y);
                    depth[y] = depth[x] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < degree.length; i++) {
            ans = Math.max(ans, depth[i]);
        }
        return ans;
    }

    int[][] matrix;
    int[][] dist;
    public int longestIncreasingPathDfs(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;

        dist = new int[m][n];
        int ans = 0;
        for (int i = 0; i <m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i,j));
            }
        }
        return ans;
    }

    private int dfs(int x, int y) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        if (dist[x][y] != 0) {
            return dist[x][y];
        }
        dist[x][y] = 1;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || matrix[nx][ny] <= matrix[x][y]) {
                continue;
            }
            dist[x][y] = Math.max(dist[x][y], dfs(nx,ny) + 1);
        }
        return dist[x][y];
    }

}
