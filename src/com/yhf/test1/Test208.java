package com.yhf.test1;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test208 {
    /**
     * 题目0208-最多提取子串数目
     * 题目描述
     * 给定由 [a-z] 26个英文小写字母组成的字符串A和B，
     * 其中A中可能存在重复字母，B中不会存在重复字母
     * 现从字符串A中按规则挑选一些字母，可以组成字符串B。
     *
     * 挑选规则如下：
     * 同一个位置的字母只能被挑选一次。
     * 被挑选字母的相对先后顺序不能改变。
     * 求最多可以同时从A中挑选多少组能组成B的字符串。
     *
     * 输入描述
     * 输入为2行，第1行输入字符串A，第2行输入字符串B，行首行尾无多余空格，
     * 其中A、B均由[a-z] 26个英文小写字母组成；
     * 0 < A.length < 100，A中可能包含重复字母；
     * 0 < B.length < 10，B中不会出现重复字母。
     *
     * 输出描述
     * 输出1行，包含1个数字，表示最多可以同时从A中挑选多少组能组成B的字符串，
     * 行末无多余空格。
     *
     * 备注
     * 无需验证输入格式和输入数据合法性。
     *
     * 示例一
     * 输入
     * badc
     * bac
     * 输出
     * 1
     * 说明
     * 从字符串A("badc")中可以按字母相对先后顺序取出字符串B("bac")
     *
     * 示例二
     * 输入
     * badc
     * abc
     * 输出
     * 0
     * 说明
     * 从字符串A("badc")中无法按字母相对先后顺序取出字符串B("abc")
     *
     * 示例三
     * 输入
     * aabbcxd
     * abcd
     * 输出
     * 1
     * 说明
     * 从字符串A("aabbcxd")中挑选一组B("abcd")后，A中剩余字符串为abx，无法再挑出abcd
     *
     * 示例四
     * 输入
     * ababcecfdc
     * abc
     * 输出
     * 2
     * 说明
     * 按如下步骤（步骤不唯一），可以同时从字符串A("ababcecfdc")中最多取出两个B("abc")，其中下划线标注的是每步提取的字母：
     *
     * ababcecfdc -> abecfdc
     * 剩余的`efdc`无法继续提取`abc`，结果为`2`
     * 示例五
     * 输入
     * aaa
     * a
     * 输出
     * 3
     * 说明
     * 从字符串A("aaa")中可以挑选3个字符串B("a")
     *
     * 思路
     * 从字符串A中依次查找B中的字符，如果找到，则记录找到的字符索引，并继续查找下一个字符，每次从上一次找到的字符之后继续查找。
     * 如果全部找到，则将原A字符串中被使用过的所有字符位置替换为其他字符，这里我使用了-，并计数。
     * 重复上面的过程，如果出现找不到目标字符则结束查找。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            int res = solution(a, b);
            System.out.println(res);
        }
    }

    private static int solution(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int[] indexes = new int[b.length()];
        int count = 0;
        boolean found = true;
        while (found) {
            for (int i = 0; i < charsB.length; i++) {
                int pos = a.indexOf(charsB[i], i == 0 ? 0 : indexes[i - 1]);
                if (pos != -1) {
                    indexes[i] = pos;
                } else {
                    found = false;
                    break;
                }
            }
            if (found) {
                for (int index : indexes) {
                    charsA[index] = '-';
                    a = new String(charsA);
                }
                count++;
            }
        }

        return count;
    }
}
