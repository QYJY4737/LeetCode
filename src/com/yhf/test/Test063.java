package com.yhf.test;

import java.util.*;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test063 {
    /**
     * 题目0063-射击比赛
     * 题目描述
     * 给定一个射击比赛成绩单
     * 包含多个选手若干次射击的成绩分数
     * 请对每个选手按其最高三个分数之和进行降序排名
     * 输出降序排名后的选手ID序列
     * 条件如下:
     * <p>
     * 一个选手可以有多个射击成绩的分数 且次序不固定
     * 如果一个选手成绩小于三个 则认为选手的所有成绩无效 排名忽略该选手
     * 如果选手的成绩之和相等,则成绩相等的选手按照其ID降序排列
     * 输入描述
     * 输入第一行:一个整数 N
     * 表示该场比赛总共进行了N次射击
     * 产生N个成绩分数 2 <= N <= 100
     * 输入第二行 一个长度为N的整数序列
     * 表示参与本次射击的选手Id
     * 0 <= ID <= 99
     * 输入第三行是长度为N的整数序列
     * 表示参与每次射击的选手对应的成绩
     * 0 <= 成绩 <= 100
     * <p>
     * 输出描述
     * 符合题设条件的降序排名后的选手ID序列
     * <p>
     * 示例一
     * 输入
     * 13
     * 3,3,7,4,4,4,4,7,7,3,5,5,5
     * 53,80,68,24,39,76,66,16,100,55,53,80,55
     * 输出
     * 5,3,7,4
     * 说明
     * 该场射击比赛进行了13次,参赛选手为3 4 5 7
     * 3号选手的成绩为53 80 55最高三个成绩的和为 188
     * 4号选手的成绩为24 39 76 66最高三个和为181
     * 5号选手的成绩为53 80 55 最高三个和为188
     * 7号选手成绩为68 16 100 最高三个和184
     * 比较各个选手最高三个成绩的和
     * 3 = 5 > 7 > 4
     * 由于3和5成绩相等 且5 > 3 所以输出为5,3,7,4
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String playerStr = scanner.nextLine();
            String scoreStr = scanner.nextLine();
            solution(n, playerStr, scoreStr);
        }
    }

    private static void solution(int n, String playerStr, String scoreStr) {
        String[] players = playerStr.split(",");
        String[] scores = scoreStr.split(",");
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(players[i]);
            int value = Integer.parseInt(scores[i]);
            if (map.containsKey(key)) {
                map.get(key).add(value);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(value);
                map.put(key, list);
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        map.forEach((a, b) -> {
            List<Integer> list = new ArrayList<>();
            if (b.size() >= 3) {
                Collections.sort(b);
                list.add(a);
                list.add(b.get(b.size() - 1) + b.get(b.size() - 2) + b.get(b.size() - 3));
            }
            lists.add(list);
        });
        lists.sort((a, b) -> {
            if (b.get(1) > a.get(1)) {
                return 1;
            }
            if (b.get(0) > a.get(0)) {
                return 1;
            }
            return -1;
        });
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lists.size() - 1; i++) {
            builder.append(lists.get(i).get(0)).append(",");
        }
        System.out.print(builder.toString() + lists.get(lists.size() - 1).get(0));
    }
}
