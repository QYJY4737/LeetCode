package com.yhf.test;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test157 {
    /**
     * 题目0157-寻找关键钥匙
     * 题目描述
     * 小强增在参加《密室逃生》游戏，当前关卡要求找到符合给定 密码K（升序的不重复小写字母组成） 的箱子，
     * 并给出箱子编号，箱子编号为 1~N 。
     * 每个箱子中都有一个 字符串s ，字符串由大写字母、小写字母、数字、标点符号、空格组成，
     * 需要在这些字符串中找到所有的字母，忽略大小写后排列出对应的密码串儿，并返回匹配密码的箱子序号。
     *
     * 提示：
     * 满足条件的箱子不超过1个
     *
     * 输入描述
     * 第一行为 key 的字符串，
     * 第二行为箱子 boxes，为数组样式，以逗号分隔
     * 箱子 NNN 数量满足 1≤N≤100001 \leq N \leq 100001≤N≤10000 ,
     * sss 长度满足 0≤s.length≤500 \leq s.length \leq 500≤s.length≤50 ，
     * 密码为仅包含小写字母的升序字符串，且不存在重复字母，
     * 密码 KKK 长度 K.lengthK.lengthK.length ， 1≤K.length≤261 \leq K.length \leq 261≤K.length≤26
     *
     * 输出描述
     * 返回对应箱子编号
     * 如不存在符合要求的密码箱，则返回 -1
     *
     * 示例一
     * 输入
     * abc
     * s, sdf134 A2c4b
     * 输出
     * 2
     * 说明
     * 第 2 个箱子中的 Abc ，符合密码 abc
     *
     * 示例二
     * 输入
     * abc
     * s,sdf134 A2c4bd 523[]
     * 输出
     * -1
     * 说明
     * 第 2 个箱子中的 Abcd，与密码不完全匹配，不符合要求
     *
     * 备注
     * 箱子中字符拼出的字符串与密码的匹配忽略大小写，且要求与密码完全匹配，如密码 abc 匹配 aBc ，但是密码 abc 不匹配 abcd
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String key = scanner.nextLine();
            String boxes = scanner.nextLine();
            int res = solution(key, boxes);
            System.out.println(res);
        }
    }

    private static int solution(String key, String boxes) {
        String[] split = boxes.substring(2).split(" ");
        for (int i = 0; i < split.length; i++) {
            String lower = split[i].toLowerCase();
            TreeSet<Character> chars = new TreeSet<>();
            for (char c : lower.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    chars.add(c);
                }
            }
            if (chars.size() == key.length()) {
                StringBuilder builder = new StringBuilder();
                for (Character c : chars) {
                    builder.append(c);
                }
                if (builder.toString().equals(key)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
