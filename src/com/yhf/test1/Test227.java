package com.yhf.test1;

import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test227 {
    /**
     * 题目0227-递增字符串
     * 题目描述
     * 定义字符串完全由 A 和 B组成，当然也可以全是A或全是B。
     * 如果字符串从前往后都是以字典序排列的，那么我们称之为严格递增字符串。
     * 给出一个字符串 s，允许修改字符串中的任意字符，即可以将任何的A修改成B，也可以将任何的B修改成A，求可以使s满足严格递增的最小修改次数。
     * 0 < s的长度 < 100000。
     * <p>
     * 输入描述
     * 输入一个字符串： AABBA
     * <p>
     * 输出描述
     * 输出：1
     * 修改最后一位得到AABBB。
     * <p>
     * 示例一
     * 输入
     * AABBA
     * 输出
     * 1
     * 思路解析和复杂度分析
     * 解题思路：
     * 遍历整个字符串s，同时统计A和B的数量。
     * 对于每个字符，如果是A，则增加A的计数；如果是B，则增加B的计数。
     * 在遍历过程中，计算使得当前字符串变成严格递增的最小修改次数。我们可以维护一个变量ans来记录当前的最小修改次数。对于每个字符，我们有两种选择：要么修改这个字符，要么不修改。这两种选择分别对应的修改次数为：当前字符为B时，ans加1（修改成A）；不修改当前字符时，如果当前字符为A，我们需要保证其前面的所有B都被修改成A，所以此时的修改次数为cntA（已经统计的A的数量）。对于这两种情况，我们取较小的一个作为当前的最小修改次数。
     * 最后，输出ans作为结果。
     * 复杂度分析：
     * 时间复杂度：由于我们只对字符串s进行了一次遍历，所以时间复杂度为O(n)，其中n为字符串长度。
     * 空间复杂度：我们只使用了常数个额外变量，因此空间复杂度为O(1)。
     * 这个方法的核心思想是在遍历字符串过程中维护最小修改次数，从而在遍历结束后得到整个字符串所需的最小修改次数。这种方法有效地利用了递增性质，将问题转化为了一个简单的计数问题。同时，由于只需要遍历一次字符串，时间复杂度较低，适用于较长的字符串。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.next();
            System.out.println(solution(line));
        }
    }

    public static int solution(String str) {
        int n = str.length();
        int A = str.replaceAll("B", "").length();

        int dp = 0;
        if (str.charAt(0) == 'A') dp = 1;
        int ans = check(0, dp, A - dp);

        for (int i = 1; i < n; i++) {
            if (str.charAt(i) == 'A') dp += 1;
            ans = Math.min(ans, check(i, dp, A - dp));
        }

        return ans;
    }

    public static int check(int brandIdx, int brand_LM_A, int brand_R_A) {
        return brandIdx + 1 - brand_LM_A + brand_R_A;
    }
}
