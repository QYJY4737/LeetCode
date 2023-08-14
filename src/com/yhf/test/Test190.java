package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test190 {
    /**
     * 题目0190-获取最大软件版本号
     * 题目描述
     * Maven版本号定义，<主版本>.<次版本>.<增量版本>-<里程碑版本>
     * 举例3.1.4-beta 其中，主版本和次版本都是必须的，主版本，次版本，增量版本由多位数字组成，可能包含前导零，里程碑版本由字符串组成。
     * <主版本>.<次版本>.<增量版本>：基于数字比较
     * 里程碑版本：基于字符串比较,采用字典序
     * 比较版本号时，按从左到右的顺序依次比较。基于数字比较， 只需比较忽略任何前导零后的整数值 。
     * 输入2个版本号，输出最大版本号
     * <p>
     * 输入描述
     * 输入2个版本号，换行分割，每个版本的最大长度小于50
     * <p>
     * 输出描述
     * 版本号相同时输出第一个输入版本号
     * <p>
     * 备注
     * 主版本，次版本，增量版本：基于字符串比较,比如
     * <p>
     * 1.5 > 1.4 > 1.3.11 > 1.3.9
     * 里程碑版本：基于字符串比较 比如
     * 1.2-beta-3 > 1.2-beta-11
     * <p>
     * 示例一
     * 输入
     * 2.5.1-C
     * 1.4.2-D
     * 输出
     * 2.5.1-C
     * 说明
     * 主版本，数字2大于1
     * <p>
     * 示例二
     * 输入
     * 1.3.11-S2
     * 1.3.11-S13
     * 输出
     * 1.3.11-S2
     * 说明
     * 里程碑版本，S2大于S13
     * <p>
     * 示例三
     * 输入
     * 1.05.1
     * 1.5.01
     * 输出
     * 1.05.1
     * 说明
     * 版本号相同，输出第一个版本号
     * <p>
     * 示例四
     * 输入
     * 1.5
     * 1.5.0
     * 输出
     * 1.5.0
     * 说明
     * 主次相同，存在增量版本大于不存在
     * <p>
     * 示例五
     * 输入
     * 1.5.1-A
     * 1.5.1-a
     * 输出
     * 1.5.1-a
     * 说明
     * 里程碑版本号，字符串比较a大于A
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String v1 = scanner.nextLine();
            String v2 = scanner.nextLine();
            String res = solution(v1, v2);
            System.out.println(res);
        }
    }

    private static class Version implements Comparable<Version> {
        int fst;
        int scd;
        int inc;
        String mil = "";

        @Override
        public int compareTo(Version o) {
            if (this.fst != o.fst) {
                return this.fst - o.fst;
            } else if (this.scd != o.scd) {
                return this.scd - o.scd;
            } else if (this.inc != o.inc) {
                return this.inc - o.inc;
            } else {
                return this.mil.compareTo(o.mil);
            }
        }

    }

    private static String solution(String v1, String v2) {
        Version ver1 = parse(v1);
        Version ver2 = parse(v2);
        int c = ver1.compareTo(ver2);
        if (c == 0) {
            return v1.length() >= v2.length() ? v1 : v2;
        } else {
            return c > 0 ? v1 : v2;
        }
    }

    private static Version parse(String ver) {
        String[] spl1 = ver.split("\\.");
        Version v = new Version();
        v.fst = Integer.parseInt(spl1[0]);
        v.scd = Integer.parseInt(spl1[1]);
        if (spl1.length > 2) {
            String[] spl2 = spl1[2].split("-");
            v.inc = Integer.parseInt(spl2[0]);
            if (spl2.length > 1) {
                v.mil = spl2[1];
            }
        }
        return v;
    }
}
