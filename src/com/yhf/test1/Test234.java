package com.yhf.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test234 {
    /**
     * 题目0234-字符串重新排列
     * 题目描述
     * 给定一个字符串s，s包括以空格分隔的若干个单词，请对s进行如下处理后输出：
     * <p>
     * 单词内部调整：对每个单词字母重新按字典序排序
     * 单词间顺序调整：
     * 统计每个单词出现的次数，并按次数降序排列
     * 次数相同，按单词长度升序排列
     * 次数和单词长度均相同，按字典升序排列
     * 请输出处理后的字符串，每个单词以一个空格分隔。
     * <p>
     * 输入描述
     * 一行字符串，每个字符取值范围：[a-zA-z0-9]以及空格，字符串长度范围：[1，1000]
     * <p>
     * 输出描述
     * 输出处理后的字符串，每个单词以一个空格分隔。
     * <p>
     * 示例一
     * 输入
     * This is an apple
     * 输出
     * an is This aelpp
     * 示例二
     * 输入
     * My sister is in the house not in the yard
     * 输出
     * in in eht eht My is not adry ehosu eirsst
     * 思路解析和复杂度分析
     * 本题要求对一个给定的字符串进行两个方面的处理：单词内部字母顺序调整和单词间顺序调整。以下分别解释各语言实现的思路和复杂度分析。
     * <p>
     * 思路解析
     * 首先，对于输入的字符串，我们需要将其拆分成单词。大多数语言都有内置的字符串分割方法，如Python的split()、Java的split()、JavaScript的split()、C++的istringstream和Go的strings.Split()。
     * 接下来，我们需要统计每个单词的出现次数。这可以使用哈希表（例如Python的字典，Java的HashMap，JavaScript的Map，C++的unordered_map，Go的map）实现。同时，我们使用一个数组或列表来存储每个独特单词的信息，如排序后的单词、出现次数和单词长度。
     * 在统计单词信息的过程中，我们可以根据需求对单词内部的字母进行排序。大多数语言都有内置的排序方法，如Python的sorted()、Java的Arrays.sort()、JavaScript的Array.prototype.sort()、C++的std::sort()和Go的sort.Slice()。
     * 单词统计完成后，我们需要根据题目要求对单词数组进行排序。这里我们可以使用语言提供的排序方法，如Python的sort()、Java的Collections.sort()、JavaScript的Array.prototype.sort()、C++的std::sort()和Go的sort.Sort()。我们需要自定义一个比较函数来实现题目要求的排序规则。
     * 最后，我们遍历已排序的单词数组，并根据每个单词的出现次数构建一个新的单词数组。最后将新的单词数组连接为一个字符串输出。
     * 复杂度分析
     * 时间复杂度：
     * 字符串分割：O(n)，n为字符串的长度。
     * 单词排序：O(m * k * log(k))，m为单词的平均长度，k为单词的数量。
     * 统计和排序单词信息：O(k * log(k))。
     * 构建输出字符串：O(n)。
     * 综上，总时间复杂度为O(n + m * k * log(k) + k * log(k))。
     * 空间复杂度：
     * 输入字符串：O(n)。
     * 单词数组：O(k)。
     * 哈希表：O(k)。
     * 综上，总空间复杂度为O(n + 2k)。
     * 在本题中，我们使用了哈希表来统计单词的出现次数，这使得算法具有较高的时空效率。对于大多数实际应用场景，这种实现能够在可接受的时间范围内给出正确的结果。
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        String[] tokens = s.split(" ");
        HashMap<String, Word> wordMap = new HashMap<>();
        ArrayList<Word> words = new ArrayList<>();

        for (String token : tokens) {
            char[] tokenChars = token.toCharArray();
            Arrays.sort(tokenChars);
            String sortedToken = new String(tokenChars);

            if (!wordMap.containsKey(sortedToken)) {
                Word newWord = new Word(sortedToken, 1, token.length());
                wordMap.put(sortedToken, newWord);
                words.add(newWord);
            } else {
                wordMap.get(sortedToken).count++;
            }
        }

        words.sort((a, b) -> {
            if (a.count != b.count) {
                return b.count - a.count;
            }
            if (a.length != b.length) {
                return a.length - b.length;
            }
            return a.word.compareTo(b.word);
        });

        StringBuilder result = new StringBuilder();
        for (Word word : words) {
            for (int j = 0; j < word.count; j++) {
                result.append(word.word);
                if (words.indexOf(word) < words.size() - 1 || j < word.count - 1) {
                    result.append(" ");
                }
            }
        }

        System.out.println(result.toString());
    }
}

class Word {
    String word;
    int count;
    int length;

    public Word(String word, int count, int length) {
        this.word = word;
        this.count = count;
        this.length = length;
    }
}
