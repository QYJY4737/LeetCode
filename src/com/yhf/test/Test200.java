package com.yhf.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test200 {
    /**
     * 题目0200-求最大数字
     * 题目描述
     * 给定一个由纯数字组成以字符串表示的数值，现要求字符串中的每个数字最多只能出现2次，超过的需要进行删除；删除某个重复的数字后，其它数字相对位置保持不变。
     * 如34533，数字3重复超过2次，需要删除其中一个3，删除第一个3后获得最大数值4533
     * 请返回经过删除操作后的最大的数值，以字符串表示。
     * <p>
     * 输入描述
     * 第一行为一个纯数字组成的字符串，长度范围：[1,100000]
     * <p>
     * 输出描述
     * 输出经过删除操作后的最大的数值
     * <p>
     * 示例一
     * 输入
     * 34533
     * 输出
     * 4533
     * 示例二
     * 输入
     * 5445795045
     * 输出
     * 5479504
     * 思路
     * 统计所有字符出现的次数
     * 次数大于2的数字，从前往后找到当前数字的后一个数字大于当前数字的位置，将其删除
     * 如果到最后一个，还有剩余，则删除最后一个数字
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String number = scanner.nextLine();
            String res = solution(number);
            System.out.println(res);
        }
    }

    private static String solution(String number) {
        HashMap<Character, Integer> cCount = new HashMap<>();
        LinkedList<Character> resLink = new LinkedList<>();
        for (char c : number.toCharArray()) {
            cCount.put(c, cCount.getOrDefault(c, 0) + 1);
            resLink.add(c);
        }

        for (Map.Entry<Character, Integer> entry : cCount.entrySet()) {
            Character c = entry.getKey();
            Integer count = entry.getValue();
            for (int i = 0; i < resLink.size() && count > 2; i++) {
                if (resLink.get(i) == c) {
                    if (i == resLink.size() - 1) {
                        resLink.removeLast();
                        count--;
                    } else if (resLink.get(i + 1) > c) {
                        resLink.remove(i);
                        i--;
                        count--;
                    }
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (Character c : resLink) {
            builder.append(c);
        }
        return builder.toString();
    }
}
