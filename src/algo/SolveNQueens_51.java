package algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 51. N 皇后问题
 *
 * @author shuaishuai.wang
 * @date 2022-03-17
 **/
public class SolveNQueens_51 {

    private boolean[] used;

    private boolean[] usedPlus;

    private boolean[] usedMinus;

    private Deque<Integer> queue = new ArrayDeque<>();

    private List<List<String>> ans = new ArrayList<>();


    private int n;

    // \ 该方向 row - col 相等
    // /该方向 row + col 相等

    public List<List<String>> solveNQueens(int n) {
        used = new boolean[n];
        usedPlus = new boolean[2 * n + 1];
        usedMinus = new boolean[2 * n + 1];
        this.n = n;
        dfs(0);
        return ans;
    }

    private void dfs(int row) {
        if (row == n) {
            ans.add(convert2board(queue));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!used[col] && !usedPlus[col + row] && !usedMinus[row - col + n]) {
                queue.addLast(col);
                used[col] = true;
                usedPlus[col + row] = true;
                usedMinus[row - col + n] = true;

                dfs(row + 1);

                used[col] = false;
                usedPlus[col + row] = false;
                usedMinus[row - col + n] = false;
                queue.removeLast();
            }
        }
    }

    private List<String> convert2board(Deque<Integer> path) {
        return path.stream().map(col -> IntStream.rangeClosed(1, path.size())
                .mapToObj(i -> i == col ? "Q" : ".").collect(Collectors.joining("")))
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        SolveNQueens_51 solveNQueens_51 = new SolveNQueens_51();
        solveNQueens_51.solveNQueens(4);
    }
}
