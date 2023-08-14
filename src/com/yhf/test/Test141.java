package com.yhf.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test141 {
    /**
     * 题目0141-字符匹配
     * 题目描述
     * 给你一个字符串数组
     * 每个字符串均由小写字母组成
     * 和一个字符规律 由小写字母和.和*组成
     * 识别字符串数组中哪些字符串可以匹配到字符规律上
     * . 匹配任意单个字符
     * * 匹配0个或多个任意字符
     * 判断字符串是否匹配，是要涵盖整个字符串的而不是部分字符串
     *
     * 输入描述
     * 第一行为空格分割的多个字符串
     * 1 < 单个字符串长度 < 100
     * 1 < 字符串个数 < 100
     * 第二行为字符规律
     * 1 <= 字符规律长度 <= 50
     * 不需要考虑异常场景
     *
     * 输出描述
     * 匹配的字符串在数组中的下标 (从0开始)
     * 多个匹配时，下标升序，并用逗号分割
     * 若均不匹配 输出-1
     *
     * 示例一
     * 输入
     * ab aab abacd
     * .*
     * 输出
     * 0,1,2
     * 示例二
     * 输入
     * ab aab
     * a.b
     * 输出
     * 1
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String array = scanner.nextLine();
            String pattern = scanner.nextLine();
            solution(array, pattern);
        }
    }

    private static void solution(String array, String pattern) {

        String[] strings = array.split(" ");
        List<Integer> resList = new LinkedList<>();
        for (int n = 0; n < strings.length; n++) {
            String string = strings[n];
            LinkedList<Character> characters = new LinkedList<>();
            for (char c : string.toCharArray()) {
                characters.add(c);
            }
            char[] patterns = pattern.toCharArray();
            int i = 0;
            boolean flag = true;
            while (flag && i < patterns.length) {
                if (characters.size() == 0) {
                    break;
                }
                char p = patterns[i];
                switch (p) {
                    case '.':
                        characters.removeFirst();
                        break;
                    case '*':
                        characters = new LinkedList<>();
                        break;
                    default:
                        if (characters.get(0).equals(p)) {
                            characters.removeFirst();
                        } else {
                            flag = false;
                        }
                        break;
                }
                i++;
            }

            if (characters.size() == 0 && i == patterns.length) {
                resList.add(n);
            }


        }

        if (resList.size() == 0) {
            System.out.print(-1);
        } else {
            for (int i = 0; i < resList.size(); i++) {
                System.out.print(resList.get(i));
                if (i != resList.size() - 1) {
                    System.out.print(",");
                }
            }
        }

    }
}
