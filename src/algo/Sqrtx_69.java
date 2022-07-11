package algo;

/**
 * // 69 sqrtx	x 的平方根
 *
 * @author shuaishuai.wang
 * @date 2022-04-22
 **/
public class Sqrtx_69 {

    public static int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(0));
        ;
    }
}
