package com.yhf.test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test121 {
    /**
     * 题目0121-机器人走迷宫
     * 题目描述
     * 房间有X*Y的方格组成，例如下图为6*4的大小。每一个放个以坐标(x,y)描述。
     * 机器人固定从方格(0,0)出发，只能向东或者向北前进，
     * 出口固定为房间的最东北角，如下图的方格(5,3)。
     * 用例保证机器人可以从入口走到出口。
     * 房间有些方格是墙壁，如(4,1),机器人不能经过那儿。
     * 有些地方是一旦到达就无法走到出口的，如标记为B的方格，称之为陷阱方格。
     * 有些地方是机器人无法达到的，如标记为A的方格，称之为不可达方格，不可达方格不包括墙壁所在的位置
     * 如下实例图中，陷阱方格有2个，不可达方格有3个。
     * 请为该机器人实现路径规划功能：给定房间大小，墙壁位置，请计算出陷阱方格与不可达方格分别有多少个
     * 0121.png
     * 输入描述
     * 第一行为房间的x和y(0 < x,y <= 1000)
     * 第二行为房间中墙壁的个数N (0 <= N < X*Y)
     * 接着下面会有N行墙壁的坐标
     * 同一行中如果有多个数据以一个空格隔开，用例保证所有的输入数据均合法，(结尾不带回车换行)
     * 输出描述
     * 陷阱方格与不可达方格数量，两个信息在一行中输出，以一个空格隔开。(结尾不带回车换行)
     * 示例一
     * 输入
     * 6 4
     * 5
     * 0 2
     * 1 2
     * 2 2
     * 4 1
     * 5 1
     * 输出
     * 2 3
     * 说明
     * 示例二
     * 输入
     * 6 4
     * 4
     * 2 0
     * 2 1
     * 3 0
     * 3 1
     * 输出
     * 0 4
     * 说明
     * 说明不可达方格有4个 (4,0) (4,1) (5,0) (5,1)
     * 01212.png
     */

    private static int xLen;
    private static int yLen;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            xLen = scanner.nextInt();
            yLen = scanner.nextInt();
            int n = scanner.nextInt();

            int[][] walls = new int[n][2];
            for (int i = 0; i < n; i++) {
                walls[i][0] = scanner.nextInt();
                walls[i][1] = scanner.nextInt();
            }

            solution(walls);
        }
    }

    static class Check {
        int x;
        int y;

        public Check(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Check check = (Check) o;
            return x == check.x && y == check.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

    private static void solution(int[][] walls) {
        int trapCount = 0;
        int invalidCount = 0;
        Set<Check> wallSet = new HashSet<>();
        for (int[] wall : walls) {
            wallSet.add(new Check(wall[0], wall[1]));
        }
        Set<Check> checks = new HashSet<>();
        Set<Check> finish = new HashSet<>();

        //  x, y
        findOut(0, 0, wallSet, checks, finish);

//    System.out.println(checks);
        invalidCount = xLen * yLen - checks.size() - wallSet.size();
//    System.out.println(finish);

        // trapTest
        for (Check check : finish) {
            Set<Check> checksT = new HashSet<>();
            Set<Check> finishT = new HashSet<>();
            findOut(check.x, check.y, wallSet, checksT, finishT);
            if (!finishT.contains(new Check(xLen - 1, yLen - 1))) {
                trapCount++;
            }
        }


        System.out.print(trapCount + " " + invalidCount);
    }

    private static void findOut(int x, int y, Set<Check> wallSet, Set<Check> checks, Set<Check> finish) {

        if (x == xLen - 1 && y == yLen - 1) {
            finish.add(new Check(x, y));
        }

        if (x >= xLen || y >= yLen) {
            return;
        }

        checks.add(new Check(x, y));
        // 北
        if (!wallSet.contains(new Check(x, y + 1))) {
            findOut(x, y + 1, wallSet, checks, finish);
        } else {
            finish.add(new Check(x, y));
        }
        // 东
        if (!wallSet.contains(new Check(x + 1, y))) {
            findOut(x + 1, y, wallSet, checks, finish);
        } else {
            finish.add(new Check(x, y));
        }
    }
}
