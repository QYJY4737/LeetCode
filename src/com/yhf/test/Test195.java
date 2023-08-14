package com.yhf.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test195 {
    /**
     * 题目0195-最小施肥机能效
     * 题目描述
     * 某农场主管理了一大片果园，fields[i]表示不同果林的面积，单位：（m2m^2m
     * 2
     * ），现在要为所有的果林施肥且必须在 nnn 天之内完成，否则影响收成。
     * 小布是果林的工作人员，他每次选择一片果林进行施肥，且一片果林施肥完后当天不再进行施肥作业。
     * 假设施肥机的能效为 kkk，单位：（m2/daym^2/daym
     * 2
     * /day），请问至少租赁能效 kkk 为多少的施肥机才能确保不影响收成？
     * 如果无法完成施肥任务，则返回-1。
     * <p>
     * 输入描述
     * 第一行输入为m和n，m表示fields中的元素个数，n表示施肥任务必须在n天内（含n天）完成；
     * 第二行输入为fields，fields[i]表示果林i的面积，单位：（m2m^2m
     * 2
     * ）
     * <p>
     * 输出描述
     * 对于每组数据，输出最小施肥机的能效（kkk），无多余空格。
     * <p>
     * 备注
     * 1≤fields.length≤1041 \leq fields.length \leq 10^41≤fields.length≤10
     * 4
     * <p>
     * 1≤n≤1091 \leq n \leq 10^91≤n≤10
     * 9
     * <p>
     * 1≤fields[i]≤1091 \leq fields[i] \leq 10^91≤fields[i]≤10
     * 9
     * <p>
     * <p>
     * 示例一
     * 输入
     * 5 7
     * 5 7 9 15 10
     * 输出
     * 9
     * 说明
     * 当能效kkk为9时，
     * fields[0]需要1天，
     * fields[1]需要1天，
     * fields[2]需要2天，
     * fields[3]需要2天，
     * fields[4]需要2天，
     * 共需要7天，不会影响收成。
     * <p>
     * 示例二
     * 输入
     * 3 1
     * 2 3 4
     * 输出
     * -1
     * 说明
     * 由于一天最多完成一片果林的施肥，无论kkk为多少都至少需要3天才能完成施肥，因此返回-1。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[] fields = new int[m];
            for (int i = 0; i < m; i++) {
                fields[i] = scanner.nextInt();
            }
            int res = solution(m, n, fields);
            System.out.println(res);

        }
    }

    private static int solution(int m, int n, int[] fields) {

        if (m > n) {
            return -1;
        }

        Arrays.sort(fields);
        for (int k = fields[0]; k < fields[fields.length - 1]; k++) {
            int days = 0;
            for (int j : fields) {
                int field = j;
                if (field <= k) {
                    days++;
                } else {
                    while (field > 0) {
                        days++;
                        field -= k;
                    }
                }
                if (days > n) {
                    break;
                }
            }
            if (days == n) {
                return k;
            }
        }
        return -1;
    }
}
