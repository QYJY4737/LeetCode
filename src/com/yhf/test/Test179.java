package com.yhf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test179 {
    /**
     * 题目0179-猜字谜
     * 页面内容
     * 讨论
     * 最后编辑
     * Amos
     * 12/31/2022
     * 猜字谜
     * 题目描述
     * 小王设计了一个简单的猜字谜游戏，游戏的谜面是一个错误的单词，比如nesw，玩家需要猜出谜底库中正确的单词。
     * 猜中的要求如下：
     * 对于某个谜面和谜底单词，满足下面任一条件都表示猜中：
     * <p>
     * 变换顺序以后一样的，比如通过变换w和e的顺序，nwes跟news是可以完全对应的；
     * 字母去重以后是一样的，比如woood和wood是一样的，它们去重后都是wod
     * 请你写一个程序帮忙在谜底库中找到正确的谜底。
     * 谜面是多个单词，都需要找到对应的谜底，如果找不到的话，返回not found
     * <p>
     * 输入描述
     * 谜面单词列表，以,分隔
     * 谜底库单词列表，以,分隔
     * 输出描述
     * 匹配到的正确单词列表，以,分隔
     * 如果找不到，返回not found
     * <p>
     * 备注
     * 单词的数量N的范围：0<N<10000 < N < 10000<N<1000
     * 词汇表的数量M的范围： 0<M<10000 < M < 10000<M<1000
     * 单词的长度P的范围：0<P<200 < P < 200<P<20
     * 输入的字符只有小写英文字母，没有其它字符
     * 示例一
     * 输入
     * conection
     * connection,today
     * 输出
     * connection
     * 示例二
     * 输入
     * bdni,wooood
     * bind,wrong,wood
     * 输出
     * bind,wood
     * 思路
     * 将需要检查的字符串和目标字符串去重并排序，比较是否相等，全部都不相等则输出not found
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String aim = scanner.nextLine();
            String check = scanner.nextLine();
            solution(aim, check);
        }
    }

    private static void solution(String aim, String check) {
        String[] split = check.split(",");
        String[] seq1 = convert(aim.split(","));

        String[] seq2 = convert(check.split(","));

        List<String> res = new ArrayList<>();
        for (String s1 : seq1) {
            for (int i = 0; i < seq2.length; i++) {
                if (s1.equals(seq2[i]) && !res.contains(split[i])) {
                    res.add(split[i]);
                }
            }
        }
        if (res.size() == 0) {
            System.out.println("not found");
        } else {
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i));
                if (i != res.size() - 1) {
                    System.out.print(",");
                }
            }
        }
    }

    private static String[] convert(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            TreeSet<Character> characters = new TreeSet<>();
            String str = strs[i];
            for (char c : str.toLowerCase().toCharArray()) {
                characters.add(c);
            }
            Character[] array = characters.toArray(new Character[0]);
            char[] chars = new char[array.length];
            for (int j = 0; j < array.length; j++) {
                chars[j] = array[j];
            }
            strs[i] = new String(chars);
        }

        return strs;
    }
}
