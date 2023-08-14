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
public class Test125 {
    /**
     * 题目0125-人数最多的站点
     * 题目描述
     * 公园园区提供小火车单向通行，从园区站点编号最小到最大，
     * 通行如1~2~3~4~1万，然后供员工在各个办公园区穿梭，
     * 通过对公司N个员工调研统计到每个员工的坐车区间，包含前后站点，
     * 请设计一个程序计算出小火车在哪个园区站点时人数最多。
     * <p>
     * 输入描述
     * 输入的第1个行，为调研员工人数
     * 第2行开始，
     * 为每个员工的开始上车站点和下车站点。
     * 使用数字代替每个园区用空格，分割如3 5表示从第3个园区上车，
     * 在第5个园区下车
     * <p>
     * 输出描述
     * 人数最多时的园区站点编号，最多人数相同时返回编号最小的园区站点
     * <p>
     * 示例一
     * 输入
     * 3
     * 1 3
     * 2 4
     * 1 4
     * 输出
     * 2
     * 说明
     * 第1行3代表调研员工总人数为3，
     * 小火车在第1个园区时，车上有两个人
     * 到第2个园区时，有三个人到
     * 第3个园区，是三个人，
     * 到第4个园区，是两个人
     * 返回数字最小的园区，所以输出2
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[][] ints = new int[n][2];
            for (int i = 0; i < n; i++) {
                int s = scanner.nextInt();
                int e = scanner.nextInt();
                int[] pair = {Math.min(s, e), Math.max(s, e)};
                ints[i] = pair;
            }

            solution(ints);
        }
    }

    private static void solution(int[][] ints) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] pair : ints) {
            for (int i = pair[0]; i <= pair[1]; i++) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        LinkedList<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        Integer res = list.get(0).getKey();

        System.out.println(res);
    }
}
