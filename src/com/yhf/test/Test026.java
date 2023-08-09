package com.yhf.test;

import java.util.*;

/**
 * Created on 2023/8/9.
 *
 * @author qyjy4737
 */
public class Test026 {
    /**
     * 题目0026-去重求和
     * 题目描述
     * 给定一个数组，编写一个函数，
     * 计算他的最大N个数和最小N个数的和，
     * 需要对数组进行去重。
     * <p>
     * 输入描述
     * 第一行输入M，M表示数组大小
     * 第二行输入M个数，表示数组内容
     * 第三行输入N表示需要计算的最大最小N的个数
     * <p>
     * 输出描述
     * 输出最大N个数和最小N个数的和
     * <p>
     * 示例一
     * 输入
     * 5
     * 95 88 83 64 100
     * 2
     * 输出
     * 342
     * 说明
     * 最大2个数[100 95]最小2个数[83 64]
     * 输出342
     * <p>
     * 示例一
     * 输入
     * 5
     * 3 2 3 4 2
     * 2
     * 输出
     * -1
     * 说明
     * 最大2个数是[4 3]最小2个数是[3 2]
     * 有重叠输出为-1
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int m = Integer.parseInt(scanner.nextLine());
            String line = scanner.nextLine();
            int n = Integer.parseInt(scanner.nextLine());
            solution(m, line, n);
        }
    }

    private static void solution(int m, String line, int n) {
        Set<Integer> ints = new TreeSet<>();
        String[] arr = line.split(" ");
        Arrays.stream(arr)
                .forEach(x -> ints.add(Integer.parseInt(x)));

        int res = -1;

        if (ints.size() >= 2 * n) {
            res = 0;
            List<Integer> list = new ArrayList<>(ints);
            for (int i = 0; i < list.size(); i++) {
                if (i < n || i > list.size() - 1 - n) {
                    res += list.get(i);
                }
            }
        }
        System.out.println(res);
    }
}
