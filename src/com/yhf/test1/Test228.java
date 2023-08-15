package com.yhf.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test228 {
    /**
     * 题目0228-硬件产品销售方案
     * 题目描述
     * 某公司目前推出了AI开发者套件、AI加速卡、AI加速模块、AI服务器、智能边缘多种硬件产品，每种产品包含若干个型号。
     * 现某合作厂商要采购金额为amount元的硬件产品搭建自己的AI基座。
     * 假设当前库存有 NNN 种产品，每种产品的库存量充足，给定每种产品的价格，记为price（不存在价格相同的产品型号）。
     * 请为合作厂商列出所有可能的产品组合。
     * <p>
     * 输入描述
     * 输入包含采购金额amount和产品价格列表price。
     * 第一行为amount，第二行为price。例如：
     * <p>
     * 500
     * [100, 200, 300, 500]
     * 输出描述
     * 输出为组合列表。例如：
     * <p>
     * [[500], [200, 300], [100, 200, 200], [100, 100, 300], [100, 100, 100, 200], [100, 100, 100, 100, 100]]
     * 备注
     * 对于给定输入，产品组合少于150种。输出的组合为一个数组，数组的每个元素也是一个数组，表示一种组合方案。如果给定产品无法组合金额为amount元的方案，那么返回空列表。
     * 两种组合方案，只要存在一种产品的数量不同，那么方案认为是不同的。
     * 每种产品型号价格不相同
     * 1≤产品类型数量≤301 \leq 产品类型数量 \leq 301≤产品类型数量≤30
     * 100≤产品价格≤20000100 \leq 产品价格 \leq 20000100≤产品价格≤20000
     * 100≤采购金额≤50000100 \leq 采购金额 \leq 50000100≤采购金额≤50000
     * 示例一
     * 输入
     * 500
     * [100, 200, 300, 500, 500]
     * 输出
     * [[100, 100, 100, 100, 100], [100, 100, 100, 200], [100, 100, 300], [100, 200, 200], [200, 300], [500], [500]]
     * 示例二
     * 输入
     * 100
     * [100]
     * 输出
     * [[100]]
     * 思路解析和复杂度分析
     * 思路解析
     * 这个问题的目标是找出给定价格列表中，所有可以组合成指定采购金额的方案。为了解决这个问题，我们使用了递归回溯算法。回溯算法的核心思想是尝试从当前状态向下一个状态转换，如果满足约束条件，那么就递归调用自身进行下一步尝试，否则就回溯到上一个状态。在这个问题中，我们需要在给定的价格列表中找到所有可以组合成指定金额的方案。
     * <p>
     * 具体来说，我们从价格列表的第一个元素开始，尝试将其添加到当前组合中。接着，我们减去当前元素的价格，并递归地尝试添加下一个元素。如果剩余金额为0，说明我们找到了一个有效的组合，将其添加到结果列表中。如果剩余金额小于0，说明当前组合无法满足金额要求，我们需要回溯。在回溯过程中，我们将当前元素从组合中移除，并尝试下一个元素。
     * <p>
     * 为了避免重复计算，我们使用一个参数 start 来记录当前元素在价格列表中的位置。这样，在递归调用时，我们只会尝试从当前元素开始的子列表。在每一轮递归中，我们都会遍历价格列表中的所有元素，尝试添加它们到组合中。因此，这个算法的时间复杂度主要取决于递归树的深度和每一层的分支数量。
     * <p>
     * 复杂度分析
     * 对于这个问题，递归树的深度最大为 amount / min(price)，其中 min(price) 表示价格列表中的最小值。在最坏情况下，我们需要尝试所有可能的组合，即每一层都有 n 个分支，其中 n 为价格列表的长度。因此，时间复杂度最大为 O(n^(amount / min(price)))。由于题目限制了产品类型数量和价格范围，所以这个算法在实际情况下的运行时间是可接受的。
     * <p>
     * 空间复杂度主要取决于递归调用的栈空间和结果列表的大小。在最坏情况下，递归栈的深度为 amount / min(price)，因此空间复杂度为 O(amount / min(price))。此外，我们还需要存储所有有效的组合，这需要额外的空间。由于给定的输入限制，我们可以保证输出的组合数量不会超过150种，因此空间复杂度是可以接受的。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int amount = scanner.nextInt();
            scanner.nextLine();
            String line = scanner.nextLine();
            String res = solution(amount, line);
            System.out.println(res);
        }
    }

    private static String solution(int amount, String line) {
        Integer[] price = Arrays.stream(line.substring(1, line.length() - 1).split("\\W+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        ArrayList<String> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        dfs(amount, price, 0, 0, path, res);
        return res.toString();
    }

    private static void dfs(
            int total,
            Integer[] arr,
            int index,
            int sum,
            LinkedList<Integer> path,
            ArrayList<String> res) {
        if (sum >= total) {
            if (sum == total) res.add(path.toString());
            return;
        }

        for (int i = index; i < arr.length; i++) {
            path.addLast(arr[i]);
            dfs(total, arr, i, sum + arr[i], path, res);
            path.removeLast();
        }
    }
}
