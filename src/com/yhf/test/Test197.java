package com.yhf.test;

import java.util.*;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test197 {
    /**
     * 题目0197-找数字
     * 题目描述
     * 给一个二维数组nums，对于每一个元素num[i]，找出距离最近的且值相等的元素，输出横纵坐标差值的绝对值之和，如果没有等值元素，则输出-1。
     * 例如：
     * 输入数组nums为
     * <p>
     * 0 3 5 4 2
     * 2 5 7 8 3
     * 2 5 4 2 4
     * 对于 num[0][0] = 0，不存在相等的值。
     * 对于 num[0][1] = 3，存在一个相等的值，最近的坐标为num[1][4]，最小距离为4。
     * 对于 num[0][2] = 5，存在两个相等的值，最近的坐标为num[1][1]，故最小距离为2。
     * ...
     * 对于 num[1][1] = 5，存在两个相等的值，最近的坐标为num[2][1]，故最小距离为1。
     * ...
     * 故输出为
     * <p>
     * -1 4  2  3 3
     * 1 1 -1 -1 4
     * 1 1  2  3 2
     * 输入描述
     * 输入第一行为二维数组的行
     * 输入第二行为二维数组的列
     * 输入的数字以空格隔开。
     * <p>
     * 输出描述
     * 数组形式返回所有坐标值。
     * <p>
     * 备注
     * 针对数组num[i][j]，满足 0<i≤100；0<j≤1000 < i \leq 100；0 < j \leq 1000<i≤100；0<j≤100。
     * 对于每个数字，最多存在 100100100 个与其相等的数字。
     * 示例一
     * 输入
     * 3
     * 5
     * 0 3 5 4 2
     * 2 5 7 8 3
     * 2 5 4 2 4
     * 输出
     * [[-1, 4, 2, 3, 3], [1, 1, -1, -1, 4], [1, 1, 2, 3, 2]]
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] ints = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    ints[i][j] = scanner.nextInt();
                }
            }
            String res = solution(ints, n, m);
            System.out.println(res);
        }
    }

    private static String solution(int[][] ints, int n, int m) {
        Map<Integer, List<int[]>> numPos = new HashMap<>();
        List<List<Integer>> resList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = ints[i][j];
                if (!numPos.containsKey(num)) {
                    numPos.put(num, new ArrayList<>());
                }
                numPos.get(num).add(new int[]{i, j});
            }
        }

        for (int i = 0; i < n; i++) {
            resList.add(new ArrayList<>());
            List<Integer> curList = resList.get(i);
            for (int j = 0; j < m; j++) {
                int num = ints[i][j];
                List<int[]> allPos = numPos.get(num);
                if (allPos.size() == 1) {
                    curList.add(-1);
                    continue;
                }

                int min = Integer.MAX_VALUE;
                for (int[] pos : allPos) {
                    if (i == pos[0] && j == pos[1]) {
                        continue;
                    }
                    int diff = Math.abs(i - pos[0]) + Math.abs(j - pos[1]);
                    min = Math.min(diff, min);
                }
                curList.add(min);
            }
        }


        return resList.toString();
    }
}
