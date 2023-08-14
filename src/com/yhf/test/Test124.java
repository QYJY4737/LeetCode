package com.yhf.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test124 {
    /**
     * 题目0124-最长合法表达式
     * 题目描述
     * 提取字符串中的最长合法简单数学表达式，
     * 字符串长度最长的，并计算表达式的值。
     * 如果没有返回0.
     * 简单数学表达式只能包含以下内容：
     * 0-9数字，符号+-*
     * 说明：
     *
     * 所有数字，计算结果都不超过long
     * 如果有多个长度一样的，请返回第一个表达式的结果
     * 数学表达式，必须是最长的，合法的
     * 操作符不能连续出现，如+--+1是不合法的
     * 输入描述
     * 字符串
     *
     * 输出描述
     * 表达式值
     *
     * 示例一
     * 输入
     * 1-2abcd
     * 输出
     * -1
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static final String v = "0123456789+-*";

    private static void solution(String line) {
        char[] chars = line.toCharArray();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (Character.isDigit(cur)) {
                int start = i;
                while (i + 1 < chars.length &&
                        v.contains(chars[i + 1] + "")) {
                    if (!Character.isDigit(cur) &&
                            !Character.isDigit(chars[i + 1])) {
                        break;
                    }
                    i++;
                }
                list.add(line.substring(start, i + 1));
            }
        }

        list.sort((s1, s2) -> Integer.compare(s2.length(), s1.length()));

        if (list.size() > 0) {
            String res = calc(list.get(0));
            System.out.println(res);
        }else{
            System.out.println(0);
        }

    }

    private static String calc(String str) {
        char[] chars = str.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (Character.isDigit(aChar)) {
                sb.append(aChar);
            } else {
                sb.append(",").append(aChar).append(",");
            }
        }

        List<String> list = Stream.of(sb.toString().split(",")).collect(Collectors.toList());
        return splitStepCalculate(list).get(0);
    }


    public static List<String> splitStepCalculate(List<String> cls) {
        if (cls.size() == 1) {
            return cls;
        }
        //计算乘除法
        for (int i = 0; i < cls.size(); i++) {
            if (cls.get(i).equals("*")) {
                calculate(cls, i, "*");
                i = 0;
            }

            if (i < cls.size() && cls.get(i).equals("/")) {
                calculate(cls, i, "/");
                i = 0;
            }
        }
        //计算加减法
        for (int i = 0; i < cls.size(); i++) {
            if (cls.get(i).equals("+")) {
                calculate(cls, i, "+");
                i = 0;
            }

            if (i < cls.size() && cls.get(i).equals("-")) {
                calculate(cls, i, "-");
                i = 0;
            }
        }
        return cls;
    }

    private static void calculate(List<String> cls, int i, String symbol) {
        int s = Integer.parseInt(cls.get(i - 1));
        int e = Integer.parseInt(cls.get(i + 1));
        int t = 0;
        switch (symbol) {
            case "*":
                t = s * e;
                break;
            case "/":
                t = s / e;
                break;
            case "+":
                t = s + e;
                break;
            case "-":
                t = s - e;
                break;
        }
        cls.set(i, t + "");
        cls.remove(i - 1);
        cls.remove(i);
    }
}
