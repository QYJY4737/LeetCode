package com.yhf.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test067 {
    /**
     * 题目0067-水仙花数
     * 页面内容
     * 讨论
     * 最后编辑
     * Amos
     * 08/03/2022
     * 水仙花数
     * 题目描述
     * 所谓的水仙花数是指一个n位的正整数其各位数字的n次方的和等于该数本身，
     * 例如153 = 1^3 + 5^3 + 3^3,153是一个三位数
     * <p>
     * 输入描述
     * 第一行输入一个整数N，
     * 表示N位的正整数N在3-7之间包含3,7
     * 第二行输入一个正整数M，
     * 表示需要返回第M个水仙花数
     * <p>
     * 输出描述
     * 返回长度是N的第M个水仙花数，
     * 个数从0开始编号，
     * 若M大于水仙花数的个数返回最后一个水仙花数和M的乘积，
     * 若输入不合法返回-1
     * <p>
     * 示例一
     * 输入
     * 3
     * 0
     * 输出
     * 153
     * 说明
     * 153是第一个水仙花数
     * <p>
     * 示例二
     * 输入
     * 9
     * 1
     * 输出
     * -1
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            solution(n, m);
        }
    }

    private static void solution(int n, int m) {
        if (n < 3 || n > 7) {
            System.out.print(-1);
            return;
        }
        List<Integer> res = new LinkedList<>();
        int start = (int) Math.pow(10, n - 1);
        int end = (int) Math.pow(10, n);
        for (int i = start; i < end; i++) {
            int sum = 0;
            int bit = start;
            while (bit != 1) {
                sum += Math.pow(i / bit % 10, n);
                bit /= 10;
            }
            sum += Math.pow(i % 10, n);
            if (sum == i) {
                res.add(i);
            }
            if (res.size() == m + 1) {
                System.out.print(i);
                return;
            }
        }
        if (m > res.size()) {
            System.out.print(m * res.get(res.size() - 1));
        }
    }
}
