package com.yhf.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test074 {
    /**
     * 题目0074-时间格式化
     * 题目描述
     * 运维工程师采集到某产品线网运行一天产生的日志n条
     * 现需根据日志时间先后顺序对日志进行排序
     * 日志时间格式为H:M:S.N
     * H表示小时(0~23)
     * M表示分钟(0~59)
     * S表示秒(0~59)
     * N表示毫秒(0~999)
     * 时间可能并没有补全
     * 也就是说
     * 01:01:01.001也可能表示为1:1:1.1
     * <p>
     * 输入描述
     * 第一行输入一个整数n表示日志条数
     * 1 <= n <= 100000
     * 接下来n行输入n个时间
     * <p>
     * 输出描述
     * 按时间升序排序之后的时间
     * 如果有两个时间表示的时间相同
     * 则保持输入顺序
     * <p>
     * 示例一
     * 输入
     * 2
     * 01:41:8.9
     * 1:1:09.211
     * 输出
     * 1:1:09.211
     * 01:41:8.9
     * 示例二
     * 输入
     * 3
     * 23:41:08.023
     * 1:1:09.211
     * 08:01:22.0
     * 输出
     * 1:1:09.211
     * 08:01:22.0
     * 23:41:08.023
     * 示例三
     * 输入
     * 2
     * 22:41:08.023
     * 22:41:08.23
     * 输出
     * 22:41:08.023
     * 22:41:08.23
     * 说明
     * 时间相同保持输入顺序
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] times = new String[n];
            for (int i = 0; i < n; i++) {
                times[i] = scanner.nextLine();
            }
            solution(times);
        }
    }

    private static void solution(String[] times) {
        Arrays.stream(times).sorted(Comparator.comparingLong(Test074::getTime))
                .forEach(System.out::println);
    }

    private static long getTime(String str) {
        String[] t1 = str.split(":");
        String[] t2 = t1[2].split("\\.");
        int h = Integer.parseInt(t1[0]) * 60 * 60 * 1000;
        int m = Integer.parseInt(t1[1]) * 60 * 1000;
        int s = Integer.parseInt(t2[0]) * 1000;
        int n = Integer.parseInt(t2[1]);
        return h + m + s + n;
    }
}
