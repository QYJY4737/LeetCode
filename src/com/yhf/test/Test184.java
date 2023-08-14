package com.yhf.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test184 {
    /**
     * 题目0184-完美走位
     * 题目描述
     * 在第一人称射击游戏中，玩家通过键盘的A、S、D、W四个按键控制游戏人物分别向左、向后、向右、向前进行移动，从而完成走位。
     * 假设玩家每按动一次键盘，游戏人物会向某个方向移动一步，如果玩家在操作一定次数的键盘并且各个方向的步数相同时，此时游戏人物必定会回到原点，则称此次走位为完美走位。
     * 现给定玩家的走位（例如：ASDA）,请通过更换其中一段连续走位的方式使得原走位能够变成一个完美走位。
     * 其中待更换的连续走位可以是相同长度的任何走位。
     * 请返回待更换的连续走位的最小可能长度。
     * 若果原走位本身是一个完美走位，则返回0。
     * <p>
     * 输入描述
     * 输入为由键盘字母表示的走位s，例如：ASDA
     * <p>
     * 输出描述
     * 输出为待更换的连续走位的最小可能长度
     * <p>
     * 备注
     * 走位长度 1≤s.length≤1051 \leq s.length \leq 10^51≤s.length≤10
     * 5
     * <p>
     * s.length 是 4 的倍数
     * s 中只含有 A, S, D, W 四种字符
     * 示例一
     * 输入
     * ASDW
     * 输出
     * 0
     * 说明
     * 已经是完美走位了。
     * <p>
     * 示例二
     * 输入
     * AASW
     * 输出
     * 1
     * 说明
     * 需要把一个A更换成D，这样可以得到ADSW或者DASW。
     * <p>
     * 示例三
     * 输入
     * AAAA
     * 输出
     * 3
     * 说明
     * 可以替换后 3 个 A，得到ASDW。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String ops = scanner.nextLine();
            solution(ops);
        }

    }

    private static void solution(String ops) {

        char[] chars = ops.toCharArray();
        int len = chars.length;
        int count = len / 4;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        map.replaceAll((k, v) -> v - count);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            char c1 = chars[i];
            int res = 0;
            Map<Character, Integer> changed = new HashMap<>(map);
            if (changed.get(c1) > 0) {
                for (int j = i; j < len; j++) {
                    char c2 = ops.charAt(j);
                    changed.put(c2, changed.get(c2) - 1);
                    res++;
                    if (check(changed)) {
                        break;
                    }
                }
            }

            if (check(changed)) {
                min = Math.min(min, res);
            }
        }

        System.out.println(min);
    }

    public static boolean check(Map<Character, Integer> map) {
        for (Integer i : map.values()) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}
