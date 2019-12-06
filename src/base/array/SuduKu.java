package base.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Letmesea
 * @title: SuduKu
 * @projectName leetCode
 * @description: 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 * @date 2019/10/159:33
 */
public class SuduKu {
    public static boolean isValidSudoku(char[][] board) {
//        int ref[][] = new int[][]{{0,0}, {0,3}, {0,6}, {3,0},{3,3},{3,6},{6,0},{6,3},{6,6}};
        for(int i=0;i<9;i++){
            int row[] = new int[9];
            int col[] = new int[9];
            int k1=0,k2=0,k3=0;
//            int n1=ref[i][0],n2=ref[i][1];
            int[] block = new int[9];
            for (int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    row[k1++]=board[i][j];
                }
                if(board[j][i]!='.'){
                    col[k2++]=board[j][i];
                }
                int x = i / 3 * 3 + j / 3;
                int y = i % 3 * 3 + j % 3;
                if(board[x][y]!='.'){
                    block[k3++] = board[x][y];
                }
            }
            int [] r1 = new int[k1];
            for (int j=0;j<k1;j++){
                r1[j] = row[j];
            }
            if(containsDuplicate(r1)){
                return false;
            }
            int [] c1 = new int[k2];
            for (int j=0;j<k2;j++){
                c1[j] = col[j];
            }
            if(containsDuplicate(c1)){
                return false;
            }


//            for (int nn1=n1;nn1<n1+3;nn1++){
//                for (int nn2=n2;nn2<n2+3;nn2++){
//                    if(board[nn1][nn2]!='.'){
//                        block[k3++] = board[nn1][nn2];
//                    }
//                }
//            }
            int[] b1 = new int[k3];
            for (int j=0;j<k3;j++){
                b1[j] = block[j];
            }
            if(containsDuplicate(b1)){
                return false;
            }
        }
        return true;
    }
    public static boolean isValidSudoku1(char[][] board) {
        for(int i=0;i<9;i++){
            ArrayList<Character> row = new ArrayList<>();
            ArrayList<Character> col = new ArrayList<>();
            ArrayList<Character> block = new ArrayList<>();
            for (int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    row.add(board[i][j]);
                }
                if(board[j][i]!='.'){
                    col.add(board[j][i]);
                }
                int x = i / 3 * 3 + j / 3;
                int y = i % 3 * 3 + j % 3;
                if(board[x][y]!='.'){
                    block.add(board[x][y]);
                }
            }
            if(row.size() != new HashSet<Character>(row).size()){
                return false;
            }
            if(col.size() != new HashSet<Character>(col).size()){
                return false;
            }
            if(block.size() != new HashSet<Character>(block).size()){
                return false;
            }
        }
        return true;
    }
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
    public static boolean isValidSudoku2(char[][] board) {
        int[][] signs = new int[3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.'){
                    continue;
                }
                int a = board[i][j] -'0';   //char 转  int方法
                int n = 1 << a;
                int cubeIndex = i / 3 * 3 + j / 3;
                if ((signs[0][i] & n) != 0
                        || (signs[1][j] & n) != 0
                        || (signs[2][cubeIndex] & n) != 0){
                    return false;
                }

                signs[0][i] |= n;
                signs[1][j] |= n;
                signs[2][cubeIndex] |= n;
            }
        }
        return true;
    }
    public static boolean isValidSudoku3(char[][] board) {
        // 记录某行，某位数字是否已经被摆放
        boolean[][] row = new boolean[9][9];
        // 记录某列，某位数字是否已经被摆放
        boolean[][] col = new boolean[9][9];
        // 记录某 3x3 宫格内，某位数字是否已经被摆放
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int blockIndex = i / 3 * 3 + j / 3;
                    if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char board[][] = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
        };
        char board1[][] = new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        boolean res = isValidSudoku3(board1);
        System.out.print(111);
    }
}
