package com.yhf.test;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test126 {
    /**
     * 题目0126-数字的排列
     * 题目描述
     * 小华是个很有对数字很敏感的小朋友，
     * 他觉得数字的不同排列方式有特殊的美感。
     * 某天，小华突发奇想，如果数字多行排列，
     * 第一行1个数，
     * 第二行2个，
     * 第三行3个，
     * 即第n行n个数字，并且奇数行正序排列，
     * 偶数行逆序排列，数字依次累加。
     * 这样排列的数字一定很有意思，请帮小华实现。
     * 规则总结如下：
     *
     * 每个数字占据4个位置，不足四位用*补位，如1打印为1***
     * 数字之间相邻4空格
     * 数字的打印顺序按照正序逆序交替打印，奇数行正序，偶数行逆序
     * 最后一行数字顶格，第n-1行相对第n行缩进四个空格
     * 输入描述
     * 第一行输入为N，表示打印多少行，1 <= N <= 30
     *
     * 输出描述
     * XXXX1***
     * 3***XXXX2***
     * 示例一
     * 输入
     * 2
     * 输出
     * '
     *     1***
     * 3***    2***
     * '
     * 此处输出结果中没有首尾的'
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            solution(n);
        }
    }

    private static void solution(int n) {
        boolean asc = true;
        LinkedList<int[]> list = new LinkedList<>();
        int x = 1;
        for (int i = 1; i <= n; i++) {
            int[] arr = new int[i];

            if (asc) {
                for (int j = 0; j < arr.length; j++) {
                    arr[j] = x++;
                }
            } else {
                for (int j = arr.length - 1; j >= 0; j--) {
                    arr[j] = x++;
                }
            }

            list.push(arr);
            asc = !asc;
        }

        LinkedList<String> res = new LinkedList<>();
        StringBuilder head = new StringBuilder();
        StringBuilder content;

        for (int[] ints : list) {
            content = new StringBuilder();
            content.append(head);
            for (int j = 0; j < ints.length; j++) {

                int num = ints[j];
                content.append(num);
                for (int k = 0; k < 4 - (num + "").length(); k++) {
                    content.append("*");
                }
                if (j != ints.length - 1) {
                    content.append("    ");
                }
            }
            res.add(content.toString());
            head.append("    ");
        }

        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.println(res.get(i));
        }
    }
}
