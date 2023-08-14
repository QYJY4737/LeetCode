package com.yhf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test160 {
    /**
     * 题目0160-箱子之形摆放
     * 题目描述
     * 有一批箱子（形式为字符串，设为str），
     * 要求将这批箱子按从上到下以之字形的顺序摆放在宽度为 n 的空地，请输出箱子的摆放位置。
     * 例如：箱子ABCDEFG，空地宽度为3，摆放结果如图：
     * <p>
     * A
     * B
     * C
     * F
     * E
     * D
     * G
     * <p>
     * 则输出结果为：
     * AFG
     * BE
     * CD
     * <p>
     * 输入描述
     * 输入一行字符串，通过空格分隔，前面部分为字母或数字组成的字符串str，表示箱子；
     * 后面部分为数字n，表示空地的宽度。例如：ABCDEFG 3
     * <p>
     * 输出描述
     * 箱子摆放结果，如题目示例所示
     * AFG
     * BE
     * CD
     * <p>
     * 示例一
     * 输入
     * ABCDEFG 3
     * 输出
     * AFG
     * BE
     * CD
     * 说明
     * 备注
     * 请不要再最后一行输出额外的空行
     * str只包含字母和数字，1 <= len(str) <= 1000
     * 1 <= n <= 1000
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {

        String[] split = line.split(" ");
        String str = split[0];
        int n = Integer.parseInt(split[1]);

        char[] chars = str.toCharArray();
        List<List<Character>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }
        int index = 0;
        boolean asc = true;

        for (char c : chars) {
            if (index == -1) {
                index = 0;
                asc = true;
            }
            if (index == n) {
                index = n - 1;
                asc = false;
            }
            lists.get(index).add(c);

            if (asc) {
                index++;
            } else {
                index--;
            }
        }


        for (List<Character> list : lists) {
            for (Character c : list) {
                System.out.print(c);
            }
            System.out.println();
        }

    }
}
