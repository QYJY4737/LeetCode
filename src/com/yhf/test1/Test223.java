package com.yhf.test1;

import java.util.*;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test223 {
    /**
     * 题目0223-字母组合
     * 页面内容
     * 讨论
     * 最后编辑
     * Amos
     * 05/03/2023
     * 题目0223-字母组合
     * 题目描述
     * 每个数字对应多个字母，对应关系如下：
     * <p>
     * 0：a,b,c
     * 1：d,e,f
     * 2：g,h,i
     * 3：j,k,l
     * 4：m,n,o
     * 5：p,q,r
     * 6：s,t
     * 7：u,v
     * 8：w,x
     * 9：y, z
     * 输入一串数字后，通过数字和字母的对应关系可以得到多个字母字符串（要求按照数字的顺序组合字母字符串）;
     * 屏蔽字符： 屏蔽字符中的所有字母不能同时在输出的字符串出现，如屏蔽字符时abc，则要求字符串中不能同时出现a，b，c，但是允许同时出现a，b；a，c；b，c等；
     * 给定一个数字字符串和一个屏蔽字符串，输出所有可能的字符组合；
     * 例如输入数字字符串78和屏蔽字符串ux，输出结果为uw，vw，vx；
     * 数字字符串78，可以得到如下字符串： uw，ux，vw，vx；由于ux是屏蔽字符串，因此排除ux，最终的输出时uw，vw，vx；
     * <p>
     * 输入描述
     * 第一行输入为一串数字字符串，数字字符串中的数字不允许重复，数字字符串的长度大于0，小于等于5；
     * 第二行输入是屏蔽字符，屏蔽字符的长度一定小于数字字符串的长度，屏蔽字符串中字符不会重复，
     * <p>
     * 输出描述
     * 输出可能的字符串组合
     * 注：字符串之间使用逗号隔开，最后一个字符串后携带逗号
     * <p>
     * 示例一
     * 输入
     * 78
     * ux
     * 输出
     * uw,vw,vx,
     * 示例二
     * 输入
     * 78
     * x
     * 输出
     * uw,vw,
     * 思路解析和复杂度分析
     * 解题思路：
     * 本题要求将一串数字字符串根据预定义的数字与字母映射关系转换为字母组合，但需要遵循一个约束条件，即结果字符串中不能包含屏蔽字符串的所有字符。为了实现这个功能，我们可以使用递归来遍历所有可能的字母组合，然后根据约束条件对结果进行筛选。
     * <p>
     * 首先，我们需要一个数组或列表来存储每个数字对应的字母集合。接下来，我们可以编写一个递归函数，用于遍历所有可能的字母组合。这个递归函数接受四个参数：输入的数字字符串、屏蔽字符串、当前生成的组合字符串以及一个表示当前递归层级的整数。
     * <p>
     * 在递归函数中，我们首先检查当前层级是否已经达到了数字字符串的长度。如果是，则说明我们已经生成了一个完整的字母组合。在这种情况下，我们需要检查这个组合是否满足约束条件。我们可以通过计算屏蔽字符串中每个字符在组合字符串中出现的次数来实现这一点。如果屏蔽字符串中的所有字符都未同时出现在组合字符串中，则说明这个组合是有效的，我们可以将其输出。
     * <p>
     * 如果当前层级尚未达到数字字符串的长度，则我们需要继续生成更长的组合。为了实现这一点，我们首先根据当前层级的数字字符获取对应的字母集合。然后，我们遍历这个字母集合，将每个字母依次添加到组合字符串的当前位置，然后递归地调用函数本身，将层级加一。当递归返回时，我们可以继续尝试下一个字母。
     * <p>
     * 在主函数中，我们需要读取输入的数字字符串和屏蔽字符串，然后创建一个缓冲字符串来存储当前生成的组合。接着，我们调用递归函数，从第一层级开始生成组合。当所有可能的组合都被输出时，程序结束。
     * <p>
     * 复杂度分析：
     * 时间复杂度：对于每个数字，我们需要遍历其对应的字母集合。最坏情况下，输入的数字字符串长度为5，每个数字对应的字母数量为3。因此，总共需要遍历 3^5 = 243 种组合。在每个组合上，我们还需要检查屏蔽字符串中的字符是否同时出现，这需要 O(L) 时间，其中 L 是屏蔽字符串的长度。因此，总的时间复杂度为 O(243L)。
     * <p>
     * 空间复杂度：我们需要一个缓冲字符串来存储当前生成的组合，其长度等于数字字符串的长度。此外，在递归过程中，我们需要使用额外的栈空间来存储函数调用的上下文。最大递归深度等于数字字符串的长度。因此，总的空间复杂度为 O(N)，其中 N 是数字字符串的长度。
     * <p>
     * 总结：
     * 这个问题可以通过递归的方法来解决，遍历所有可能的字母组合，然后根据约束条件进行筛选。时间复杂度为 O(243L)，空间复杂度为 O(N)。虽然在最坏情况下，时间复杂度相对较高，但由于输入规模较小（数字字符串长度最大为5），因此在实际应用中，这种方法的性能是可以接受的。同时，这种方法具有很好的可扩展性，可以很容易地适应更复杂的映射关系和约束条件。
     */

    private static final String[] KB = {"abc", "def", "ghi", "jkl", "mno", "pqr", "st", "uv", "wx", "yz"};

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Integer[] arr =
                    Arrays.stream(scanner.next().split("")).map(Integer::parseInt).toArray(Integer[]::new);
            String filter = scanner.next();

            System.out.println(solution(arr, filter));
        }
    }

    public static String solution(Integer[] arr, String filter) {
        String[] newArr = Arrays.stream(arr).map(val -> KB[val]).toArray(String[]::new);

        char[] cArr = filter.toCharArray();
        Arrays.sort(cArr);
        filter = new String(cArr);

        ArrayList<String> res = new ArrayList<>();
        dfs(newArr, 0, new LinkedList<>(), res, filter);

        StringJoiner sj = new StringJoiner(" ", "", "");
        for (String str : res) {
            sj.add(str);
        }
        return sj.toString();
    }

    public static void dfs(
            String[] arr, int index, LinkedList<Character> path, ArrayList<String> res, String filter) {
        if (index == arr.length) {
            if (!include(path, filter)) {
                StringBuilder sb = new StringBuilder();
                for (Character c : path) {
                    sb.append(c);
                }
                res.add(sb.toString());
            }
            return;
        }

        for (int i = 0; i < arr[index].length(); i++) {
            path.addLast(arr[index].charAt(i));
            dfs(arr, index + 1, path, res, filter);
            path.removeLast();
        }
    }

    public static boolean include(LinkedList<Character> path, String filter) {
        StringBuilder sb = new StringBuilder();
        path.stream().sorted().forEach(sb::append);
        String src = sb.toString();

        if (filter.length() > src.length()) return false;

        int i = 0;
        int j = 0;

        while (i < src.length() && j < filter.length()) {
            if (src.charAt(i) == filter.charAt(j)) j++;
            i++;
        }

        return j == filter.length();
    }
}
