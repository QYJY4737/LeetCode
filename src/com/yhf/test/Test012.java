package com.yhf.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/9.
 *
 * @author qyjy4737
 */
public class Test012 {
    /**
     * 题目0012-快递货车
     * 题目描述
     * 一辆运送快递的货车，
     * 运送的快递放在大小不等的长方体快递盒中，
     * 为了能够装载更多的快递同时不能让货车超载，
     * 需要计算最多能装多少个快递。
     * 注：快递的体积不受限制。
     * 快递数最多1000个，货车载重最大50000。
     * <p>
     * 输入描述
     * 第一行输入每个快递的重量
     * 用英文逗号隔开
     * 如 5,10,2,11
     * 第二行输入货车的载重量
     * 如 20
     * <p>
     * 输出描述
     * 输出最多能装多少个快递
     * 如 3
     * <p>
     * 示例一
     * 输入
     * 5,10,2,11
     * 20
     * 输出
     * 3
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String weights = scanner.nextLine();
            int capacity = scanner.nextInt();
            solution(weights, capacity);
        }
    }

    private static void solution(String weightsStr, int capacity) {
        String[] split = weightsStr.split(",");
//        int[] weights = new int[split.length];
//        for (int i = 0; i < split.length; i++) {
//            weights[i] = Integer.parseInt(split[i]);
//        }

//        Arrays.sort(weights);
        // 通过lambda表达式进行转换
        int[] weights = Arrays.asList(split).stream().mapToInt(Integer::parseInt).sorted().toArray();
        int sum = 0;
        int i = 0;
        while (i < weights.length) {
            if (sum + weights[i] <= capacity) {
                sum += weights[i++];
            } else {
                break;
            }
        }
        System.out.println(i);
    }
}
