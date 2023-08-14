package com.yhf.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test172 {
    /**
     * 题目0172-开放日活动
     * 题目描述
     * 某部门开展Family Day开放日活动，其中有个从桶里取球的游戏，
     * 游戏规则如下：有N个容量一样的小桶等距排开，
     * 且每个小桶都默认装了数量不等的小球，
     * 每个小桶装的小球数量记录在数组bucketBallNums中，
     * 游戏开始时，要求所有桶的小球总数不能超过SUM，
     * 如果小球总数超过SUM，则需对所有的小桶统一设置一个容量最大值maxCapacity，
     * 并需将超过容量最大值的小球拿出来，直至小桶里的小球数量小于maxCapacity;
     * 请您根据输入的数据，计算从每个小桶里拿出的小球数量。
     * 限制规则一：
     * 所有所有小桶的小球总和小于SUM，则无需设置容量值，
     * 并且无需从小桶中拿球出来，返回结果[];
     * 限制规则二：
     * 如果所有小桶的小球总和大于SUM，则需设置容量最大值maxCapacity，
     * 并且需从小桶中拿球出来，返回从每个小桶拿出的小球数量组成的数组；
     * <p>
     * 输入描述
     * 第一行输入2个正整数，数字之间使用空格隔开，其中第一个数字表示SUM，第二个数字表示bucketBallNums数组长度；
     * 第二行输入N个正整数，数字之间使用空格隔开，表示bucketBallNums的每一项；
     * <p>
     * 输出描述
     * 示例一
     * 输入
     * 14 7
     * 2 3 2 5 5 1 4
     * 输出
     * [0,1,0,3,3,0,2]
     * 说明
     * 小球总数为22，SUM=14，超出范围了，需从小桶取球，
     * maxCapacity=1，取出球后，桶里剩余小球总和为7，远小于14
     * maxCapacity=2，取出球后，桶里剩余小球总和为13，
     * maxCapacity=3，取出球后，桶里剩余小球总和为16，大于14
     * 因此maxCapacity为2 ，每个小桶小球数量大于2的都需要拿出来；
     * <p>
     * maxCapacity=1，取出球后，
     * 桶里剩余小球总和为7，远小于14
     * maxCapacity=2，取出球后，
     * 桶里剩余小球总和为13
     * maxCapacity=3，取出球后，
     * 桶里剩余小球总和为16，大于14
     * <p>
     * 示例二
     * 输入
     * 3 3
     * 1 2 3
     * 输出
     * [0,1,2]
     * 说明
     * 小球总数为6，SUM=3，超出范围了，需从小桶取球
     * maxCapacity=1，则小球总数为3，
     * 从0号桶取出0个球，
     * 从1号桶取出1个球，
     * 从2号桶取出2个球；
     * <p>
     * 示例一
     * 输入
     * 6 2
     * 3 2
     * 输出
     * []
     * 说明
     * 小球总数为5，SUM=6，在范围内，无需从小桶取球；
     * <p>
     * 备注
     * 1 <= bucketBallNums[i] <= 10^9
     * 1 <= bucketBallNums.length = N <= 10^5
     * 1 <= maxCapacity <= 10^9
     * 1 <= SUM <= 10^9
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int sum = scanner.nextInt();
            int nums = scanner.nextInt();
            int[] balls = new int[nums];
            for (int i = 0; i < nums; i++) {
                balls[i] = scanner.nextInt();
            }
            solution(sum, balls);
        }
    }

    private static void solution(int sum, int[] balls) {
        int total = getTotal(balls);
        if (total <= sum) {
            System.out.println("[]");
            return;
        }
        int[] tmp = new int[balls.length];
        int[] sub = new int[balls.length];
        for (int i = sum; true; i--) {
            for (int k = 0; k < balls.length; k++) {
                if (balls[k] > i) {
                    sub[k] = balls[k] - i;
                    tmp[k] = i;
                } else {
                    sub[k] = 0;
                    tmp[k] = balls[k];
                }
            }
            if (getTotal(tmp) <= sum) {
                System.out.println(Arrays.toString(sub).replaceAll(" ", ""));
                break;
            }
        }
    }

    private static int getTotal(int[] balls) {
        int total = 0;
        for (int ball : balls) {
            total += ball;
        }
        return total;
    }
}
