package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test185 {
    /**
     * 题目0185-自动曝光
     * 题目描述
     * 一个图像有n个像素点，存储在一个长度为n的数组img里，每个像素点的取值范围[0,255]的正整数。
     * 请你给图像每个像素点值加上一个整数k（可以是负数），得到新图newImg，使得新图newImg的所有像素平均值最接近中位值128。
     * 请输出这个整数k。
     * <p>
     * 输入描述
     * n个整数，中间用空格分开
     * 例如：
     * 0 0 0 0
     * 4个数值，中间用空格分开
     * <p>
     * 输出描述
     * 一个整数k
     * <p>
     * 备注：
     * <p>
     * 1≤n≤1001 \leq n \leq 1001≤n≤100
     * 如有多个整数 kkk 都满足，输出小的那个 kkk；
     * 新图的像素值会自动截取到 [0,255][0,255][0,255] 范围。当新像素值<0，其值会更改为0；当新像素值>255，其值会更改为255；
     * 例如newImg="-1 -2 256",会自动更改为"0 0 255"
     * 示例一
     * 输入
     * 0 0 0 0
     * 输出
     * 128
     * 说明
     * 四个像素值都为0
     * <p>
     * 示例二
     * 输入
     * 129 130 129 130
     * 输出
     * -2
     * 说明
     * -1的均值128.5，-2的均值为127.5，输出较小的数-2
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            int res = solution(line);
            System.out.println(res);
        }
    }

    private static int solution(String line) {
        int k = 0;
        String[] split = line.split(" ");
        int[] img = new int[split.length];
        for (int i = 0; i < img.length; i++) {
            img[i] = Integer.parseInt(split[i]);
        }
        int avg = avg(img);

        int diff = avg - 128;
        int[] newImg = new int[img.length];
        System.arraycopy(img, 0, newImg, 0, img.length);
        if (diff > 0) {
            while (avg > 127) {
                k--;
                avg = updateAndGetAvg(newImg, -1);
            }
        }

        if (diff < 0) {
            while (avg < 128) {
                k++;
                avg = updateAndGetAvg(newImg, 1);
            }
        }


        return k;
    }

    private static int updateAndGetAvg(int[] newImg, int lambda) {
        for (int i = 0; i < newImg.length; i++) {
            if (newImg[i] + lambda > 255) {
                newImg[i] = 255;
            } else if (newImg[i] + lambda < 0) {
                newImg[i] = 0;
            } else {
                newImg[i] += lambda;
            }
        }
        return avg(newImg);
    }

    private static int avg(int[] img) {
        int sum = 0;
        for (int i : img) {
            sum += i;
        }
        return sum / img.length;
    }
}
