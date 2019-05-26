package com.niu.algorithm_stater;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by ami on 2019/5/26.
 */
public class Sudoku {

    public void solveSudoku(char[][] board) {
        boolean[][] l = new boolean[9][9];
        boolean[][] c = new boolean[9][9];
        boolean[][] s = new boolean[9][9];
        for (int line = 0; line < 9; line++) {
            for (int col = 0; col < 9; col++) {
                if ('.' == board[line][col])
                    continue;
                l[line][board[line][col] - '1'] = true;
                c[col][board[line][col] - '1'] = true;
                s[line / 3 * 3 + col / 3][board[line][col] - '1'] = true;
            }
        }
        solve(board, 0, l, c, s);
    }

    private boolean solve(char[][] board, int position, boolean[][] l, boolean[][] c, boolean[][] s) {
        int index = position;
        //遍历"."处的位置
        for (; index < 81 && '.' != board[index / 9][index % 9]; index++) ;
        //遍历81格
        if (index < 81) {
            int line = index / 9;
            int col = index % 9;
            for (int i = 1; i < 10; i++) {
                //判断行列格中是否出现1-9的值
                if (l[line][i - 1] || c[col][i - 1] || s[line / 3 * 3 + col / 3][i - 1])
                    continue;
                //填入尝试的数值
                board[line][col] = (char) ('0' + i);
                l[line][i - 1] = true;
                c[col][i - 1] = true;
                s[line / 3 * 3 + col / 3][i - 1] = true;
                //递归
                if (solve(board, index + 1, l, c, s)) {
                    return true;
                }
                //回溯
                board[line][col] = '.';
                l[line][i - 1] = false;
                c[col][i - 1] = false;
                s[line / 3 * 3 + col / 3][i - 1] = false;
            }
            return false;
        }
        return true;
    }


    @Test
    public void test(){
        char[][] board =
                {
                        {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}
                };

        new Sudoku().solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

    }


}
