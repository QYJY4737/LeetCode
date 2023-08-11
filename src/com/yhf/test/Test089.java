package com.yhf.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test089 {
    /**
     * 题目0089-报数
     * 题目描述
     * 一百个人围成一圈，每个人有一个编码编号从一开始到一百。
     * 他们从一开始依次报数，报道M的人自动退出圈圈，
     * 然后下一个人接着从1开始报数一直到剩余人数小于M。
     * 请问最后剩余人在原先的编码为多少？
     * <p>
     * 输入描述
     * 输入一个整数参数M
     * <p>
     * 输出描述
     * 如果输入参数M小于等于1或者大于等于100,输出ERROR!;
     * 否则按原先的编号从小到大的顺序，以英文逗号分割输出编号字符串
     * <p>
     * 示例一
     * 输入
     * 3
     * 输出
     * 58,91
     * 示例二
     * 输入
     * 4
     * 输出
     * 34,45,97
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int m = scanner.nextInt();
            solution(m);
        }
    }

    private static void solution(int m) {
        if (m <= 1 || m >= 100) {
            System.out.println("ERROR");
            return;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
        int curNo = 0;
        int pos = 0;
        while (list.size() >= m) {
            curNo++;
            if (curNo == m) {
                list.remove(pos);
                curNo = 0;
            } else {
                pos++;
            }
            if (pos == list.size()) {
                pos = 0;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1) {
                System.out.print(',');
            }
        }
    }
}
