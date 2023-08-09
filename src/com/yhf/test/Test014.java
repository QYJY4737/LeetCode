package com.yhf.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created on 2023/8/9.
 *
 * @author qyjy4737
 */
public class Test014 {
    /**
     * 题目0014-单词接龙
     * 题目描述
     * 单词接龙的规则是:
     * 可用于接龙的单词,首字母必须要与前一个单词的尾字母相同；
     * 当存在多个首字母相同的单词时，取长度最长的单词；
     * 如果长度也相等，则取字典序最小的单词；
     * 已经参与接龙的单词不能重复使用；
     * 现给定一组全部由小写字母组成的单词数组，
     * 并指定其中一个单词为起始单词，进行单词接龙，
     * 请输出最长的单词串。
     * 单词串是单词拼接而成的，中间没有空格。
     *
     * 单词个数 1 < N < 20
     * 单个单词的长度 1 ~ 30
     *
     * 输入描述
     * 输入第一行为一个非负整数
     * 表示起始单词在数组中的索引k
     * 0 <= k < N
     * 输入的第二行为非负整数N
     * 接下来的N行分别表示单词数组中的单词
     *
     * 输出描述
     * 输出一个字符串表示最终拼接的单词串
     *
     * 示例一
     * 输入
     * 0
     * 6
     * word
     * dd
     * da
     * dc
     * dword
     * d
     * 输出
     * worddwordda
     * 示例一
     * 输入
     * 4
     * 6
     * word
     * dd
     * da
     * dc
     * dword
     * d
     * 输出
     * dwordda
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int k = Integer.parseInt(scanner.nextLine());
            int N = Integer.parseInt(scanner.nextLine());
            ArrayList<String> words = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                words.add(scanner.nextLine());
            }
            solution(k, words);
        }

    }

    private static void solution(int k, ArrayList<String> words) {
        StringBuilder builder = new StringBuilder();
        builder.append(words.get(k));
        words.remove(k);

        words.sort((w1, w2) -> {
            int len1 = w1.length();
            int len2 = w2.length();
            if (len1 != len2) {
                return len2 - len1;
            } else {
                return w1.compareTo(w2);
            }
        });

        int len;
        do {
            len = builder.length();
            String last = builder.substring(builder.length() - 1);
            for (int i = 0; i < words.size(); i++) {
                String cur = words.get(i);
                if (cur.startsWith(last)) {
                    builder.append(cur);
                    words.remove(cur);
                    break;
                }
            }
        } while (builder.length() != len);


        System.out.println(builder);
    }
}
