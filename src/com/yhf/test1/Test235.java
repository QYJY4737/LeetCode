package com.yhf.test1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test235 {
    /**
     * 题目0235-最多颜色的车辆
     * 题目描述
     * 在一个狭小的路口，每秒只能通过一辆车，假设车辆的颜色只有 3 种，找出 NNN 秒内经过的最多颜色的车辆数量。
     * <p>
     * 三种颜色编号为0,1,2。
     * <p>
     * 输入描述
     * 第一行输入的是通过的车辆颜色信息。
     * <p>
     * [0,1,1,2] 代表4 秒钟通过的车辆颜色分别是 0,1,1,2
     * <p>
     * 第二行输入的是统计时间窗，整型，单位为秒。
     * <p>
     * 输出描述
     * 输出指定时间窗内经过的最多颜色的车辆数量。
     * <p>
     * 示例一
     * 输入
     * 0 1 2 1
     * 3
     * 输出
     * 2
     * 说明
     * 在 3 秒时间窗内，每个颜色最多出现 2 次。例如：[1,2,1]
     * <p>
     * 示例二
     * 输入
     * 0 1 2 1
     * 2
     * 输出
     * 1
     * 说明
     * 在 2 秒时间窗内，每个颜色最多出现1 次。
     * <p>
     * 思路解析和复杂度分析
     * 本题的目标是找出给定时间窗口内经过的最多颜色的车辆数量。解决这个问题的关键在于使用滑动窗口的方法。
     * <p>
     * 解题思路
     * 首先，读取输入，将车辆颜色信息保存到一个数组或列表中，同时读取时间窗口的大小。
     * 接下来，使用滑动窗口的方法遍历数组，计算每个窗口中出现的颜色数量。为此，可以使用一个长度为 3 的数组 colors 来统计每种颜色的出现次数，然后计算当前窗口中出现的不同颜色的数量 unique_colors。
     * 如果当前窗口的 unique_colors 大于已找到的最大颜色数量 max_colors，则更新 max_colors。
     * 遍历完数组后，输出结果 max_colors。
     * 复杂度分析
     * 时间复杂度：本算法的时间复杂度为 O(nk)O(nk)O(nk)，其中 nnn 为车辆颜色信息的数量，kkk 为时间窗口的大小。在最坏的情况下，可能需要遍历整个数组，并且在每个窗口中计算颜色数量。
     * <p>
     * 空间复杂度：本算法的空间复杂度为 O(n)O(n)O(n)，其中 nnn 为车辆颜色信息的数量。主要的空间开销来自于存储输入数据的数组或列表以及滑动窗口的 colors 数组。
     * <p>
     * 总的来说，本题的解题思路较为简单。关键在于使用滑动窗口的方法遍历数组并计算每个窗口中出现的颜色数量。在实现过程中，需要注意如何读取输入数据并将其保存到合适的数据结构中。最后，在遍历数组时，需要正确地计算和更新最大颜色数量。
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> carColors = new ArrayList<>();

        // Read car colors
        String input = scanner.nextLine();
        String[] inputColors = input.split(" ");
        for (String color : inputColors) {
            carColors.add(Integer.parseInt(color));
        }

        // Read window size
        int windowSize = scanner.nextInt();

        int maxColors = 0;
        for (int i = 0; i < carColors.size() - windowSize + 1; i++) {
            int[] colors = new int[3];
            for (int j = i; j < i + windowSize; j++) {
                colors[carColors.get(j)]++;
            }
            int uniqueColors = 0;
            for (int c = 0; c < 3; c++) {
                if (colors[c] > 0) {
                    uniqueColors++;
                }
            }
            if (uniqueColors > maxColors) {
                maxColors = uniqueColors;
            }
        }

        System.out.println(maxColors);
    }
}
