package com.yhf.test1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test257 {
    /**
     * 题目0257-增强的strstr
     * 题目描述
     * C 语言有一个库函数： char *strstr(const char *haystack, const char *needle) ，实现在字符串 haystack 中查找第一次出现字符串 needle 的位置，如果未找到则返回 null。
     * <p>
     * 现要求实现一个strstr的增强函数，可以使用带可选段的字符串来模糊查询，与strstr一样返回首次查找到的字符串位置。
     * <p>
     * 可选段使用 [] 标识，表示该位置是可选段中任意一个字符即可满足匹配条件。比如 a[bc] 表示可以匹配ab或ac。
     * <p>
     * 注意目标字符串中可选段可能出现多次。
     * <p>
     * 输入描述
     * 与strstr函数一样，输入参数是两个字符串指针，分别是源字符串和目标字符串。
     * <p>
     * 输出描述
     * 与strstr函数不同，返回的是源字符串中，匹配子字符串相对于源字符串地址的偏移（从0开始算），如果没有匹配返回-1。
     * <p>
     * 补充说明：源字符串中必定不包含[]；目标字符串中[]必定成对出现，且不会出现嵌套。
     * <p>
     * 输入的字符串长度在[1,100]之间。
     * <p>
     * 示例一
     * 输入
     * abcd
     * b[cd]
     * 输出
     * 1
     * 说明
     * 相当于是在源字符串中查找bc或者bd，bc子字符串相对于abcd的偏移是1
     * <p>
     * 思路解析和复杂度分析
     * 题解思路：
     * 这道题的基本思路是根据提供的目标字符串，生成一个匹配模式，然后在源字符串中查找这个匹配模式。
     * <p>
     * 输入的目标字符串可能包含带有可选字符的段，我们可以将其视为正则表达式中的字符类。例如，[abc] 在正则表达式中表示“任意一个a、b或c”。这样，我们就可以将目标字符串直接视为一个正则表达式，并使用正则表达式匹配来寻找源字符串中的匹配项。
     * <p>
     * 匹配的结果可能有多个，但我们只需要找到第一个匹配项。这可以通过获取匹配项在源字符串中的起始索引来实现。如果没有找到匹配项，我们返回-1。
     * <p>
     * 算法的复杂度分析
     * 此算法的时间复杂度和空间复杂度主要依赖于正则表达式匹配的实现。大多数正则表达式匹配算法的时间复杂度都是线性的，即O(n)，其中n是源字符串的长度。这是因为算法需要扫描源字符串中的每个字符来查找匹配项。
     * <p>
     * 空间复杂度也通常是线性的，即O(m)，其中m是目标字符串的长度。这是因为在进行正则表达式匹配时，可能需要存储与目标字符串长度相等的中间结果。
     * <p>
     * 这里的复杂度分析是基于一般情况下的正则表达式匹配实现。实际的复杂度可能会根据具体实现和输入的特性（例如源字符串和目标字符串的长度，目标字符串的结构等）有所不同。特别地，如果目标字符串包含大量的可选字符段，可能会导致正则表达式匹配的时间复杂度增加。
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String src = scanner.nextLine();
        String tar = scanner.nextLine();
        System.out.println(solution(src, tar));
    }

    public static int solution(String src, String tar) {
        Matcher matcher = Pattern.compile(tar).matcher(src);
        if (matcher.find()) {
            return src.indexOf(matcher.group());
        } else {
            return -1;
        }
    }
}
