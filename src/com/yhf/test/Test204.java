package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test204 {
    /**
     * 题目0204-新员工座位安排系统
     * 题目描述
     * 工位由序列 F1,F2...FnF_1,F_2...F_nF
     * 1
     * ​
     * ,F
     * 2
     * ​
     * ...F
     * n
     * ​
     * 组成， FiF_iF
     * i
     * ​
     * 值为 000 、111 或 222 ，其中 000 代表空置，111 代表有人，222 代表障碍物。
     * <p>
     * 某一空位的友好度为左右连续老员工工数之和
     * 为方便新员工学习求助，优先安排友好度高的空位；
     * 给出工位序列，求所有空位中友好度的最大值。
     * 输入描述
     * 第一行为工位序列: F1，F2...FnF_1，F_2...F_nF
     * 1
     * ​
     * ，F
     * 2
     * ​
     * ...F
     * n
     * ​
     * 组成，1≤n≤1000001 \leq n \leq 1000001≤n≤100000 ，FiF_iF
     * i
     * ​
     * 值为 000 、111 或 222 ，其中 000 代表空置，111 代表有人，222 代表障碍物。
     * <p>
     * 输出描述
     * 所有空位中友好度的最大值。如果没有空位，返回 000。
     * <p>
     * 示例一
     * 输入
     * 0 1 0
     * 输出
     * 1
     * 示例二
     * 输入
     * 1 1 0 1 2 1 0
     * 输出
     * 3
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            int max = solution(line);
            System.out.print(max);
        }
    }

    private static int solution(String line) {
        String sites = line.replaceAll(" ", "");
        char[] chars = sites.toCharArray();
        int max = 0;


        for (int i = 0; i < sites.length(); i++) {
            int index = sites.indexOf("0", i);
            if (index == -1) {
                break;
            }

            i = index;
            int tmp = 0;
            while (index > 0 && chars[index - 1] == '1') {
                index--;
                tmp++;
            }
            index = i;
            while (index < sites.length() - 1 && chars[index + 1] == '1') {
                index++;
                tmp++;
            }
            max = Math.max(max, tmp);
        }

        return max;
    }
}
