package com.yhf.test1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test247 {
    /**
     * 题目0247-恢复数字序列
     * 题目描述
     * 对于一个连续正整数组成的序列，可以将其拼接成一个字符串，再将字符串里的部分字符打乱顺序。如序列8 9 10 11 12，拼接成的字符串为89101112，打乱一部分字符后得到90811211。注意打乱后原来的正整数可能被拆开，比如在90811211中，原来的正整数10就被拆成了0和1。
     * 现给定一个按如上规则得到的打乱了字符的字符串，请将其还原成连续正整数序列，并输出序列中最小的数字。
     * <p>
     * 输入描述
     * 输入一行，为打乱字符的字符串和正整数序列的长度，两者间用空格分隔，字符串长度不超过200，正整数不超过1000，保证输入可以还原成唯一序列.
     * <p>
     * 输出描述
     * 输出一个数字，为序列中最小的数字
     * <p>
     * 示例一
     * 输入
     * 19801211 5
     * 输出
     * 8
     * 说明
     * 还原出的序列为8 9 10 11 12，故输出8
     * <p>
     * 示例二
     * 输入
     * 432111111111 4
     * 输出
     * 111
     * 说明
     * 还原出的序列为111 112 113 114，故输出111
     * <p>
     * 思路解析和复杂度分析
     * 首先，对题目进行解析，我们知道原始序列一定是一个连续的正整数序列，也就是说，序列中的元素是等差递增的，差为1。另外，由于原始序列是由数字组合而成的字符串，所以原始序列和打乱后的字符串的ASCII码之和是一致的。
     * <p>
     * 于是，我们可以使用以下的步骤来解决这个问题：
     * <p>
     * 对输入的打乱的字符串按字符进行排序，这样可以得到一个从小到大排列的字符序列。
     * 计算输入字符串的ASCII码之和。
     * 计算最小可能的数字的长度，这个长度可以通过整个字符串的长度除以序列的长度得到。
     * 枚举最小的数字，由于数字是由字符组合而成，字符的范围是0到9，所以我们只需要枚举10种可能。对于每一种可能，我们生成一个由这个最小的数字开始的等差为1的序列，然后比较这个序列的ASCII码之和与输入字符串的ASCII码之和是否一致。如果一致，说明我们找到了原始的序列。
     * 最后，输出找到的最小的数字。
     * 在复杂度分析方面，我们需要对输入的字符串进行排序，这个操作的时间复杂度是O(n log n)，其中n是字符串的长度。接下来，我们需要枚举最小的数字，由于数字的范围是有限的，所以这个操作的时间复杂度是O(1)。然后，对于每一种可能的数字，我们需要生成一个序列，并计算这个序列的ASCII码之和，这个操作的时间复杂度是O(m)，其中m是序列的长度。所以，总的时间复杂度是O(n log n + m)，空间复杂度是O(n)。
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = sc.nextInt();

        int minStartNum = findMinStartNum(s, len);
        System.out.println(minStartNum);
    }

    private static int findMinStartNum(String s, int len) {
        int n = s.length();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String sortedStr = new String(arr);
        int totalSum = totalAsciiSum(s);

        int minNumLen = n / len;
        int minNum = -1;

        for (int i = 0; i <= 9; i++) {
            String candidate = i + sortedStr.substring(0, minNumLen - 1);
            int num = Integer.parseInt(candidate);
            if (totalAsciiSum(generateSequence(num, len)) == totalSum) {
                minNum = num;
                break;
            }
        }

        return minNum;
    }

    private static String generateSequence(int startNum, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(startNum + i);
        }
        return sb.toString();
    }

    private static int totalAsciiSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c - '0';
        }
        return sum;
    }
}
