package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test201 {
    /**
     * 题目0201-最差产品奖
     * 题目描述
     * A公司准备对他下面的 NNN 个产品评选最差奖，
     * 评选的方式是首先对每个产品进行评分，然后根据评分区间计算相邻几个产品中最差的产品。
     * 评选的标准是依次找到从当前产品开始前 MMM 个产品中最差的产品，请给出最差产品的评分序列。
     * <p>
     * 输入描述
     * 第一行，数字 MMM ，表示评分区间的长度，取值范围是 0<M<100000 < M < 100000<M<10000
     * 第二行，产品的评分序列，比如[12,3,8,6,5]，产品数量 NNN 范围是 −10000<N<10000-10000 < N < 10000−10000<N<10000
     * <p>
     * 输出描述
     * 评分区间内最差产品的评分序列
     * <p>
     * 示例一
     * 输入
     * 3
     * 12,3,8,6,5
     * 输出
     * 3,3,5
     * 说明
     * 12,3,8 最差的是3
     * 3,8,6 中最差的是3
     * 8,6,5 中最差的是5
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int m = scanner.nextInt();
            scanner.nextLine();
            String pdc = scanner.nextLine();
            String res = solution(m, pdc);
            System.out.println(res);
        }
    }

    private static String solution(int m, String pdc) {
        String[] split = pdc.split(",");
        int[] scores = new int[split.length];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            scores[i] = Integer.parseInt(split[i]);
            int min = Integer.MAX_VALUE;
            if (i >= m - 1) {
                for (int j = 0; j < m; j++) {
                    min = Math.min(min, scores[i - j]);
                }
                builder.append(min).append(',');
            }
        }

        return builder.substring(0, builder.length() - 1);
    }
}
