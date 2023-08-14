package com.yhf.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test105 {
    /**
     * 题目0105-括号检查
     * 题目描述
     * 现有一字符串 仅由'(',')','{','}','[',']'六种括号组成
     * 若字符串满足以下条件之一，则为无效字符串
     * <p>
     * 任意类型的左右括号数量不相等
     * 存在未按正确顺序(先左后右)闭合的括号，
     * 输出括号的最大嵌套深度
     * 若字符串无效则输出0
     * 0 <= 字符串长度 <= 100000
     * 输入描述
     * 一个只包括'(',')','{','}','[',']'的字符串
     * <p>
     * 输出描述
     * 一个整数 ，最大的括号深度
     * <p>
     * 示例一
     * 输入
     * []
     * 输出
     * 1
     * 说明
     * 有效字符串最大嵌套深度为1
     * <p>
     * 示例二
     * 输入
     * ([]{()})
     * 输出
     * 3
     * 说明
     * 有效字符串最大嵌套深度为3
     * <p>
     * 示例三
     * 输入
     * (]
     * 输出
     * 0
     * 说明
     * 无效字符串 有两种括号左右数量不相等
     * <p>
     * 示例四
     * 输入
     * ([)]
     * 输出
     * 0
     * 说明
     * 无效字符串存，在未按正确顺序闭合的字符串
     * <p>
     * 示例五
     * 输入
     * )(
     * 输出
     * 0
     * 说明
     * 无效字符串存，在未按正确顺序闭合的字符串
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {

        char[] chars = line.toCharArray();
        int maxDepth = 0;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (char cur : chars) {
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
                maxDepth = Math.max(maxDepth, stack.size());
                continue;
            }

            if (cur == ')' || cur == ']' || cur == '}') {
                if (stack.size() == 0) {
                    System.out.print(0);
                    return;
                }
                Character left = stack.lastElement();
                Character c = map.get(cur);
                if (left.equals(c)) {
                    stack.pop();
                } else {
                    System.out.print(0);
                    return;
                }
            }

        }

        if (stack.size() == 0) {
            System.out.print(maxDepth);
        } else {
            System.out.print(0);
        }
    }
}
