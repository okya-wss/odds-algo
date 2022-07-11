package structure;

/**
 * @author shuaishuai.wang
 * @date 2021-03-25
 **/
public class Heap {


    /**
     * 建堆
     *
     * @param arr
     */
    private static void buildHeap(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            heapify(arr, arr.length - 1, i);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        while (true) {
            //最大值位置
            int maxPos = i;
            // 与左子节点（i * 2 + 1）比较，获取最大值位置
            if (i * 2 + 1 <= n && arr[i] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (i * 2 + 2 <= n && arr[maxPos] < arr[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            if (maxPos == i) {
                break;
            }
            swap(arr, i, maxPos);
            i = maxPos;
        }
    }

    private static void swap(int[] arr, int i, int maxPos) {
        int tmp = arr[i];
        arr[i] = arr[maxPos];
        arr[maxPos] = tmp;
    }


    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        buildHeap(arr);
        int k = arr.length - 1;
        while (k > 0) {
            swap(arr, 0 ,k);
            heapify(arr, --k, 0);
        }
    }
}
