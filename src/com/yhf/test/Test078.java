package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test078 {
    /**
     * 题目0078-洞穴探险
     * 题目描述
     * 某探险队负责对地下洞穴进行探险,
     * 探险队成员在进行探险任务时,随身携带的记录器会不定期的记录自身的坐标
     * 但在记录的间隙中也会记录其他数据,
     * 探索工作结束,后探险队需要获取到 某成员在探险过程中,
     * 相对于探险队总部的最远的足迹位置。
     * <p>
     * 仪器记录坐标时,坐标的数据格式(x,y),如(1,2),(100,200)
     * 其中0 < x < 1000,0 < y < 1000,同时存在非法坐标如(01,1),(1,01),(0,100)属于非法坐标.
     * 设定探险队总部的坐标为(0,0)某位置相对总部的距离为x*x+y*y。
     * 若两个坐标的相对总部的距离相同则第一次到达的坐标为最远的足迹
     * 若记录仪中的坐标都不合法输出总部坐标(0,0)
     * 备注：不需要考虑双层括号嵌套的情况比如sfsdfsd((1,2))
     * 输入描述
     * 字符串表示记录仪中的数据如:
     * ferga13fdsf3(100,200)f2r3rfasf(300,400)
     * <p>
     * 输出描述
     * 字符串表示最远足迹到达的坐标如:
     * (300,400)
     * <p>
     * 示例一
     * 输入
     * ferg(3,10)a13fdsf3(3,4)f2r3rfasf(5,10)
     * 输出
     * (5,10)
     * 说明
     * 记录仪中的合法坐标有三个(3,10)(3,4)(5,10)其中(5,10)是相距总部最远的坐标输出(5,10)
     * <p>
     * 示例二
     * 输入
     * asfefaweawfawf(0,1)fe
     * 输出
     * (0,0)
     * 说明
     * 记录仪中的坐标都不合法输出总部坐标(0,0)
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String history = scanner.nextLine();
            solution(history);
        }
    }

    private static void solution(String history) {
        int index = 0, x = 0, y = 0, max = 0;
        int l, r;
        while (true) {
            history = history.substring(index);
            l = history.indexOf("(");
            r = history.indexOf(")");
            if (l == -1) break;
            String substring = history.substring(l + 1, r);
            String[] split = substring.split(",");
            if (!split[0].startsWith("0") && !split[1].startsWith("0")) {
                int a = Integer.parseInt(split[0]);
                int b = Integer.parseInt(split[1]);
                int len = a * a + b * b;
                if (max < len) {
                    max = len;
                    x = a;
                    y = b;
                }
            }
            index = r + 1;
        }
        System.out.printf("(%d,%d)", x, y);
    }
}
