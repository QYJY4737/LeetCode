package com.yhf.test1;

import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test252 {
    /**
     * 题目0252-密钥格式化
     * 题目描述
     * 给定一个非空字符串 SSS，其被 NNN 个-分隔成 N+1N+1N+1 的子串，给定正整数 KKK，要求除第一个子串外，其余的串每 KKK 个用-分隔，并将小写字母转换为大写。
     * <p>
     * 输入描述
     * 正整数 KKK 和-分割的字符串，如：
     * <p>
     * 2
     * 25G3C-abc-d
     * 输出描述
     * 转换后的字符串
     * <p>
     * 示例一
     * 输入
     * 4
     * 5F3Z-2e-9-w
     * 输出
     * 5F3Z-2E9W
     * 说明
     * 字符串 SSS 被分成了两个部分，每部分 4 个字符；
     * 注意，两个额外的破折号需要删掉。
     * <p>
     * 示例二
     * 输入
     * 2
     * 2-5g-3-J
     * 输出
     * 2-5G-3J
     * 说明
     * 字符串 SSS 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
     * <p>
     * ¶思路解析和复杂度分析
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int K = scanner.nextInt();
            String S = scanner.next();
            String res = solution(K, S);

            System.out.println(res);
        }

    }

    private static String solution(int K, String S) {
        S = S.replace("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder(S);

        // Insert "-" from end to start
        for (int i = S.length() - K; i > 0; i -= K) {
            sb.insert(i, "-");
        }
        return sb.toString();
    }
}
