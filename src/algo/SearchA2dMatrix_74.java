package algo;

/**
 * // 74 search-a-2d-matrix	搜索二维矩阵
 *
 * @author shuaishuai.wang
 * @date 2022-04-22
 **/
public class SearchA2dMatrix_74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid / n][mid % n] < target) {
                left = mid + 1;
            } else if (matrix[mid / n][mid % n] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
    }
}
