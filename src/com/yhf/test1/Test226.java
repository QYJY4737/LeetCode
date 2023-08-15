package com.yhf.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test226 {
    /**
     * 题目0226-寻找相似单词
     * 题目描述
     * 给定一个可存储若干单词的字典，找出指定单词的所有相似单词，并且按照单词名称从小到大排序输出。单词仅包括字母，但可能大小写并存（大写不一定只出现在首字母）。
     * 相似单词说明：给定一个单词X，如果通过任意交换单词中字母的位置得到不同的单词Y，那么定义Y是X的相似单词，如abc、bca即为相似单词（大小写是不同的字母，如a和A算两个不同字母）。
     * 字典序排序： 大写字母 < 小写字母。同样大小写的字母，遵循26字母顺序大小关系。即A < B < C < ... < X < Y < Z < a < b < c < ... < x < y < z. 如 Bac < aBc < acB < cBa.
     * <p>
     * 输入描述
     * 第一行为给定的单词个数 NNN（ NNN 为非负整数）
     * <p>
     * 从第二行到地 N+1N+1N+1 行是具体的单词（每行一个单词）
     * <p>
     * 最后一行是指定的待检测单词（用于检测上面给定的单词中哪些是与该指定单词是相似单词，该单词可以不是上面给定的单词）
     * <p>
     * 输出描述
     * 从给定的单词组中，找出指定单词的相似单词，并且按照从小到大字典序排列输出，中间以空格隔开
     * <p>
     * 如果不存在，则输出null（字符串null）
     * <p>
     * 示例一
     * 输入
     * 4
     * abc
     * dasd
     * tad
     * bca
     * abc
     * 输出
     * abc bca
     * 说明
     * 在给定的输入中，与abc是兄弟单词的是abc bca，且输出按照字典序大小排序，输出的所有单词以空格隔开
     * <p>
     * 示例二
     * 输入
     * 4
     * abc
     * dasd
     * tad
     * bca
     * abd
     * 输出
     * null
     * 说明
     * 给定单词组中，没有与给定单词abd是兄弟单词，输出为null（字符串null）
     * <p>
     * 思路解析和复杂度分析
     * 在这道题目中，我们需要找出给定字典中与指定单词相似的单词。相似的定义是，可以通过交换两个单词中的字母位置来得到。题目要求输出的相似单词按照字典序从小到大排序，如果没有找到任何相似单词，则输出"null"。
     * <p>
     * 思路解析：
     * 从输入中读取给定的单词数量n以及具体的单词，将所有单词存储在一个列表中。
     * 对单词列表进行排序，这样我们可以保证输出的相似单词按照字典序从小到大排列。
     * 读取待检测的目标单词。
     * 遍历已排序的单词列表，对于每个单词，检查它是否与目标单词相似。如果相似，则将其添加到结果列表中。
     * 输出结果列表中的单词。如果结果列表为空，输出"null"。
     * 为了检查两个单词是否相似，我们可以使用一个计数数组来计算每个字符在两个单词中出现的次数。如果所有字符的计数在两个单词中相等，则这两个单词是相似的。
     * <p>
     * 复杂度分析：
     * 时间复杂度：排序单词列表的时间复杂度为O(nlogn)，其中n为单词数量。遍历单词列表并检查每个单词与目标单词是否相似的时间复杂度为O(n * m)，其中m为单词的平均长度。因此，总时间复杂度为O(nlogn + n * m)。
     * 空间复杂度：我们需要额外的空间来存储单词列表和计数数组。单词列表的空间复杂度为O(n)，计数数组的空间复杂度为O(1)（因为有固定的52个字符）。因此，总空间复杂度为O(n)。
     * 总结，这道题目主要考察了字符串操作、排序以及遍历的基本技巧。我们需要设计一个高效的算法来检查两个单词是否相似，并利用排序和遍历来找出给定字典中的相似单词。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();

            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = scanner.next();
            }

            String target = scanner.next();

            System.out.println(solution(words, target));
        }

    }

    public static String solution(String[] words, String target) {
        String sorted_target = sort(target);

        ArrayList<String> ans = new ArrayList<>();
        for (String word : words) {
            String sorted_word = sort(word);

            if (sorted_target.equals(sorted_word)) {
                ans.add(word);
            }
        }

        if (ans.size() > 0) {
            ans.sort(String::compareTo);

            StringJoiner sj = new StringJoiner(" ");
            for (String an : ans) sj.add(an);
            return sj.toString();
        } else {
            return "null";
        }
    }

    public static String sort(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
