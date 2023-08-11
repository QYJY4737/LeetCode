package com.yhf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test092 {
    /**
     * 题目0092-重组字符串
     * 题目描述
     * 给定一个非空字符串S，其被N个‘-’分隔成N+1的子串，给定正整数K，
     * 要求除第一个子串外，其余的子串每K个字符组成新的子串，并用‘-’分隔。
     * 对于新组成的每一个子串，如果它含有的小写字母比大写字母多，则将这个子串的所有大写字母转换为小写字母；
     * 反之，如果它含有的大写字母比小写字母多，则将这个子串的所有小写字母转换为大写字母；
     * 大小写字母的数量相等时，不做转换。
     * <p>
     * 输入描述
     * 输入为两行，第一行为参数K，第二行为字符串S。
     * <p>
     * 输出描述
     * 输出转换后的字符串。
     * <p>
     * 示例一
     * 输入
     * 3
     * 12abc-abCABc-4aB@
     * 输出
     * 12abc-abc-ABC-4aB-@
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = Integer.parseInt(scanner.nextLine());
            String line = scanner.nextLine();
            solution(count, line);
        }
    }

    private static void solution(int count, String line) {
        String[] split = line.split("-");

        List<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < split.length; i++) {
            builder.append(split[i]);
        }
        String item = builder.toString();
        while (item.length() > 0) {
            if (item.length() >= count) {//截取
                list.add(item.substring(0, count));
                item = item.substring(count);
            } else {
                list.add(item);
                item = "";
            }
        }

        System.out.print(split[0] + "-");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(convert(list.get(i)));
            if (i != list.size() - 1) {
                System.out.print('-');
            }
        }

    }

    private static String convert(String str) {
        int lower = 0;
        int upper = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                lower++;
            } else if (ch >= 'A' && ch <= 'Z') {
                upper++;
            }
        }
        if (lower > upper) {
            return str.toLowerCase();
        } else if (upper > lower) {
            return str.toUpperCase();
        } else {
            return str;
        }
    }
}
