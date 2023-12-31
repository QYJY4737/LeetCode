package com.yhf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test161 {
    /**
     * 题目0161-匿名信
     * 题目描述
     * 电视剧《分界线》里面有一个片段，男主为了向警察透露案件细节，且不暴露自己，于是将报刊上的字减下来，剪拼成匿名信。
     * 现在又一名举报人，希望借鉴这种手段，使用英文报刊完成举报操作。
     * 但为了增加文章的混淆度，只需满足每个单词中字母数量一致即可，不关注每个字母的顺序。
     * 解释：单词on允许通过单词no进行替代。
     * 报纸代表newspaper,匿名信代表anonymousLetter,
     * 求报纸内容是否可以拼成匿名信。
     * <p>
     * 输入描述
     * 输入描述
     * 第一行输入newspaper内容，包括1-N个字符串，用空格分开
     * 第二行输入anonymousLetter内容，包括1-N个字符串，用空格分开
     * <p>
     * newspaper和anonymousLetter的字符串由小写英文字母组成，
     * 且每个字母只能使用一次
     * newspaper内容中的每个字符串字母顺序可以任意调整，
     * 但必须保证字符串的完整性（每个字符串不能有多余字母）
     * 1 < N < 100,
     * 1 <= newspaper.length,anonymousLetter.length <= 10^4
     * 输出描述
     * 如果报纸可以拼成匿名信返回true，否则返回false
     * <p>
     * 示例一
     * 输入
     * ab cd
     * ab
     * 输出
     * true
     * 示例二
     * 输入
     * ab ef
     * aef
     * 输出
     * false
     * 示例三
     * 输入
     * ab bcd ef
     * cbd fe
     * 输出
     * true
     * 示例四
     * 输入
     * ab bcd ef
     * cd fe
     * 输出
     * false
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String newspaper = scanner.nextLine();
            String anonymousLetter = scanner.nextLine();
            boolean res = solution(newspaper, anonymousLetter);
            System.out.println(res);
        }
    }

    private static boolean solution(String newspaper, String anonymousLetter) {
        List<String> newspaperList = sort(newspaper);
        List<String> anonymousLetterList = sort(anonymousLetter);

        for (String s : anonymousLetterList) {
            if (!newspaperList.contains(s)) {
                return false;
            }
        }
        return true;
    }

    private static List<String> sort(String newspaper) {
        List<String> strings = new ArrayList<>();
        String[] split = newspaper.split(" ");
        for (String s : split) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            strings.add(new String(chars));
        }
        return strings;
    }
}
