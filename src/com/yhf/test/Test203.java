package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test203 {
    /**
     * 题目0203-统计差异值大于相似值二元组个数
     * 题目描述
     * 题目描述： 对于任意两个正整数 AAA 和 BBB ，定义它们之间的差异值和相似值：
     * 差异值：AAA、BBB 转换成二进制后，对于二进制的每一位，对应位置的bit值不相同则为1，否则为0;
     * 相似值：AAA、BBB 转换成二进制后，对于二进制的每一位，对应位置的bit值都为1则为1，否则为0;
     * 现在有 nnn 个正整数 A0A_0A
     * 0
     * ​
     *   到 A(n−1)A_{(n-1)}A
     * (n−1)
     * ​
     *  ，问有多少对 (i,j)(i,j)(i,j) (0≤i<j<n)(0 \leq i < j < n)(0≤i<j<n)，AiA_iA
     * i
     * ​
     *   和 AjA_jA
     * j
     * ​
     *   的差异值大于相似值。
     * 假设 A=5,B=3A=5,B=3A=5,B=3；
     * 则 AAA 的二进制表示 101101101；BBB 的二进制表示 011011011；
     * 则 AAA 与 BBB 的差异值二进制为 110110110；相似值二进制为 001001001；
     * AAA 与 BBB 的差异值十进制等于 666，相似值十进制等于 111，满足条件。
     *
     * 输入描述
     * 输入：一个 nnn 接下来 nnn 个正整数
     * 数据范围： 1 <= n <= 10^5, 1 <= A[i] < 2^30
     *
     * 输出描述
     * 输出：满足差异值大于相似值的对数
     *
     * 思路
     * 差异值即为 按位异或 运算的结果；
     * 相似值即为 按位与 运算的结果；
     * 遍历运算并比较即可。
     *
     * 示例一
     * 输入
     * 4
     * 4 3 5 2
     * 输出
     * 4
     * 说明
     * 样例一解释：
     * 满足条件的分别是(0,1) (0,3) (1,2) (2,3)，共4对
     *
     * 示例二
     * 输入
     * 5
     * 3 5 2 8 4
     * 输出
     * 8
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = scanner.nextInt();
            }
            int res = solution(n, nums);
            System.out.println(res);
        }
    }

    private static int solution(int n, int[] nums) {
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = nums[i];
                int b = nums[j];
                if ((a ^ b) > (a & b)) {
                    count++;
                }
            }
        }
        return count;
    }
}
