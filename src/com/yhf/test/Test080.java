package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test080 {

    /**
     * 题目0080-五键键盘
     * 题目描述
     * 有一个特殊的五键键盘
     * 上面有A、Ctrl-C、Ctrl-X、Ctrl-V、Ctrl-A
     * A键在屏幕上输出一个字母A
     * Ctrl-C将当前所选的字母复制到剪贴板
     * Ctrl-X将当前选择的字母复制到剪贴板并清空所选择的字母
     * Ctrl-V将当前剪贴板的字母输出到屏幕
     * Ctrl-A选择当前屏幕中所有字母
     * 注意：
     * <p>
     * 剪贴板初始为空
     * 新的内容复制到剪贴板会覆盖原有内容
     * 当屏幕中没有字母时,Ctrl-A无效
     * 当没有选择字母时Ctrl-C、Ctrl-X无效
     * 当有字母被选择时A和Ctrl-V这两个输出功能的键,
     * 会先清空所选的字母再进行输出
     * 给定一系列键盘输入,
     * 输出最终屏幕上字母的数量
     * <p>
     * 输入描述
     * 输入为一行
     * 为简化解析用数字12345分别代替A、Ctrl-C、Ctrl-X、Ctrl-V、Ctrl-A的输入
     * 数字用空格分割
     * <p>
     * 输出描述
     * 输出一个数字为屏幕上字母的总数量
     * <p>
     * 示例一
     * 输入
     * 1 1 1
     * 输出
     * 3
     * 示例二
     * 输入
     * 1 1 5 1 5 2 4 4
     * ¶输出
     * 2
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String nums = scanner.nextLine();
            solution(nums);
        }
    }

    private static void solution(String nums) {
        String[] list = nums.split(" ");
        StringBuilder builder = new StringBuilder();
        String select = "";
        String copy = "";
        for (String op : list) {
            switch (op) {
                case "1":
                    select = empty(builder, select);
                    builder.append('A');
                    break;
                case "2":
                    if (!select.isEmpty()) {
                        copy = select;
                    }
                    break;
                case "3":
                    if (!select.isEmpty()) {
                        copy = select;
                        select = "";
                        builder = new StringBuilder();
                    }
                    break;
                case "4":
                    select = empty(builder, select);
                    builder.append(copy);
                    break;
                case "5":
                    if (builder.length() != 0) {
                        select = builder.toString();
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.print(builder.length());
    }

    private static String empty(StringBuilder builder, String select) {
        if (!select.isEmpty()) {
            builder.replace(0, select.length(), "");
            select = "";
        }
        return select;
    }
}
