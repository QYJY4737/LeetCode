package com.yhf.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test069 {
    /**
     * 题目0069-好朋友
     * 题目描述
     * 在学校中
     * N个小朋友站成一队
     * 第i个小朋友的身高为height[i]
     * 第i个小朋友可以看到第一个比自己身高更高的小朋友j
     * 那么j是i的好朋友
     * (要求：j > i)
     * 请重新生成一个列表
     * 对应位置的输出是每个小朋友的好朋友的位置
     * 如果没有看到好朋友
     * 请在该位置用0代替
     * 小朋友人数范围 0 ~ 40000
     * <p>
     * 输入描述
     * 第一行输入N
     * N表示有N个小朋友
     * 第二行输入N个小朋友的身高height[i]
     * 都是整数
     * <p>
     * 输出描述
     * 输出N个小朋友的好朋友的位置
     * <p>
     * 示例一
     * 输入
     * 2
     * 100 95
     * 输出
     * 0 0
     * 说明
     * 第一个小朋友身高100站在队伍末尾
     * 向队首看 没有比他身高高的小朋友
     * 所以输出第一个值为0
     * 第二个小朋友站在队首前面也没有比他身高高的小朋友
     * 所以输出第二个值为0
     * <p>
     * 示例二
     * 输入
     * 8
     * 123 124 125 121 119 122 126 123
     * 输出
     * 1 2 6 5 5 6 0 0
     * 说明
     * 123的好朋友是1位置上的124
     * 124的好朋友是2位置上的125
     * 125的好朋友是6位置上的126
     * 以此类推
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = scanner.nextInt();
            }
            solution(n, ints);
        }
    }

    private static void solution(int n, int[] ints) {
        if (n == 0) {
            System.out.print(0);
            return;
        }
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int pos = 0;
            for (int j = i + 1; j < n; j++) {
                if (ints[j] > ints[i]) {
                    pos = j;
                    break;
                }
            }
            res.add(pos);
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i != res.size() - 1) {
                System.out.print(' ');
            }
        }
    }
}
