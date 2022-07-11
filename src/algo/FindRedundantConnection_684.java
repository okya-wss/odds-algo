package algo;

/**
 * 冗余连接
 *
 * @author shuaishuai.wang
 * @date 2022-03-15
 **/
public class FindRedundantConnection_684 {
    private boolean hasCycle;
    int n = 0;
    int[][] to;
    boolean[] visited;

    public int[] findRedundantConnection(int[][] edges) {

        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            n = Math.max(n, Math.max(x, y));
        }
        to = new int[n + 1][];
        visited = new boolean[n + 1];
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            to[x][i] = x;
            to[y][i] = y;
            hasCycle = false;
            for (int j = 1; j < visited.length; j++) {
                visited[j] = false;
            }
            dfs(x, 0);
            if (hasCycle) {
                return edges[i];
            }
        }
        return new int[]{};
    }


    private void dfs(int x, int fa) {
        visited[x] = true;
        for (int y : to[x]) {
            if (y == fa) {
                continue;
            }
            if (!visited[y]) {
                dfs(y, x);
            } else {
                hasCycle = true;
            }
        }
    }
}
