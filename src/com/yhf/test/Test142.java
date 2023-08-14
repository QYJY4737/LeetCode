package com.yhf.test;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test142 {
    /**
     * 题目0142-考古学家
     * 题目描述
     * 有一个考古学家发现一个石碑
     * 但是很可惜 发现时其已经断成多段
     * 原地发现N个断口整齐的石碑碎片
     * 为了破解石碑内容
     * 考古学家希望有程序能帮忙计算复原后的石碑文字组合数
     * 你能帮忙吗
     *
     * 备注： 如果存在石碑碎片内容完全相同，则由于碎片间的顺序不影响复原后的碑文内容，
     * 仅相同碎片间的位置变化不影响组合
     *
     * 输入描述
     * 第一行输入N，N表示石碑碎片的个数
     * 第二行依次输入石碑碎片上的文字内容S共有N组
     *
     * 输出描述
     * 输出石碑文字的组合(按照升序排列)，行尾无多余空格
     *
     * 示例一
     * 输入
     * 3
     * a b c
     * 输出
     * abc
     * acb
     * bac
     * bca
     * cab
     * cba
     * 说明
     * 当石碑碎片的内容为"a" ,"b","c"时 则组合有
     *
     * 示例二
     * 输入
     * 3
     * a b a
     * 输出
     * aab
     * aba
     * baa
     * 说明
     * 示例三
     * 输入
     * 3
     * a b ab
     * 输出
     * aabb
     * abab
     * abba
     * baab
     * baba
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = Integer.parseInt(scanner.nextLine());
            String segment = scanner.nextLine();
            solution(n, segment);
        }
    }

    private static void solution(int n, String segment) {
        String[] segments = segment.split(" ");
        permutation(0, segments);

        for (String str : resSet) {
            System.out.println(str);
        }
    }

    private static final TreeSet<String> resSet = new TreeSet<>();


    private static void permutation(int index, String[] arr) {
        if (arr.length == index) {
            StringBuilder builder = new StringBuilder();
            for (String str : arr) {
                builder.append(str);
            }
            if (!builder.toString().isEmpty()) {
                resSet.add(builder.toString());
            }
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(i, index, arr);
            permutation(index + 1, arr);
            swap(i, index, arr);
        }

    }

    private static void swap(int i, int j, String[] arr) {
        String temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
