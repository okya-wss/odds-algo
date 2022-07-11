package algo;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/walking-robot-simulation/
 *
 * @author shuaishuai.wang
 * @date 2022-02-22
 **/
public class RobotSim_874 {

    public static int robotSim(int[] commands, int[][] obstacles) {
        // N 1,E 2,  s 3 , w 4
        int dr = 0;
        //方向
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        //原点初始化
        int x = 0;
        int y = 0;
        int dis = 0;
        HashSet<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "_" + obstacle[1]);
        }
        for (int command : commands) {
            if (command == -1) {
                dr = (dr + 1) % 4;
            } else if (command == -2) {
                dr = (dr + 3) % 4;
            } else {
                for (int j = 0; j < command; j++) {
                    if (set.contains((x + dx[dr]) + "_" + (y + dy[dr]))) {
                        break;
                    }
                    x = x + dx[dr];
                    y = y + dy[dr];
                    dis = Math.max(dis, x * x + y * y);
                }
            }
        }
        return dis;
    }


    public static void main(String[] args) {
        int[][] obstacles = {};
        System.out.println(robotSim(new int[]{4,-1,3}, obstacles));
    }
}
