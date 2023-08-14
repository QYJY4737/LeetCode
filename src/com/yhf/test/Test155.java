package com.yhf.test;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test155 {
    /**
     * 题目0155-特异性双端队列
     * 题目描述
     * 有一个特异性的双端队列，该队列可以从头部到尾部添加数据，但是只能从头部移除数据。
     * 小A一次执行 2n2n2n 个指令往队列中添加数据和移除数据，
     * 其中 nnn 个指令是添加数据(可能从头部也可以从尾部添加)
     * 依次添加 111 到 nnn , nnn 个指令是移出数据
     * 现在要求移除数据的顺序为 111 到 nnn ，
     * 为了满足最后输出的要求,
     * 小A可以在任何时候调整队列中的数据的顺序
     * 请问,小A最少需要调整几次才能满足移除数据的顺序正好是 111 到 nnn
     *
     * 输入描述
     * 第一行一个整数 nnn ，表示数据范围
     * 接下来有 2n2n2n 行,其中有 nnn 行为添加数据:
     * 指令head add x表示从头部添加数据x
     * tail add x表示从尾部添加数据x
     * 另外 nnn 行为移除数据指令,指令为remove形式,表示移除一个数据
     * 1≤n≤3×1051 \leq n \leq 3 \times 10^51≤n≤3×10
     * 5
     *
     *
     * 输出描述
     * 一个整数，表示小A要调整的最小次数
     *
     * 示例一
     * 输入
     * 3
     * head add 1
     * remove
     * tail add 2
     * head add 3
     * remove
     * remove
     * ¶输出
     * 1
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] commands = new String[n * 2];
            for (int i = 0; i < commands.length; i++) {
                commands[i] = scanner.nextLine();
            }
            int res = solution(commands);
            System.out.print(res);
        }
    }

    private static int solution(String[] commands) {
        int times = 0;
        int in = 0;
        int out = 0;
        LinkedList<Integer> list = new LinkedList<>();

        for (String command : commands) {
            char c = command.charAt(0);
            switch (c) {
                case 'h':
                    list.addFirst(++in);
                    break;
                case 't':
                    list.addLast(++in);
                    break;
                default:
                    if (!list.getFirst().equals(++out)) {
                        times++;
                        list.sort(Integer::compareTo);
                    }
                    list.removeFirst();
                    break;
            }
        }

        return times;
    }
}
