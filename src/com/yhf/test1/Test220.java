package com.yhf.test1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test220 {
    /**
     * 题目0220-知识图谱新词挖掘1
     * 题目描述
     * 小华负责公司知识图谱产品，现在要通过新词挖掘完善知识图谱。
     * 新词挖掘：给出一个待挖掘文本内容字符串content和一个词的字符串word，找到content中所有word的新词。
     * 新词：使用词word的字符排列形成的字符串。
     * 请帮小华实现新词挖掘，返回发现的新词的数量。
     * <p>
     * 输入描述
     * 第一行输入为待挖掘的文本内容content；
     * 第二行输入为词word；
     * <p>
     * 输出描述
     * 在中找到的所有word的新词的数量。
     * <p>
     * 备注
     * 0≤content.length≤100000000 \leq content.length \leq 100000000≤content.length≤10000000；
     * 1≤word.length≤20001 \leq word.length \leq 20001≤word.length≤2000
     * <p>
     * 示例一
     * 输入
     * qweebaewqd
     * qwe
     * 输出
     * 2
     * 说明
     * 起始索引等于 0 的子串是 qwe, 它是 word的新词。
     * 起始索引等于 6 的子串是 ewq, 它是 word的新词。
     * <p>
     * 示例二
     * 输入
     * abab
     * ab
     * 输出
     * 3
     * 说明
     * 起始索引等于 0 的子串是 ab, 它是 word 的新词。
     * 起始索引等于 1 的子串是 ba, 它是 word 的新词。
     * 起始索引等于 2 的子串是 ab, 它是 word 的新词。
     * <p>
     * 思路解析和复杂度分析
     * 本题的目标是在给定的文本内容中找到目标词的所有新词。新词是指由目标词中的字符重新排列形成的字符串。为了解决这个问题，我们可以遍历文本内容中的所有长度与目标词长度相同的子串，并判断这些子串是否是目标词的新词。以下是解题思路和算法复杂度分析。
     * <p>
     * 思路：
     * 首先，我们需要计算目标词的每个字符的频率。为此，我们可以遍历目标词的每个字符，然后在一个长度为26的数组中记录每个字符的出现次数。这样，我们可以根据字母的ASCII码计算出该字母在数组中的索引。
     * 然后，我们需要遍历文本内容中的所有长度与目标词长度相同的子串。为了实现这一点，我们可以使用一个简单的for循环，从0开始，直到文本内容的长度减去目标词的长度。
     * 对于每个子串，我们需要判断它是否是目标词的新词。为此，我们可以计算子串中每个字符的频率，然后将其与目标词的字符频率进行比较。如果两者相同，则子串是目标词的新词。
     * 如果子串是目标词的新词，我们可以将新词的数量加1。
     * 最后，返回新词的总数。
     * 复杂度分析
     * 时间复杂度：我们需要遍历文本内容中的所有长度与目标词长度相同的子串，这个过程的时间复杂度为 O(n-m+1)，其中 n 是文本内容的长度，m 是目标词的长度。对于每个子串，我们需要计算其字符频率并与目标词的字符频率进行比较，这个过程的时间复杂度为 O(m)。因此，总的时间复杂度为 O((n-m+1) * m)。
     * <p>
     * 空间复杂度
     * 我们需要一个长度为26的数组来存储目标词的字符频率和子串的字符频率。因此，空间复杂度为 O(1)，因为这个数组的大小是固定的。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            String content = scanner.next();
            String word = scanner.next();

            System.out.println(solution(content, word));
        }
    }

    public static int solution(String content, String word) {
        if (content.length() < word.length()) {
            return 0;
        }

        int ans = 0;

        int total = word.length();

        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < word.length(); i++) {
            Character c = content.charAt(i);
            if (count.containsKey(c)) {
                if (count.get(c) > 0) {
                    total--;
                }
                count.put(c, count.get(c) - 1);
            }
        }

        if (total == 0) ans++;

        int maxI = content.length() - word.length();
        for (int i = 1; i <= maxI; i++) {
            Character remove_c = content.charAt(i - 1);
            Character add_c = content.charAt(i + word.length() - 1);

            if (count.containsKey(remove_c)) {
                if (count.get(remove_c) >= 0) {
                    total++;
                }
                count.put(remove_c, count.get(remove_c) + 1);
            }

            if (count.containsKey(add_c)) {
                if (count.get(add_c) > 0) {
                    total--;
                }
                count.put(add_c, count.get(add_c) - 1);
            }

            if (total == 0) ans++;
        }
        return ans;
    }
}
