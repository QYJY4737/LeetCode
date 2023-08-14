package com.yhf.test;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test165 {
    /**
     * 题目0165-N进制减法
     * 题目描述
     * 实现一个基于字符串的N进制减法。
     * 需要对输入的两个字符串按照给定的N进制进行减法操作，输出正负符号和表示结果的字符串
     * <p>
     * 输入描述
     * 三个参数。
     * 第一个参数是整数形式的进制N值，2 <= N <= 35，
     * 第二个参数为被减数字符串；
     * 第三个参数为减数字符串。
     * 有效的字符包括0~9以及小写字母a~z，字符串有效字符个数最大为100个字符，另外还有结尾的\0。
     * <p>
     * 限制：
     * 输入的被减数和整数，除了单独的 0 以外，不能是以 0 开头的字符串。
     * 如果输入有异常或者计算过程中有异常此时应当输出 -1 表示错误。
     * 输出描述
     * 输出：2个。
     * 其一为减法计算的结果，-1表示出错，0表示结果为整数，1表示结果为负数。
     * 其二为表示结果的字符串。
     * <p>
     * 示例一
     * 输入
     * 2 11 1
     * 输出
     * 0 10
     * 说明
     * 按二进制计算 11 - 1，计算正常，0表示符号为正数，结果为10
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        String[] split = line.split(" ");
        if (check(split[1])) return;
        if (check(split[2])) return;
        try {
            int radix = Integer.parseInt(split[0]);
            BigInteger minuend = new BigInteger(split[1], radix);
            BigInteger subtrahend = new BigInteger(split[2], radix);
            BigInteger diff = minuend.subtract(subtrahend);
            int sign = diff.compareTo(BigInteger.ZERO) >= 0 ? 0 : 1;
            String value = diff.abs().toString(radix);
            System.out.printf("%d %s", sign, value);
        } catch (Exception e) {
            System.out.println(-1);
        }

    }

    private static boolean check(String str) {
        if (str.length() > 1 && str.startsWith("0")) {
            System.out.println(-1);
            return true;
        }
        return false;
    }
}
