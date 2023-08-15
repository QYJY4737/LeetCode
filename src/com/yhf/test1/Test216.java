package com.yhf.test1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test216 {
    /**
     * 题目0216-组装新的数组
     * 题目描述
     * 给你一个整数 MMM 和数组 NNN, NNN中的元素为连续整数，要求根据 NNN 中的元素组装成新的数组 RRR，组装规则：
     * <p>
     * RRR 中元素总和加起来等于 MMM
     * RRR 中的元素可以从 NNN 中重复选取
     * RRR 中的元素最多只能有1个不在N中，且比N中的数字都要小（不能为负数）
     * 请输出：数组 RRR 一共有多少组装办法
     * 输入描述
     * 第一行输入是连续数组 NNN，采用空格分隔
     * 第二行输入数字 MMM
     * <p>
     * 输出描述
     * 输出的是组装办法数量，int类型
     * <p>
     * 备注
     * 1≤N.length≤301 \leq N.length \leq 301≤N.length≤30
     * 1≤N.length≤10001 \leq N.length \leq 10001≤N.length≤1000
     * <p>
     * 示例一
     * 输入
     * 2
     * 5
     * 输出
     * 1
     * 说明
     * 只有1种组装办法，就是[2,2,1]
     * <p>
     * 示例二
     * 输入
     * 2 3
     * 5
     * 输出
     * 2
     * 说明
     * 一共2种组装办法，分别是[2,2,1] , [2,3]
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Integer[] arr =
                    Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

            int m = Integer.parseInt(scanner.nextLine());

            System.out.println(solution(arr, m));
        }
    }

    public static int solution(Integer[] arr, int m) {
        Integer[] newArr = Arrays.stream(arr).filter(val -> val <= m).toArray(Integer[]::new);
        int min = newArr[0];

        return dfs(newArr, 0, 0, min, m, 0);
    }

    public static int dfs(Integer[] arr, int index, int sum, int min, int m, int count) {
        if (sum > m) {
            return count;
        }

        if (sum == m || (m - sum < min && m - sum > 0)) {
            return count + 1;
        }

        for (int i = index; i < arr.length; i++) {
            count = dfs(arr, i, sum + arr[i], min, m, count);
        }

        return count;
    }
}
