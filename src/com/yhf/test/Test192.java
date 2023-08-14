package com.yhf.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test192 {
    /**
     * 题目0192-Excel单元格数值统计
     * 题目描述
     * Excel工作表中对选定区域的数值进行统计的功能非常实用。
     * 仿照Excel的这个功能，请对给定表格中选中区域中的单元格进行求和统计，并输出统计结果。
     * 为简化计算，假设当前输入中每个单元格内容仅为数字或公式两种。
     * 如果为数字，则是一个非负整数，形如3、77
     * 如果为公式，则固定以=开头，且仅包含下面三种情况：
     * 等于某单元格的值，例如=B12
     * 两个单元格的双目运算（仅为+或-），形如=C1-C2、C3+B2
     * 单元格和数字的双目运算（仅为+或-），形如=B1+1、100-B2
     * 注意：
     * 公式内容都是合法的，例如不存在,=C+1、=C1-C2+B3，=5、=3+5
     * 不存在循环引用，例如A1=B1+C1、C1=A1+B2
     * 内容中不存在空格、括号
     * <p>
     * 输入描述
     * 第一行两个整数 rowsrowsrows 和 colscolscols,表示给定表格区域的行数和列数，1≤rows≤20，1≤cols≤261 \leq rows \leq 20，1 \leq cols \leq 261≤rows≤20，1≤cols≤26。
     * 接下来 rowsrowsrows 行，每行 colscolscols 个以空格分隔的字符串，表示给定表格 valuesvaluesvalues 的单元格内容。
     * <p>
     * 最后一行输入的字符串，表示给定的选中区域，形如A1:C2。
     * <p>
     * 输出描述
     * 一个整数，表示给定选中区域各单元格中数字的累加总和，范围 -2,147,483,648 ~ 2,147,483,647
     * <p>
     * 备注
     * 表格的行号1 ~ 20，列号A ~ Z,例如单元格B3对应values[2][1]。
     * 输入的单元格内容（含公式）中的数字均为十进制，值范围[0,100]。
     * 选中区域：冒号左侧单元格表示选中区域的左上角，右侧表示右下角，如可以为B2:C10、B2:B5、B2:Y2、B2:B2,无类似C2:B2、C2:A1的输入。
     * <p>
     * 思路
     * 用正则匹配并提取公式内容
     * 递归求解表中所有数据的真实值
     * 按照范围遍历求和
     * 示例一
     * 输入
     * 5 3
     * 10 12 =C5
     * 15 5 6
     * 7 8 =3+C2
     * 6 =B2-A1 =C2
     * 7 5 3
     * B2:C4
     * 输出
     * 29
     * 示例二
     * 输入
     * 1 3
     * 1 =A1+C1 3
     * A1:C1
     * 输出
     * 8
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            scanner.nextLine();
            String[][] sheet = new String[rows][cols];
            for (int i = 0; i < rows; i++) {
                sheet[i] = scanner.nextLine().split(" ");
            }
            String range = scanner.nextLine();
            int res = solution(rows, cols, sheet, range);
            System.out.println(res);
        }
    }

    private static final Pattern pattern1 = Pattern.compile("([A-Z])?([0-9]+)([+\\-])([A-Z])?([0-9]+)");
    private static final Pattern pattern2 = Pattern.compile("([A-Z])?([0-9]+)");
    private static final Pattern pattern3 = Pattern.compile("([A-Z])?([0-9]+)(:)([A-Z])?([0-9]+)");

    private static int solution(int rows, int cols, String[][] sheet, String range) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                String value = sheet[r][c];
                if (value.startsWith("=")) {
                    sheet[r][c] = evaluate(value, sheet);
                }
            }
        }

        Matcher matcher = pattern3.matcher(range);
        if (matcher.find()) {
            int cs = matcher.group(1).charAt(0) - 'A';
            int rs = Integer.parseInt(matcher.group(2)) - 1;
            int ce = matcher.group(4).charAt(0) - 'A';
            int re = Integer.parseInt(matcher.group(5)) - 1;
            int sum = 0;
            for (int r = rs; r <= re; r++) {
                for (int c = cs; c <= ce; c++) {
                    sum += Integer.parseInt(sheet[r][c]);
                }
            }
            return sum;
        }

        return 0;
    }

    private static String evaluate(String value, String[][] sheet) {
        Matcher matcher1 = pattern1.matcher(value);
        Matcher matcher2 = pattern2.matcher(value);
        if (matcher1.find()) {
            String c1 = matcher1.group(1);
            String r1 = matcher1.group(2);
            String sign = matcher1.group(3);
            String c2 = matcher1.group(4);
            String r2 = matcher1.group(5);
            String v1, v2;
            if (c1 != null) {
                v1 = sheet[Integer.parseInt(r1) - 1][c1.charAt(0) - 'A'];
                if (v1.startsWith("=")) {
                    v1 = evaluate(v1, sheet);
                }
            } else {
                v1 = r1;
            }

            if (c2 != null) {
                v2 = sheet[Integer.parseInt(r2) - 1][c2.charAt(0) - 'A'];
                if (v2.startsWith("=")) {
                    v2 = evaluate(v2, sheet);
                }
            } else {
                v2 = r2;
            }
            int d1 = Integer.parseInt(v1);
            int d2 = Integer.parseInt(v2);
            if (sign.equals("+")) {
                return (d1 + d2) + "";
            } else {
                return (d1 - d2) + "";
            }
        } else if (matcher2.find()) {
            String c1 = matcher2.group(1);
            String r1 = matcher2.group(2);
            String v;
            v = sheet[Integer.parseInt(r1) - 1][c1.charAt(0) - 'A'];
            if (v.startsWith("=")) {
                v = evaluate(v, sheet);
            }
            return v;
        }
        return "0";
    }
}
