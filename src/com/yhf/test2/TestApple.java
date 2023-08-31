package com.yhf.test2;

/**
 * Created on 2023/8/22.
 *
 * @author qyjy4737
 */
public class TestApple {

    public static int maxProfit(int[] prices) {
        int[][] arr = new int[3][9];
        for (int i = 1; i <= 2; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < 9; j++) {
                arr[i][j] = Math.max(arr[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, arr[i - 1][j] - prices[j]);
            }
        }
        return arr[2][8];
    }

    public static void main(String[] args) {
        int[] prices = {8, 9, 2, 5, 4, 7, 1, 3, 6};
        int result = maxProfit(prices);
        System.out.println("===最大利润为===" + result);
    }
}
