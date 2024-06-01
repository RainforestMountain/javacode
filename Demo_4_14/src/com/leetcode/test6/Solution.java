package com.leetcode.test6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
        dfs(board, 0);
        return result;
    }

    public void dfs(char[][] board, int row) {
        if (row == board.length) {
            result.add(getList(board));
            return;
        }

        for (int i = 0; i < board[row].length; i++) {
            if (!isValid(board, row, i)) {
                continue;
            }
            board[row][i] = 'Q';
            dfs(board, row + 1);
            board[row][i] = '.';
        }
    }

    public List<String> getList(char[][] board) {
        List<String> path = new ArrayList<>();
        for (char[] v : board) {
            path.add(String.copyValueOf(v));
        }
        return path;
    }

    public boolean isValid(char[][] board, int row, int col) {
        //先遍历行
//        for (int i = 0; i < board[row].length; i++) {
//            if (board[row][i] == 'Q') {
//                return false;
//            }
//        }
        for (int i = 0; i < board[col].length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[row].length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> result = solution.solveNQueens(4);
        for (List<String> path : result) {
            for (String val : path) {
                System.out.println(val);
            }
            System.out.println();
        }
    }
}
