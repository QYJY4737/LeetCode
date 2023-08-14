package com.yhf.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test202 {
    /**
     * 题目0202-去除多余空格
     * 题目描述
     * 去除文本多余空格，但不去除配对单引号之间的多余空格。给出关键词的起始和结束下标，去除多余空格后刷新关键词的起始和结束下标。
     * 条件约束：
     * main0202.jpeg
     * <p>
     * 不考虑关键词起始和结束位置为空格的场景；
     * 单词的的开始和结束下标保证涵盖一个完整的单词，即一个坐标对开始和结束下标之间不会有多余的空格；
     * 如果有单引号，则用例保证单引号成对出现；
     * 关键词可能会重复；
     * 文本字符长度length取值范围：[0, 100000];
     * 输入描述
     * 输入为两行字符串：
     * 第一行：待去除多余空格的文本，用例保证如果有单引号，则单引号成对出现，且单引号可能有多对。
     * 第二行：关键词的开始和结束坐标，关键词间以逗号区分，关键词内的开始和结束位置以单空格区分。
     * 例如：
     * <p>
     * Life is painting a  picture, not doing 'a  sum'.
     * 8 15,20 26,43 45
     * 关键单词为：painting picture sum
     * <p>
     * 输出描述
     * 输出为两行字符串：
     * 第一行：去除多余空格后的文本
     * 第二行：去除多余空格后的关键词的坐标开始和结束位置，为数组方式输出。
     * <p>
     * 例如：
     * <p>
     * Life is painting a picture, not doing 'a  sum'.
     * [8, 15][19, 25][42, 44]
     * 示例一
     * 输入
     * Life is painting a  picture, not doing 'a  sum'.
     * 8 15,20 26,43 45
     * 输出
     * Life is painting a picture, not doing 'a  sum'.
     * [8, 15][19, 25][42, 44]
     * 说明
     * a和picture中间多余的空格进行删除
     * <p>
     * 示例二
     * 输入
     * Life is painting a picture, not doing 'a  sum'.
     * 8 15,19 25,42 44
     * 输出
     * Life is painting a picture, not doing 'a  sum'.
     * [8, 15][19, 25][42, 44]
     * 说明
     * a和sum之间有多余的空格，但是因为有成对单引号，不去除多余空格
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            String pos = scanner.nextLine();
            solution(line, pos);
        }
    }

    private static void solution(String line, String pos) {
        String[] split = pos.split(",");
        String[] keys = new String[split.length];
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String[] indexes = s.split(" ");
            int l = Integer.parseInt(indexes[0]);
            int r = Integer.parseInt(indexes[1]);
            keys[i] = line.substring(l, r + 1);
        }
        StringBuilder builder = new StringBuilder();
        char[] chars = line.toCharArray();
        boolean inner = false;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '\'') {
                inner = !inner;
            }
            if (inner) {
                builder.append(c);
                continue;
            }
            if (c == ' ' && chars[i - 1] == ' ') {
                continue;
            }
            builder.append(c);
        }
        System.out.println(builder);

        for (String key : keys) {
            int l = builder.indexOf(key);
            int r = l + key.length() - 1;
            System.out.print(Arrays.toString(new int[]{l, r}));
        }

    }
}
