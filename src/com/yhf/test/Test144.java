package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test144 {
    /**
     * 题目0144-贪心的商人
     * 题目描述
     * 商人经营一家店铺，有number种商品，
     * 由于仓库限制每件商品的最大持有数量是item[index]
     * 每种商品的价格是item-price[item_index][day]
     * 通过对商品的买进和卖出获取利润
     * 请给出商人在days天内能获取的最大的利润
     * 注：同一件商品可以反复买进和卖出
     *
     * 输入描述
     * 3 第一行输入商品的数量number
     * 3 第二行输入商品售货天数 days
     * 4 5 6 第三行输入仓库限制每件商品的最大持有数量是item[index]
     * 1 2 3 第一件商品每天的价格
     * 4 3 2 第二件商品每天的价格
     * 1 5 3 第三件商品每天的价格
     *
     * 输出描述
     * 输出商人在这段时间内的最大利润
     * 例如：32
     *
     * 示例一
     * 输入
     * 3
     * 3
     * 4 5 6
     * 1 2 3
     * 4 3 2
     * 1 5 2
     * 输出
     * 32
     * 说明
     * 示例二
     * 输入
     * 1
     * 1
     * 1
     * 1
     * 输出
     * 0
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int number = scanner.nextInt();
            int days = scanner.nextInt();
            int[] items = new int[number];
            for (int i = 0; i < items.length; i++) {
                items[i] = scanner.nextInt();
            }
            int[][] price = new int[number][days];
            for (int i = 0; i < price.length; i++) {
                for (int j = 0; j < price[i].length; j++) {
                    price[i][j] = scanner.nextInt();
                }
            }
            solution(items, price);
        }

    }

    private static void solution(int[] items, int[][] price) {
        int sum = 0;
        for (int k = 0; k < price.length; k++) {
            int[] ints = price[k];
            //从后往前找到最大差
            int maxDiff = 0;
            for (int i = ints.length - 1; i >= 0; i--) {
                for (int j = i - 1; j >= 0; j--) {
                    if (ints[i] > ints[j]) {
                        maxDiff = Math.max(maxDiff, ints[i] - ints[j]);
                    }
                }
            }
            sum += items[k] * maxDiff;
        }
        System.out.println(sum);
    }
}
