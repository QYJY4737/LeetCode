package com.yhf.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test221 {
    /**
     * 题目0221-AI处理器组合
     * 题目描述
     * 某公司研发了一款高性能AI处理器。每台物理设备具备8颗AI处理器，编号分别为0、1、2、3、4、5、6、7。编号0-3的处理器处于同一个链路中，编号4-7的处理器处于另外一个链路中，不通链路中的处理器不能通信，如下图所示。现给定服务器可用的处理器编号数组array，以及任务申请的处理器数量num，找出符合下列亲和性调度原则的芯片组合。如果不存在符合要求的组合，则返回空列表。
     * 亲和性调度原则：
     * <p>
     * 如果申请处理器个数为1，则选择同一链路，剩余可用的处理器数量为1个的最佳，其次是剩余3个的为次佳，然后是剩余2个，最后是剩余4个。
     * 如果申请处理器个数为2，则选择同一链路剩余可用的处理器数量2个的为最佳，其次是剩余4个，最后是剩余3个。
     * 如果申请处理器个数为4，则必须选择同一链路剩余可用的处理器数量为4个。
     * 如果申请处理器个数为8，则申请节点所有8个处理器。
     * 提示：
     * 任务申请的处理器数量只能是1、2、4、8
     * 编号0-3的处理器处于一个链路，编号4-7的处理器处于另外一个链路。
     * 处理器编号唯一，且不存在相同编号处理器
     * p0221.png
     * 输入描述
     * 输入包含可用的处理器编号数组array，以及任务申请的处理器数量num两个部分。
     * 第一行为array，第二行为num。例如：
     * <p>
     * [0, 1, 4, 5, 6, 7]
     * 1
     * 表示当前编号为0、1、4、5、6、7的处理器可用。任务申请1个处理器。
     * 0<= array.length <= 8
     * 0<= array[i] <= 7
     * num in [1, 2, 4, 8]
     * <p>
     * 输出描述
     * 输出为组合列表，当array = [0, 1, 4, 5, 6, 7] ，num = 1时，输出为[[0], [1]]
     * <p>
     * 示例一
     * 输入
     * [0, 1, 4, 5, 6, 7]
     * 1
     * 输出
     * [[0], [1]]
     * 说明
     * 根据第一条亲和性调度原则，在剩余两个处理器的链路（0,1,2,3）中选择处理器。由于只有0和1可用，则返回任意一颗处理器即可
     * <p>
     * 示例二
     * 输入
     * [0, 1, 4, 5, 6, 7]
     * 4
     * 输出
     * [[4, 5, 6, 7]]
     * 说明
     * 根据第三条亲和性调度原则，必须选择同一链路剩余可用的处理器数量为4个的环。
     * <p>
     * 思路解析和复杂度分析
     * 解题思路：
     * 首先，我们需要将给定的可用处理器编号数组按照链路分组。可以通过判断处理器编号是否小于4将处理器分为两个链路：编号0-3的处理器处于一个链路，编号4-7的处理器处于另一个链路。我们可以创建一个字典，其中键表示链路ID（0或1），值表示链路中可用处理器的列表。
     * 对于每个链路中的处理器列表，我们需要对它们进行排序，以便在后续操作中更容易找到所需的处理器。
     * 接下来，我们需要根据任务申请的处理器数量（num）和亲和性调度原则来确定最佳的处理器组合。对于不同的任务申请数量，我们需要遵循以下规则： a) 申请处理器个数为1：选择同一链路，剩余可用的处理器数量为1个的最佳，其次是剩余3个的为次佳，然后是剩余2个，最后是剩余4个。 b) 申请处理器个数为2：选择同一链路剩余可用的处理器数量2个的为最佳，其次是剩余4个，最后是剩余3个。 c) 申请处理器个数为4：必须选择同一链路剩余可用的处理器数量为4个。 d) 申请处理器个数为8：申请节点所有8个处理器。
     * 根据上述规则，我们可以从两个链路中的处理器列表中找到符合要求的处理器组合。
     * 时间复杂度分析：
     * 由于我们只需要遍历一次可用处理器列表进行分组，然后对每个链路中的处理器进行排序，所以整体时间复杂度为 O(nlogn)，其中n是可用处理器列表的长度。在本题中，n 的最大值为 8，因此时间复杂度为 O(8log8)。在实际应用中，这是一个非常小的数字，因此算法的执行速度非常快。
     * <p>
     * 空间复杂度分析：
     * 我们需要存储两个链路中的处理器列表，因此空间复杂度为 O(n)，其中n是可用处理器列表的长度。在本题中，n 的最大值为 8，因此空间复杂度为 O(8)。同样，在实际应用中，这是一个非常小的数字，因此算法的空间消耗非常小。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Integer[] arr =
                    Arrays.stream(scanner.nextLine().split("[\\[\\],\\s]"))
                            .filter(str -> !"".equals(str))
                            .map(Integer::parseInt)
                            .toArray(Integer[]::new);

            String num = scanner.next();

            System.out.println(solution(arr, num));
        }

    }

    public static String solution(Integer[] arr, String num) {
        ArrayList<Integer> link1 = new ArrayList<>();
        ArrayList<Integer> link2 = new ArrayList<>();

        Arrays.sort(arr, (a, b) -> a - b);
        for (Integer e : arr) {
            if (e < 4) {
                link1.add(e);
            } else {
                link2.add(e);
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int len1 = link1.size();
        int len2 = link2.size();

        switch (num) {
            case "1":
                if (len1 == 1 || len2 == 1) {
                    if (len1 == 1) dfs(link1, 0, 1, new ArrayList<>(), ans);
                    if (len2 == 1) dfs(link2, 0, 1, new ArrayList<>(), ans);
                } else if (len1 == 3 || len2 == 3) {
                    if (len1 == 3) dfs(link1, 0, 1, new ArrayList<>(), ans);
                    if (len2 == 3) dfs(link2, 0, 1, new ArrayList<>(), ans);
                } else if (len1 == 2 || len2 == 2) {
                    if (len1 == 2) dfs(link1, 0, 1, new ArrayList<>(), ans);
                    if (len2 == 2) dfs(link2, 0, 1, new ArrayList<>(), ans);
                } else if (len1 == 4 || len2 == 4) {
                    if (len1 == 4) dfs(link1, 0, 1, new ArrayList<>(), ans);
                    if (len2 == 4) dfs(link2, 0, 1, new ArrayList<>(), ans);
                }
                break;
            case "2":
                if (len1 == 2 || len2 == 2) {
                    if (len1 == 2) dfs(link1, 0, 2, new ArrayList<>(), ans);
                    if (len2 == 2) dfs(link2, 0, 2, new ArrayList<>(), ans);
                } else if (len1 == 4 || len2 == 4) {
                    if (len1 == 4) dfs(link1, 0, 2, new ArrayList<>(), ans);
                    if (len2 == 4) dfs(link2, 0, 2, new ArrayList<>(), ans);
                } else if (len1 == 3 || len2 == 3) {
                    if (len1 == 3) dfs(link1, 0, 2, new ArrayList<>(), ans);
                    if (len2 == 3) dfs(link2, 0, 2, new ArrayList<>(), ans);
                }
                break;
            case "4":
                if (len1 == 4 || len2 == 4) {
                    if (len1 == 4) ans.add(link1);
                    if (len2 == 4) ans.add(link2);
                }
                break;
            case "8":
                if (len1 == 4 && len2 == 4) {
                    ans.add(
                            Stream.concat(link1.stream(), link2.stream())
                                    .collect(Collectors.toCollection(ArrayList<Integer>::new)));
                }
                break;
        }

        return ans.toString();
    }

    public static void dfs(
            ArrayList<Integer> arr,
            int index,
            int level,
            ArrayList<Integer> path,
            ArrayList<ArrayList<Integer>> res) {
        if (path.size() == level) {
            res.add((ArrayList<Integer>) path.clone());
        }

        for (int i = index; i < arr.size(); i++) {
            path.add(arr.get(i));
            dfs(arr, i + 1, level, path, res);
            path.remove(path.size() - 1);
        }
    }
}
