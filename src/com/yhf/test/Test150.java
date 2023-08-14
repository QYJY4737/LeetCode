package com.yhf.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test150 {
    /**
     * 题目0150-最短木板长度
     * 题目描述
     * 小明有nnn块木板，第i(1≤i≤n)i(1 \leq i \leq n)i(1≤i≤n)块木板长度为aia_ia
     * i
     * ​
     *  。
     * 小明买了一块长度为mmm的木料，这块木料可以切割成任意块，
     * 拼接到已有的木板上，用来加长木板。
     * 小明想让最短的木板尽量长。
     * 请问小明加长木板后，最短木板的长度可以为多少？
     *
     * 输入描述
     * 输入的第一行包含两个正整数，n(1≤n≤103)n(1 \leq n \leq 10^3)n(1≤n≤10
     * 3
     *  ),m(1≤m≤106)m(1 \leq m \leq 10^6)m(1≤m≤10
     * 6
     *  )
     * nnn表示木板数，mmm表示木板长度。
     * 输入的第二行包含nnn个正整数，a1,a2,...an(1≤ai≤106)a_1,a_2,...a_n (1 \leq ai \leq 10^6)a
     * 1
     * ​
     *  ,a
     * 2
     * ​
     *  ,...a
     * n
     * ​
     *  (1≤ai≤10
     * 6
     *  )。
     *
     * 输出描述
     * 输出的唯一一行包含一个正整数，表示加长木板后，最短木板的长度最大可以为多少？
     *
     * 示例一
     * 输入
     * 5 3
     * 4 5 3 5 5
     * 输出
     * 5
     * 说明
     * 给第1块木板长度增加1，给第3块木板长度增加2后，
     * 这5块木板长度变为[5,5,5,5,5]，最短的木板的长度最大为5。
     *
     * 示例二
     * 输入
     * 5 2
     * 4 5 3 5 5
     * 输出
     * 4
     * 说明
     * 给第3块木板长度增加1后，
     * 这5块木板长度变为[4,5,4,5,5]，剩余的木料长度为1。
     * 此时剩余木料无论给哪块木板加长，最短木料的长度都为4。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] lens = new int[n];
            for (int i = 0; i < lens.length; i++) {
                lens[i] = scanner.nextInt();
            }
            int maxLen = solution(n, m, lens);
            System.out.print(maxLen);
        }
    }

    private static int solution(int n, int m, int[] lens) {
        int maxLen = 0;
        Arrays.sort(lens);
        for (int i = 0; i < m; i++) {
            lens[0] = lens[0] + 1;
            Arrays.sort(lens);
            maxLen = Math.max(maxLen, lens[0]);
        }
        return maxLen;
    }
}
