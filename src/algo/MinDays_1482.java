package algo;

/**
 * 1482 制作m束花所需的最少天数
 *
 * @author shuaishuai.wang
 * @date 2022-04-28
 **/
public class MinDays_1482 {
    private int[] bloomDay;

    public int minDays(int[] bloomDay, int m, int k) {
        if (m > bloomDay.length / k) {
            return -1;
        }
        this.bloomDay = bloomDay;
        int left = Integer.MAX_VALUE;
        int right = 0;
        for (int num : bloomDay) {
            left = Math.min(num, left);
            right = Math.max(num, right);
        }
        while (left < right) {
            int mid = (right + left) / 2;
            if (validete(m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean validete(int m, int k, int mid) {
        int flowers = 0;
        int bouquets = 0;
        for (int num : bloomDay) {
            if (num <= mid) {
                flowers++;
                if (flowers == k) {
                    flowers = 0;
                    bouquets++;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
