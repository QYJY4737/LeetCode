package com.yhf.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test148 {
    /**
     * 题目0148-核酸检测人员安排
     * 题目描述
     * 在系统、网络均正常情况下，组织核酸采样员和志愿者对人群进行核酸检测筛查。
     * 每名采样员的效率不同，采样效率为N人/小时。
     * 由于外界变化，采样员的效率会以M人/小时为粒度发生变化，M为采样效率浮动粒度，
     * M=N*10%，输入保证N*10%的结果为整数。
     * 采样员效率浮动规则：采样员需要一名志愿者协助组织才能发挥正常效率，
     * 再此基础上，每增加一名志愿者，效率提升1M，最多提升3M，
     * 如果没有志愿者协助组织，效率下降2M.
     * 怎么安排速度最快？求总最快检测效率（总检查效率为个采样人员效率值相加 ）
     *
     * 输入描述
     * 第一行：
     * 第一个值，采样员人数，取值范围[1,100]；
     * 第二个值，志愿者人数，取值范围[1,500]；
     * 第二行：
     * 采样员基准效率值（单位人/小时），取值范围[60,600], 保证序列中每项值计算10%为整数
     * 输出描述
     * 第一行：总最快检测效率（单位人/小时）
     * 示例一
     * 输入
     * 2 2
     * 200 200
     * 输出
     * 400
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            Integer[] arrX = new Integer[x];
            for (int i = 0; i < x; i++) {
                arrX[i] = scanner.nextInt();
            }

            System.out.println(solution(arrX, x, y));
        }
    }

    public static int solution(Integer[] arr, int x, int y) {
        Arrays.sort(arr, (a, b) -> b - a);

        int max = 0;
        int count = 0;
        int i;
        int j;

        if (y < x) {
            for (int k = 0; k < x; k++) {
                max += k < y ? arr[k] : arr[k] * 0.8;
            }

            i = 0;
            j = y - 1;
        } else {
            if (y >= 4 * x) {
                y = 4 * x;
            }

            for (Integer val : arr) {
                max += val;
            }

            int surplus = y - x;

            i = 0;
            j = x - 1;

            while (surplus > 0) {
                max += arr[i] * 0.1;
                surplus--;
                if (++count == 3) {
                    count = 0;
                    i++;
                }
            }
        }

        while (i < j) {
            if (arr[i] * 0.1 > arr[j] * 0.2) {
                max += arr[i] * 0.1 - arr[j] * 0.2;

                if (++count == 3) {
                    count = 0;
                    i++;
                }
                j--;
            } else {
                break;
            }
        }

        return max;
    }
}
