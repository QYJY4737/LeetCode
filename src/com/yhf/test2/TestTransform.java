package com.yhf.test2;

import java.util.Scanner;

/**
 * Created on 2023/8/22.
 *
 * @author qyjy4737
 */
public class TestTransform {

    /**
     * 递归方法
     *
     * @param num 十进制数
     * @return 二进制数
     */
    public static String testByRecursion(int num) {
        if (num == 0) {
            return "0";
        }
        if (num == 1) {
            return "1";
        }
        int result = num / 2;
        int remainder = num % 2;
        return testByRecursion(result) + remainder;
    }

    /**
     * 循环方法
     *
     * @param num 十进制数
     * @return 二进制数
     */
    public static String testByForLoop(int num) {
        StringBuffer buffer = new StringBuffer();
        for (int i = num; i > 0; i /= 2) {
            buffer.insert(0, (i % 2));
        }
        return buffer.toString();
    }

    /**
     * 位运算
     *
     * @param num 十进制数
     * @return 二进制数
     */
    public static String testByBitwise(int num) {
        int mask = 1 << 31;
        StringBuilder binary = new StringBuilder();

        for (int i = 0; i < 32; i++) {
            if ((num & mask) == 0) {
                binary.append("0");
            } else {
                binary.append("1");
            }
            num <<= 1;
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        // 把十进制数不断除以2，然后把每次得到的余数（0或1）从下往上排列，直到商为0为止。
        System.out.print("输入一个十进制数:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("===递归===" + testByRecursion(num));
        System.out.println("===循环===" + testByForLoop(num));
        System.out.println("===位运算===" + testByBitwise(num));
    }
}
