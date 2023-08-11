package com.yhf.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test082 {
    /**
     * 题目0082-敏感字段加密
     * 题目描述
     * 给定一个由多个命令字组成的命令字符串；
     * <p>
     * 字符串长度小于等于127字节，只包含大小写字母，数字，下划线和偶数个双引号
     * 命令字之间以一个或多个下划线_进行分割
     * 可以通过两个双引号""来标识包含下划线_的命令字或空命令字(仅包含两个双引号的命令字)，双引号不会在命令字内部出现
     * 请对指定索引的敏感字段进行加密，替换为******(6个*)，
     * 并删除命令字前后多余的下划线_。
     * 如果无法找到指定索引的命令字，输出字符串ERROR
     * <p>
     * 输入描述
     * 输入为两行
     * 第一行为命令字索引K(从0开始)
     * 第二行为命令字符串S
     * <p>
     * 输出描述
     * 输出处理后的命令字符串
     * 如果无法找到指定索引的命令字，输出字符串ERROR
     * <p>
     * 示例一
     * 输入
     * 1
     * password__a12345678_timeout_100
     * 输出
     * password__******_timeout_100
     * 示例二
     * 输入
     * 2
     * aaa_password_"a12_45678"_timeout__100_""_
     * 输出
     * aaa_password_"******"_timeout_100_""
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int K = Integer.parseInt(scanner.nextLine());
            String S = scanner.nextLine();
            String res = solution(K, S);
            System.out.println(res);
        }
    }

    private static String solution(int k, String s) {
        List<String> commands = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char cur = chars[i];
            String command = "";
            if (cur == '"') {
                int rPosQ = s.indexOf('"', i + 1);
                command = s.substring(i, rPosQ + 1);
                i = rPosQ + 1;
            } else {
                int pos_ = s.indexOf('_', i);
                if (pos_ != -1) {
                    command = s.substring(i, pos_);
                    i = pos_;
                } else {
                    command = s.substring(i);
                    i = s.length();
                }
            }
            if (!"".equals(command)) {
                commands.add(command);
            }
        }
        if (k < commands.size()) {
            commands.set(k, "******");
            StringBuilder builder = new StringBuilder();
            commands.forEach(x -> builder.append(x).append("_"));
            return builder.substring(0, builder.length() - 1);
        } else {
            return "ERROR";
        }
    }
}
