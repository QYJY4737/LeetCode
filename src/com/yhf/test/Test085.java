package com.yhf.test;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test085 {
    /**
     * 题目0085-水仙花数2
     * 题目描述
     * 给定非空字符串s，将该字符串分割成一些子串
     * 使每个子串的ASCII码值的和均为水仙花数
     * <p>
     * 若分割不成功则返回0
     * 若分割成功且分割结果不唯一 则返回-1
     * 若分割成功且分割结果唯一 则返回分割后子串的数目
     * 输入描述
     * 输入字符串的最大长度为200
     * <p>
     * 输出描述
     * 根据题目描述中的情况返回响应结果
     * <p>
     * 示例一
     * 输入
     * abc
     * 输出
     * 0
     * 说明
     * 分割不成功
     * <p>
     * 示例二
     * 输入
     * f3@d5a8
     * 输出
     * -1
     * 说明
     * 分割成功但分割结果不唯一
     * 可以分割为两组
     * 一组 f3和@d5a8
     * 另一组 f3@d5和a8
     * <p>
     * 说明
     * 分割不成功
     * <p>
     * 示例三
     * 输入
     * AXdddF
     * 输出
     * 2
     * 说明
     * 成功分割且分割结果唯一
     * 可以分割为AX(153)、dddF(370)两个子串
     */

    private static final LinkedList<Integer> resList = new LinkedList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        int count = 2;
        find(line, count);

        int res = 0;
        if (resList.size() > 1) {
            res = -1;
        } else if (resList.size() == 1) {
            res = resList.get(0);
        }

        System.out.println(res);
    }

    private static void find(String line, int count) {
        for (int i = 1; i < line.length(); i++) {
            String sub1 = line.substring(0, i);
            String sub2 = line.substring(i);
            if (daffodil(asciiSum(sub1))) {
                if (daffodil(asciiSum(sub2))) {
                    resList.add(count);
                } else {
                    find(sub2, count++);
                }
            }
        }
    }

    private static int asciiSum(String str) {
        int sum = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            sum += chars[i];
        }
        return sum;
    }

    private static boolean daffodil(int sum) {
        int i = sum % 10;
        int j = sum / 10 % 10;
        int k = sum / 100;
        return i * i * i + j * j * j + k * k * k == sum;
    }
}
