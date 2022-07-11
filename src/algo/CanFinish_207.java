package algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 207 课程表
 *
 * @author shuaishuai.wang
 * @date 2022-03-15
 **/
public class CanFinish_207 {
    List<List<Integer>> edges;
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> lesson = new ArrayList<>();
        while (!queue.isEmpty()) {
            int x = queue.poll();
            lesson.add(x);
            for (int y : edges.get(x)) {
                indeg[y]--;
                if(indeg[y] == 0) {
                    queue.offer(y);
                }
            }
        }
        return lesson.size() == numCourses;
    }
}
