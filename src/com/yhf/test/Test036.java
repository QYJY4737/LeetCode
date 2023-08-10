package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/10.
 *
 * @author qyjy4737
 */
public class Test036 {
    /**
     * 题目0036-拼接URL
     * 题目描述
     * 给定一个url前缀和url后缀
     * 通过,分割 需要将其连接为一个完整的url
     * 如果前缀结尾和后缀开头都没有/
     * 需要自动补上/连接符
     * 如果前缀结尾和后缀开头都为/
     * 需要自动去重
     * 约束：
     * 不用考虑前后缀URL不合法情况
     * <p>
     * 输入描述
     * url前缀(一个长度小于100的字符串)
     * url后缀(一个长度小于100的字符串)
     * <p>
     * 输出描述
     * 拼接后的url
     * <p>
     * 示例一
     * 输入
     * /acm,/bb
     * 输出
     * /acm/bb
     * 示例二
     * 输入
     * /abc/,/bcd
     * 输出
     * /abc/bcd
     * 示例三
     * 输入
     * /acd,bef
     * 输出
     * /acd/bef
     * 示例四
     * 输入
     * ,
     * 输出
     * /
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        String[] split = line.split(",");
        if (split.length == 0) {
            System.out.println("/");
            return;
        }
        String combine = split[0] + "/" + split[1];
        String url = combine.replaceAll("/+", "/");
        System.out.println(url);
    }
}
