package LeetCode;

/**
 * ${Description}
 *
 * @author KeithLiu on 2020-03-27
 */

public class LC240_Search_A_2D_Matrix_II {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0|| matrix[0] == null || matrix[0].length == 0) return false;
            int row = matrix.length;
            int col = matrix[0].length;
            int i = row - 1;
            int j = 0;
            while (i >= 0 && j < col) {
                if (matrix[i][j] > target) {
                    i--;
                }else if (matrix[i][j] < target) {
                    j++;
                }else {
                    return true;
                }
            }

            return false;
        }
}
