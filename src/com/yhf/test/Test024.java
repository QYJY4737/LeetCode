package com.yhf.test;

import java.util.*;

/**
 * Created on 2023/8/9.
 *
 * @author qyjy4737
 */
public class Test024 {
    /**
     * 题目0024-黑板上色
     * 题目描述
     * 疫情过后希望小学终于又重新开学了，3年2班开学第一天的任务是将后面的黑板报重新制作，
     * 黑板上已经写上了N个正整数，同学们需要给这每个数分别上一种颜色，
     * 为了让黑板报既美观又有学习意义，老师要求同种颜色的所有数都可以被这个颜色中最小的那个数整除，
     * 现在帮小朋友们算算最少需要多少种颜色，给这N个数进行上色
     * <p>
     * 输入描述
     * 第一行有一个正整数N
     * 其中1 <= N <= 100
     * 第二行有N个int型数，保证输入数据在[1,100]范围中
     * 表示黑板上各个正整数的值
     * <p>
     * 输出描述
     * 输出只有一个整数，为最少需要的颜色种数
     * <p>
     * 示例一
     * 输入
     * 3
     * 2 4 6
     * 输出
     * 1
     * 说明
     * 所有数都能被2整除
     * <p>
     * 示例二
     * 输入
     * 4
     * 2 3 4 9
     * 输出
     * 2
     * 说明
     * 2与4涂一种颜色，4能被2整除
     * 3与9涂另一种颜色，9能被3整除
     * 不能涂同一种颜色
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = Integer.parseInt(scanner.nextLine());
            String line = scanner.nextLine();
            solution(n, line);
        }
    }

    private static void solution(int n, String line) {
        String[] nums = line.split(" ");

        Set<Integer> ints = new TreeSet<>();
        for (String num : nums) {
            ints.add(Integer.parseInt(num));
        }

        if (ints.contains(1)) {
            System.out.println(1);
            return;
        }

        List<Integer> list = new ArrayList<>(ints);
        for (int i = 0; i < list.size(); i++) {
            Integer cur = list.get(i);
            for (int j = i + 1; j < list.size(); ) {
                if (list.get(j) % cur == 0) {
                    list.remove(j);
                } else j++;
            }
        }
        System.out.println(list.size());
    }

}
