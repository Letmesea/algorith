package base.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Letmesea
 * @title: SuduKu
 * @projectName leetCode
 * @description: TODO
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
