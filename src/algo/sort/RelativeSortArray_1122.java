package algo.sort;

import java.util.*;

/**
 * 1122 relative-sort-array 数组的相对排序
 *
 * @author shuaishuai.wang
 * @date 2023-04-03
 **/
public class RelativeSortArray_1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : arr1) {
            list.add(num);
        }
        for (int i = 0; i < arr2.length; i++)  {
            map.put(arr2[i], i);
        }
        list.sort((x, y) -> {
            if (map.containsKey(x) || map.containsKey(y)) {
                return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            }
            return x - y;
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }
}
