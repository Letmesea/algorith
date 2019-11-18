package base.array;

/**
 * @author Letmesea
 * @title: Rotate
 * @projectName leetCode
 * @description: TODO
 * @date 2019/10/1615:49
 */
public class Rotate {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
            for (int i = 0; i < n / 2; i++) {
                for (int j = i; j < n - i-1; j++) {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[n-j-1][i];
                    matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                    matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                    matrix[j][n-i-1] = t;
                }
            }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}

                };
        rotate(a);
        System.out.print(111);
    }
}
