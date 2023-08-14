package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test193 {
    /**
     * 题目0193-投篮大赛
     * 题目描述
     * 你现在是一场采用特殊赛制投篮大赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
     * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
     * 整数 x 表示本回合新获得分数 x
     * + 表示本回合新获得的得分是前两次得分的总和。
     * D 表示本回合新获得的得分是前一次得分的两倍。
     * C 表示本回合没有分数，并且前一次得分无效，将其从记录中移除。
     * 请你返回记录中所有得分的总和。
     * <p>
     * 输入描述
     * 输入为一个字符串数组
     * <p>
     * 输出描述
     * 输出为一个整形数字
     * <p>
     * 备注
     * 1≤ops.length≤10001 \leq ops.length \leq 10001≤ops.length≤1000
     * ops[i] 为 C、D、+，或者一个表示整数的字符串。整数范围是 [−3×104,3×104][-3 \times 10^4, 3 \times 10^4][−3×10
     * 4
     * ,3×10
     * 4
     * ]
     * 需要考虑异常的存在，如有异常情况，请返回-1：
     * 对于 + 操作，题目数据不保证记录此操作时前面总是存在两个有效的分数
     * 对于 C 和 D 操作，题目数据不保证记录此操作时前面存在一个有效的分数
     * 题目输出范围不会超过整型的最大范围，不超过 263−12^{63}-12
     * 63
     * −1
     * 示例一
     * 输入
     * 5 2 C D +
     * 输出
     * 30
     * 说明
     * 5 记录加 5 ，记录现在是 [5]
     * 2 记录加 2 ，记录现在是 [5, 2]
     * C 使前一次得分的记录无效并将其移除，记录现在是 [5].
     * D 记录加 2 * 5 = 10 ，记录现在是 [5, 10].
     * + 记录加 5 + 10 = 15 ，记录现在是 [5, 10, 15].
     * 所有得分的总和 5 + 10 + 15 = 30
     * <p>
     * 示例二
     * 输入
     * 5 -2 4 C D 9 + +
     * 输出
     * 27
     * 说明
     * 5 记录加 5 ，记录现在是 [5]
     * -2 记录加 -2 ，记录现在是 [5, -2]
     * 4 记录加 4 ，记录现在是 [5, -2, 4]
     * C 使前一次得分的记录无效并将其移除，记录现在是 [5, -2]
     * D 记录加 2 * -2 = -4 ，记录现在是 [5, -2, -4]
     * 9 记录加 9 ，记录现在是 [5, -2, -4, 9]
     * + 记录加 -4 + 9 = 5 ，记录现在是 [5, -2, -4, 9, 5]
     * + 记录加 9 + 5 = 14 ，记录现在是 [5, -2, -4, 9, 5, 14]
     * 所有得分的总和 5 + -2 + -4 + 9 + 5 + 14 = 27
     * <p>
     * 示例三
     * 输入
     * 1
     * 输出
     * 1
     * 示例四
     * 输入
     * +
     * 输出
     * -1
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            int res = solution(line);
            System.out.println(res);
        }
    }

    private static int solution(String line) {
        String[] ops = line.split(" ");
        int[] scores = new int[ops.length];
        int p = 0;
        for (String op : ops) {
            switch (op) {
                case "C":
                    if (p > 0) {
                        scores[--p] = 0;
                    }
                    break;
                case "+":
                    if (p > 0) {
                        int sum = 0;
                        for (int j = p - 1; j >= 0 && j >= p - 2; j--) {
                            sum += scores[j];
                        }
                        scores[p] = sum;
                        p++;
                    }
                    break;
                case "D":
                    if (p > 0) {
                        scores[p] = 2 * scores[p - 1];
                        p++;
                    }
                    break;
                default:
                    scores[p++] = Integer.parseInt(op);
                    break;
            }
        }

        if (p == 0) {
            return -1;
        }

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum;
    }
}
