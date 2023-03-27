package algo.greedy;

/**
 * 860 lemonade-change	柠檬水找零
 *
 * @author shuaishuai.wang
 * @date 2023-03-14
 **/
public class LemonadeChange_860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
