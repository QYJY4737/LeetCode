package com.yhf.test1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test213 {
    /**
     * 题目0213-机房布局
     * 题目描述
     * 小明正在规划一个大型数据中心机房，为了使得机柜上的机器都能正常满负荷工作，需要确保在每个机柜边上至少要有一个电箱。
     * 为了简化题目，假设这个机房是一整排，MMM 表示机柜，III 表示间隔，请你返回这整排机柜，至少需要多少个电箱。 如果无解请返回 −1-1−1 。
     * <p>
     * 输入描述
     * cabinets = "MIIM"
     * <p>
     * 其中 MMM 表示机柜，III 表示间隔
     * <p>
     * 输出描述
     * 2
     * 表示至少需要2个电箱
     * <p>
     * 备注
     * 1<= strlen(cabinets) <= 10000
     * <p>
     * 其中 cabinets[i] = ‘M’ 或者 'I'
     * <p>
     * 示例一
     * 输入
     * MIIM
     * 输出
     * 2
     * 示例二
     * 输入
     * MIM
     * 输出
     * 1
     * 示例三
     * 输入
     * M
     * 输出
     * -1
     * 示例四
     * 输入
     * MMM
     * 输出
     * -1
     * 示例五
     * 输入
     * I
     * 输出
     * 0
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.next();
            System.out.println(solution(line));
        }
    }

    public static int solution(String line) {
        int n = line.length();
        LinkedList<Integer[]> stack = new LinkedList<>();
        boolean stick = false;

        for (int i = 0; i < n; i++) {
            if (line.charAt(i) == 'M') {
                boolean left = i - 1 < 0 || line.charAt(i - 1) == 'M';
                boolean right = i + 1 >= n || line.charAt(i + 1) == 'M';
                if (left && right) return -1;

                Integer[] range = {Math.max(0, i - 1), Math.min(n - 1, i + 1)};

                if (stack.size() > 0 && !stick) {
                    int e1 = stack.getLast()[1];
                    int s2 = range[0];

                    if (e1 == s2) {
                        stack.removeLast();
                        stick = true;
                    }
                } else {
                    stick = false;
                }
                stack.addLast(range);
            }
        }

        return stack.size();
    }
}
