package algo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 433 最小基因变化
 *
 * @author shuaishuai.wang
 * @date 2022-04-19
 **/
public class MinMutation_433 {

    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String str : bank) {
            bankSet.add(str);
        }
        if (!bankSet.contains(end)) {
            return -1;
        }
        char[] gen = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (s.equals(end)) {
                return visited.size() - 1;
            }
            for (int i = 0; i < 8; i++) {
                StringBuilder ns = new StringBuilder(s);
                for (int j = 0; j < 4; j++) {
                    if (s.charAt(i) != gen[j]) {
                        String replaced = ns.replace(i, i + 1, String.valueOf(gen[j])).toString();
                        if (!visited.contains(replaced) && bankSet.contains(replaced)) {
                            queue.offer(replaced);
                            visited.add(replaced);
                        }

                    }
                }
            }
        }
        return -1;
    }
}
