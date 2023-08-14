package com.yhf.test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test166 {
    /**
     * 题目0166-寻找密码
     * 题目描述
     * 小王在进行游戏大闯关，有一个关卡需要输入一个密码才能通过，密码获得的条件如下：
     * 在一个密码本中，每一页都有一个由26个小写字母组成的若干位密码，
     * 从它的末尾开始依次去掉一位得到的新密码也在密码本中存在。
     * 请输出符合要求的密码，如果由多个符合要求的密码，则返回字典序最大的密码。
     * 若没有符合要求的密码，则返回空字符串。
     * <p>
     * 输入描述
     * 密码本由一个字符串数组组成，不同元素之间使用空格隔开，每一个元素代表密码本每一页的密码。
     * <p>
     * 输出描述
     * 一个字符串
     * <p>
     * 示例一
     * 输入
     * h he hel hell hello
     * 输出
     * hello
     * 说明
     * "hello" 从末尾依次去掉一位得到的 "hell", "hel", "he", "h"在密码本中都存在。
     * <p>
     * 示例二
     * 输入
     * b eredderd bw bww bwwl bwwlm bwwln
     * 输出
     * bwwln
     * 说明
     * "boolm" 和 "bwwln" 从末尾开始依次去掉一位得到密码在密码本中都存在，但是 “bwwln” 比 “bwwlm” 字典序排序大，所以应该返回 “bwwln”。
     * <p>
     * 备注
     * 1≤密码本的页数≤1051 \leq 密码本的页数 \leq 10^51≤密码本的页数≤10
     * 5
     * <p>
     * 1≤每页密码的长度≤1051 \leq 每页密码的长度 \leq 10^51≤每页密码的长度≤10
     * 5
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            String result = solution(line);
            System.out.println(result);
        }
    }

    private static String solution(String line) {
        String[] split = line.split(" ");
        Arrays.sort(split);
        TreeSet<String> set = new TreeSet<>(Arrays.asList(split));

        for (int i = split.length - 1; i >= 0; i--) {
            String pw = split[i];
            String tmp = pw.substring(0, pw.length() - 1);
            boolean flag = true;
            while (tmp.length() > 0) {
                if (flag = set.contains(tmp)) {
                    tmp = tmp.substring(0, tmp.length() - 1);
                } else {
                    break;
                }
            }
            if (flag) {
                return pw;
            }
        }
        return "";
    }
}
