package com.yhf.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test115 {
    /**
     * 题目0115-压缩报文还原
     * 题目描述
     * 为了提升数据传输的效率，会对传输的报文进行压缩处理。
     * 输入一个压缩后的报文，请返回它解压后的原始报文。
     * 压缩规则：n[str]，表示方括号内部的 str 正好重复 n 次。
     * 注意 n 为正整数（0 < n <= 100），str只包含小写英文字母，不考虑异常情况。
     * 注：
     * 1）原始报文长度不会超过1000，不考虑异常的情况
     *
     * 输入描述
     * 输入描述:
     * 输入压缩后的报文：
     * 1）不考虑无效的输入，报文没有额外的空格，方括号总是符合格式要求的；
     * 2）原始报文不包含数字，所有的数字只表示重复的次数 n ，例如不会出现像5b或3[8]的输入；
     *
     * 输出描述
     * 输出描述:
     * 解压后的原始报文
     *
     * 示例一
     * 输入
     * 3[k]2[mn]
     * 输出
     * kkkmnmn
     * 示例二
     * 输入
     * 3[m2[c]]
     * 输出
     * mccmccmcc
     */
    public static final Pattern PATTERN = Pattern.compile("[0-9]+\\[[a-z]+]");

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            String res = solution(line);
            System.out.print(res);
        }
    }

    private static String solution(String line) {
        Matcher matcher = PATTERN.matcher(line);
        if (matcher.find()) {
            String group = matcher.group();
            int pos = group.indexOf('[');
            int times = Integer.parseInt(group.substring(0, pos));
            String words = group.substring(pos + 1, group.length() - 1);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < times; i++) {
                builder.append(words);
            }
            String fixed = line.replace(group, builder.toString());
            return solution(fixed);
        } else {
            return line;
        }
    }
}
