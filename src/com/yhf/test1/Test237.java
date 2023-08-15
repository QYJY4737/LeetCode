package com.yhf.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test237 {
    /**
     * 题目0237-真正的密码
     * 题目描述
     * 在一行中输入一个字符串数组，如果其中一个字符串的所有以索引0开头的子串在数组中都有，那么这个字符串就是潜在密码，
     * <p>
     * 在所有潜在密码中最长的是真正的密码，如果有多个长度相同的真正的密码，那么取字典序最大的为唯一的真正的密码，求唯一的真正的密码。
     * <p>
     * 输入描述
     * 输入为一行用空格分隔的密码。
     * <p>
     * 输出描述
     * 输出符合条件的唯一真正密码。
     * <p>
     * 示例一
     * 输入
     * h he hel hell hello o ok n ni nin ninj ninja
     * 输出
     * ninja
     * 说明
     * 按要求，hello、ok、ninja都是潜在密码。
     * 检查长度，hello、ninja是真正的密码。
     * 检查字典序，ninja是唯一真正密码。
     * <p>
     * 示例二
     * 输入
     * a b c d f
     * 输出
     * f
     * 说明
     * 按要求，a b c d f 都是潜在密码。
     * 检查长度，a b c d f 是真正的密码。
     * 检查字典序，f是唯一真正密码。
     * <p>
     * 思路解析和复杂度分析
     * 在这个问题中，我们需要找出给定字符串数组中满足特定条件的最长字符串。特定条件是：字符串的所有以索引0开头的子串都在数组中存在。如果有多个最长字符串，我们需要找出字典序最大的那个。为了解决这个问题，我们可以采用以下思路：
     * <p>
     * 首先，我们需要读取输入并将其转换为字符串数组。在不同编程语言中，这可以通过使用不同的方法实现，例如Python中的split()函数，Java中的split(" ")方法，C++中的istringstream等。
     * 接下来，我们需要编写一个辅助函数checkSubstrings，该函数将检查一个字符串是否满足特定条件。checkSubstrings函数的输入是一个待检查的字符串以及字符串数组。函数的输出是一个布尔值，表示待检查的字符串是否满足条件。 在checkSubstrings函数中，我们可以使用一个循环，从索引1开始，到字符串的长度结束。对于每个索引i，我们需要检查当前字符串的前i个字符（即子串password[0:i]）是否在字符串数组中。如果找到了这样的子串，我们将继续下一个索引。否则，我们将返回false，表示当前字符串不满足条件。如果我们成功地检查了所有索引，那么我们将返回true。
     * 现在，我们可以使用checkSubstrings函数来找出满足条件的最长字符串。我们需要初始化一个空字符串password来存储当前找到的最长字符串。然后，我们遍历字符串数组中的每个字符串。对于每个字符串，我们首先使用checkSubstrings函数检查它是否满足条件。如果满足条件，我们将检查当前字符串是否比password更长，或者长度相同但字典序更大。如果是这样，我们将更新password为当前字符串。
     * 最后，当我们完成遍历字符串数组时，password将包含满足条件的最长字符串。我们可以将其打印出来作为输出。
     * 在分析复杂度时，我们注意到：
     * <p>
     * 时间复杂度：对于每个字符串，我们需要检查其所有子串。这将导致一个嵌套循环，时间复杂度为O(n*m^2)，其中n表示字符串数组中的字符串数量，m表示字符串的最大长度。
     * 空间复杂度：我们需要存储输入的字符串数组以及辅助变量。空间复杂度为O(n*m)，其中n表示字符串数组中的字符串数量，m表示字符串的最大长度。
     * 总的来说，我们通过使用辅助函数checkSubstrings和嵌套循环来解决这个问题。虽然时间复杂度和空间复杂度相对较高，但是给定问题的规模和约束，这种方法是足够有效的。在实际应用中，我们可以预计输入的字符串数组和字符串长度都不会过大，因此这个解决方案应该可以在合理的时间范围内解决问题。
     * <p>
     * 我们还可以考虑对算法进行优化。例如，在查找子串时，我们可以尝试使用哈希表或字典来加快查找速度。这可以将查找子串的时间复杂度降低到O(1)，从而减少算法的整体时间复杂度。
     * <p>
     * 另一个可能的优化是对输入的字符串数组进行预处理。例如，我们可以对字符串数组进行排序，这样在查找子串时，我们可以利用二分查找来加速查找过程。这将将查找子串的时间复杂度降低到O(log n)，从而进一步减少算法的整体时间复杂度。
     * <p>
     * 尽管我们可以通过这些优化方法来改进算法，但这些优化可能会增加实现的复杂性。在实际情况中，根据问题的规模和性能需求，我们需要在实现简单性和性能之间进行权衡。对于给定的问题和约束，我们提供的解决方案应该足够有效。
     * <p>
     * 总之，我们为这个问题提供了一个简单而有效的解决方案。通过使用辅助函数checkSubstrings和嵌套循环，我们能够找到满足条件的最长字符串。虽然这种方法的时间和空间复杂度相对较高，但考虑到问题的规模和约束，这种方法应该足够有效。在需要进一步优化的情况下，我们可以考虑使用哈希表、字典或对输入进行预处理以加速查找过程。
     */

    public static boolean checkSubstrings(String password, List<String> words) {
        for (int i = 1; i < password.length(); i++) {
            boolean found = false;
            for (String word : words) {
                if (password.substring(0, i).equals(word)) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> words = new ArrayList<>(Arrays.asList(input.split(" ")));

        String password = "";
        for (String candidate : words) {
            if (checkSubstrings(candidate, words)) {
                if (candidate.length() > password.length() || (candidate.length() == password.length() && candidate.compareTo(password) > 0)) {
                    password = candidate;
                }
            }
        }

        System.out.println(password);
    }
}
