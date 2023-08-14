package com.yhf.test;

import java.util.*;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test131 {
    /**
     * 题目0131-需要广播的服务器数量
     * 题目描述
     * 服务器连接方式包括直接相连，间接连接。
     * A和B直接连接，B和C直接连接，则A和C间接连接。
     * 直接连接和间接连接都可以发送广播。
     * 给出一个N*N数组，代表N个服务器，matrix[i][j] == 1，
     * 则代表i和j直接连接；不等于1时，代表i和j不直接连接。
     * matrix[i][i] == 1，
     * 即自己和自己直接连接。matrix[i][j] == matrix[j][i]。
     * 计算初始需要给几台服务器广播，
     * 才可以使每个服务器都收到广播。
     *
     * 输入描述
     * 输入为N行，每行有N个数字，为0或1，由空格分隔，
     * 构成N*N的数组，N的范围为 1 <= N <= 40
     *
     * 输出描述
     * 输出一个数字，为需要广播的服务器的数量
     *
     * 示例一
     * 输入
     * 1 0 0
     * 0 1 0
     * 0 0 1
     * 输出
     * 3
     * 说明
     * 3台服务器互不连接，所以需要分别广播这3台服务器
     *
     * 示例二
     * 输入
     * 1 1
     * 1 1
     * 输出
     * 1
     * 说明
     * 2台服务器相互连接，所以只需要广播其中一台服务器
     */

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            String[] s = line.split(" ");
            int n = s.length;   //确定是n阶数组
            int[][] ints = new int[n][n];

            for (int i = 0; i < n; i++) {
                ints[0][i] = Integer.parseInt(s[i]); //第一行
            }
            int m = 1;
            while (n > m) {
                for (int i = 0; i < n; i++) {
                    ints[m][i] = scanner.nextInt();  //第i行
                }
                m++;
            }

            solution(ints);
        }
    }

    private static void solution(int[][] ints) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int mapKey = 0;
        for (int i = 0; i < ints.length; i++) {
            boolean isContain = false;
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                if (entry.getValue().contains(i)) {
                    isContain = true;
                    mapKey = entry.getKey();
                }
            }
            if (!isContain) {
                map.put(i, new ArrayList<>());
                mapKey = i;
            }
            for (int j = i; j < ints.length; j++) {
                if (i != j && ints[i][j] == 1) {
                    map.get(mapKey).add(j);
                }
            }
        }

        System.out.print(map.size());
    }
}
