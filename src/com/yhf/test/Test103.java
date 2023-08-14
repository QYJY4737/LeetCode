package com.yhf.test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test103 {
    /**
     * 题目0103-火星文计算2
     * 题目描述
     * 已知火星人使用的运算符号为#;$
     * 其与地球人的等价公式如下
     * x#y=4*x+3*y+2
     * x$y=2*x+y+3
     * x y是无符号整数
     * 地球人公式按照c语言规则进行计算
     * 火星人公式中#符优先级高于$
     * 相同的运算符按从左到右的顺序运算
     * <p>
     * 输入描述
     * 火星人字符串表达式结尾不带回车换行
     * 输入的字符串说明是 字符串为仅有无符号整数和操作符组成的计算表达式
     * <p>
     * 用例保证字符串中操作数与操作符之间没有任何分隔符
     * 用例保证操作数取值范围为32位无符号整数，
     * 保证输入以及计算结果不会出现整型溢出
     * 保证输入的字符串为合法的求值报文
     * 例如: 123#4$5#76$78
     * 保证不会出现非法的求值报文
     * 例如: #4$5 这种缺少操作数
     * 4$5# 这种缺少操作数
     * 4#$5 这种缺少操作数
     * 4 $5 有空格
     * 3+4-5*6/7 有其他操作符
     * 12345678987654321$54321 32位整数溢出
     * 输出描述
     * 根据火星人字符串输出计算结果
     * 结尾不带回车换行
     * <p>
     * 示例一
     * 输入
     * 7#6$5#12
     * 输出
     * 157
     * 说明
     * 7#6$5#12=(4*7+3*6+2)$5#12
     * =48$5#12
     * =48$(4*5+3*12+2)
     * =48$58
     * =2*48+58+3
     * =157
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            solution(input);
        }
    }

    private static void solution(String input) {
        List<String> operators = Arrays.stream(input.split("\\w+"))
                .filter(x -> !x.isEmpty())
                .collect(Collectors.toList());

        List<Integer> nums = Arrays.stream(input.split("\\W+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int posS = operators.indexOf("#");
        while (posS != -1) {
            int tmp = sharp(nums.get(posS), nums.get(posS + 1));
            nums.set(posS, tmp);
            nums.remove(posS + 1);
            operators.remove(posS);
            posS = operators.indexOf("#");
        }

        int res = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            res = dollar(res, nums.get(i));
        }


        System.out.println(res);
    }

    public static int sharp(int x, int y) {
        return 4 * x + 3 * y + 2;
    }

    public static int dollar(int x, int y) {
        return 2 * x + y + 3;
    }
}
