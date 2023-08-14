package com.yhf.test1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test209 {
    /**
     * 题目0209-找出通过车辆最多颜色
     * 题目描述
     * 在一个狭小的路口，每秒只能通过一辆车，
     * 假如车辆的颜色只有3种，找出 NNN 秒内经过的最多颜色的车辆数量，
     * 三种颜色编号为0，1，2
     * <p>
     * 输入描述
     * 第一行输入的是通过的车辆颜色信息
     * [0,1,1,2] 代表4秒钟通过的车辆颜色分别是0,1,1,2
     * 第二行输入的是统计时间窗，整型，单位为秒
     * <p>
     * 输出描述
     * 输出指定时间窗内经过的最多颜色的车辆数量
     * <p>
     * 示例一
     * 输入
     * 0 1 2 1
     * 3
     * 输出
     * 2
     * 说明
     * 在[1,2,1]这个3秒时间窗内，1这个颜色出现2次，数量最多
     * <p>
     * 示例一
     * 输入
     * 0 1 2 1
     * 2
     * 输出
     * 1
     * 说明
     * 在2秒时间窗内，每个颜色最多出现1次
     * <p>
     * 思路
     * 用map保存时间窗口内的车辆颜色和数量
     * 时间每过1s，
     * 如果总时间不足窗口长度，则直接更新颜色计数
     * 如果总时间超过窗口长度，则先移除最早的数据，再更新颜色计数
     * 更新出现最高的颜色数量
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            int w = scanner.nextInt();
            int res = solution(line, w);
            System.out.println(res);
        }
    }

    private static int solution(String line, int w) {
        String[] split = line.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < split.length; i++) {
            String cur = split[i];
            // 时间超过窗口长度，则移除窗口最早的数据
            if (i > w) {
                String out = split[i - w];
                map.put(out, map.getOrDefault(out, 1) - 1);
            }

            // 更新车辆颜色的计数
            int count = map.getOrDefault(cur, 0) + 1;
            map.put(cur, count);

            // 更新出现最多颜色的数量
            max = Math.max(max, count);
        }
        return max;
    }
}
