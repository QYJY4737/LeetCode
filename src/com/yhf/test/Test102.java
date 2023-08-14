package com.yhf.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test102 {
    /**
     * 题目0021-磁盘容量
     * 题目描述
     * 磁盘的容量单位常用的有M、G、T
     * 他们之间的换算关系为1T =1024G，1G=1024M
     * 现在给定n块磁盘的容量，请对他们按从小到大的顺序进行稳定排序
     * 例如给定5块盘的容量
     * 5
     * 1T
     * 20M
     * 3G
     * 10G6T
     * 3M12G9M
     * 排序后的结果为
     * 20M
     * 3G
     * 3M12G9M
     * 1T
     * 10G6T
     * 注意单位可以重复出现
     * 上述3M12G9M表示的容量即为3M12G9M和12M12G相等
     * <p>
     * 输入描述
     * 输入第一行包含一个整数n，2 <= n<= 100，表示磁盘的个数。
     * 接下来的n行，每行一个字符串，2 < 长度 < 30，表示磁盘的容量，
     * 由一个或多个格式为MV的子串组成，其中M表示容量大小，V表示容量单位，
     * 例如20M、1T。
     * 磁盘容量的范围1 ~ 1024的正整数，单位M、G、T。
     * <p>
     * 输出描述
     * 输出n行
     * 表示n块磁盘容量排序后的结果
     * <p>
     * 示例一
     * 输入
     * 3
     * 1G
     * 2G
     * 1024M
     * 输出
     * 1G
     * 1024M
     * 2G
     * 说明
     * 稳定排序要求相等值保留原来位置
     * <p>
     * 示例二
     * 输入
     * 3
     * 2G4M
     * 3M2G
     * 1T
     * 输出
     * 3M2G
     * 2G4M
     * 1T
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] capacities = new String[n];
            for (int i = 0; i < n; i++) {
                capacities[i] = scanner.nextLine();
            }
            solution(capacities);
        }
    }

    private static void solution(String[] capacities) {
        Arrays.stream(capacities)
                .sorted(Comparator.comparingInt(Test102::convert))
                .forEach(System.out::println);
    }

    private static int convert(String capacity) {
        int size = 0;
        String upper = capacity.toUpperCase();
        String[] split = upper.split("[A-Z]");
        int unitPos = 0;
        for (String s : split) {
            unitPos += s.length();
            int num = Integer.parseInt(s);
            char unit = upper.charAt(unitPos);
            switch (unit) {
                case 'M':
                    size += num;
                    break;
                case 'G':
                    size += num * 1024;
                    break;
                case 'T':
                    size += num * 1024 * 1024;
                    break;
                default:
                    break;
            }
            unitPos++;
        }
        return size;
    }
}
