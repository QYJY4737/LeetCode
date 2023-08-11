package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test093 {
    /**
     * 题目0093-路灯照明
     * 题目描述
     * 在一条笔直的公路上安装了N个路灯，
     * 从位置0开始安装，路灯之间间距固定为100米
     * 每个路灯都有自己的照明半径
     * 请计算第一个路灯和最后一个路灯之间，
     * 无法照明的区间的长度和。
     * <p>
     * 输入描述
     * 第一行为一个数N，表示路灯个数，1 <= N <= 100000
     * 第二行为N个空格分割的数，表示路灯的照明半径，1 <= 照明半径
     * <p>
     * 输出描述
     * 无法照明的区间的长度和。
     * <p>
     * 示例一
     * 输入
     * 2
     * 50 50
     * 输出
     * 0
     * 说明
     * 路灯1覆盖0-50 路灯二覆盖50-100
     * 路灯1和路灯2 之间(0-100米)无未覆盖的区间
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = scanner.nextInt();
            }
            solution(ints);
        }
    }

    private static void solution(int[] ints) {
        byte[] bytes = new byte[(ints.length - 1) * 100];
        for (int i = 0; i < ints.length; i++) {
            int pos = i * 100;
            int left = Math.max(pos - ints[i], 0);
            int right = Math.min(pos + ints[i], bytes.length);
            for (int k = left; k < right; k++) {
                bytes[k] = 1;
            }
        }
        int count = 0;
        for (byte b : bytes) {
            if (b == 0) count++;
        }
        System.out.println(count);
    }
}
