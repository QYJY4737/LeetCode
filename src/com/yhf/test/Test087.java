package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test087 {
    /**
     * 题目0087-关联子串
     * 题目描述
     * 给定两个字符串str1和str2
     * 如果字符串str1中的字符，经过排列组合后的字符串中
     * 只要有一个是str2的子串
     * 则认为str1是str2的关联子串
     * 若不是关联子串则返回-1
     * 示例一：
     * 输入：
     * str1="abc",str2="efghicaibii"
     * 输出：
     * -1
     * 预制条件：
     * <p>
     * 输入的字符串只包含小写字母
     * 两个字符串的长度范围1 ~ 100000
     * 若str2中有多个str1的组合子串，请返回第一个子串的起始位置
     * 备注：输入字符串只包含小写，长度 1~100000
     * <p>
     * 输入描述
     * 输入两个字符串，分别为题目中描述的str1和str2
     * <p>
     * 输出描述
     * 如果str1是str2的关联子串，则返回子串在str2中的起始位置
     * 如果不是则返回-1
     * 若str2中有多个str1的组合子串，
     * 请返回最小的起始位置
     * <p>
     * 示例一
     * 输入
     * abc efghicabiii
     * 输出
     * 5
     * 说明
     * str2包含str1的一种排列组合(cab)
     * 其在str2的起始位置为5(从0开始计数)
     * <p>
     * 示例二
     * 输入
     * abc efghicaibii
     * 输出
     * -1
     * 说明
     * abc字符串中三个字母的各种组合
     * (abc,acb,bac,bca,cab,cba),str2中均不包含因此返回-1
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        String[] strs = line.split(" ");
        String str1 = strs[0];
        String str2 = strs[1];
        find("", new StringBuilder(str1), str2);
        System.out.print(index);
    }

    static int index = -1;

    private static void find(String str, StringBuilder builder, String str2) {
        if (builder.length() == 0) {
            int pos = str2.indexOf(str);
            if (pos != -1) {
                if (index == -1) {
                    index = pos;
                } else {
                    index = Math.min(pos, index);
                }
            }
        }
        for (int i = 0; i < builder.length(); i++) {
            StringBuilder tmp = new StringBuilder(builder);
            find(str + tmp.charAt(i), tmp.deleteCharAt(i), str2);
        }
    }
}
