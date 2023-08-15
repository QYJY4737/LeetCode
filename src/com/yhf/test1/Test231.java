package com.yhf.test1;

import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test231 {
    /**
     * 题目0231-股票最大收益
     * 题目描述
     * 假设知道某段连续时间内股票价格，计算通过买入卖出可获得的最大收益。
     * 输入一个大小为 nnn 的数组 price=[p1,p2,p3,p4.....pn]price=[p_1,p_2,p_3,p_4.....p_n]price=[p
     * 1
     * ​
     * ,p
     * 2
     * ​
     * ,p
     * 3
     * ​
     * ,p
     * 4
     * ​
     * .....p
     * n
     * ​
     * ]， pip_ip
     * i
     * ​
     * 是第 iii 天的股票价格，
     * pip_ip
     * i
     * ​
     * 的格式为股票价格(非负整型)加上货币单位Y或者S，
     * 其中Y代表人民币，S代表美元，这里规定1美元可以兑换7人民币。
     * pip_ip
     * i
     * ​
     * 样例1:123Y代表123元人民币
     * pip_ip
     * i
     * ​
     * 样例2:123S代表123元美元，可兑换861人民币。
     * 假设你可以在任何一天买入或者卖出股票，
     * 也可以选择放弃交易，请计算在交易周期n天内你能获得的最大收益(以人民币计算)
     * <p>
     * 输入描述
     * 输入一个包含交易周期内各天股票价格的字符串，以空格分隔。
     * 不考虑异常输入情况。
     * <p>
     * 输出描述
     * 输出一个整型数代表在交易周期 nnn 天内你能获得的最大收益，n<10000n < 10000n<10000。
     * <p>
     * 示例一
     * 输入
     * 2Y 3S 4S 6Y 8S
     * 输出
     * 76
     * 说明
     * 对应样例，在第1天买入，第3天卖出，第4天买入，第5天卖出
     * <p>
     * 备注
     * 股票价格只会用Y人民币或者S美元进行输入，不考虑其他情况。
     * <p>
     * 思路解析和复杂度分析
     * 解题思路解析：
     * 本题要求计算在一段连续时间内，通过买入和卖出股票能获得的最大收益。输入包括一个包含 n 天股票价格的数组，每个价格以人民币（Y）或美元（S）表示，题目规定 1 美元可以兑换 7 人民币。我们需要在交易周期内计算最大收益。
     * <p>
     * 为解决这个问题，我们可以采用贪心算法的方法。具体来说，我们需要执行以下步骤：
     * <p>
     * 转换货币：首先，我们需要将所有价格转换为人民币，以便进行统一计算。我们可以创建一个函数 convert_to_rmb，该函数接受一个价格字符串（例如 "123Y" 或 "123S"），然后将其转换为相应的人民币价格。
     * 计算最大收益：在所有价格都转换为人民币后，我们可以遍历价格数组以找到最大收益。在遍历过程中，我们需要记录当前遇到的最低价格，以便在后续遇到更高价格时计算收益。同时，我们需要记录当前最大收益，以便在遍历结束后返回。具体算法如下：
     * 初始化 max_profit 为 0，min_price 为 prices[0]。
     * 遍历 prices 数组，从第 1 个元素开始。
     * 如果当前价格小于 min_price，更新 min_price 为当前价格。
     * 否则，如果当前价格减去 min_price 大于 max_profit，更新 max_profit 为当前价格减去 min_price。
     * 返回 max_profit 作为答案。
     * 复杂度分析：
     * 时间复杂度：转换货币需要遍历所有价格字符串，时间复杂度为 O(n)；计算最大收益需要遍历所有价格，时间复杂度为 O(n)。因此，总时间复杂度为 O(n)。
     * 空间复杂度：我们需要额外的空间来存储转换为人民币的价格数组，空间复杂度为 O(n)。
     * 通过贪心算法，我们可以在较短的时间内找到交易周期内能获得的最大收益。在实际编码过程中，需要注意将价格字符串转换为整数以进行计算。同时，在遍历过程中，需要实时更新最低价格和最大收益，以便在遍历结束后直接返回最大收益。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            int result = solution(input);
            System.out.println(result);
        }
    }

    public static int solution(String input) {
        String[] pricesStr = input.split(" ");
        int[] prices = new int[pricesStr.length];

        for (int i = 0; i < pricesStr.length; i++) {
            String priceStr = pricesStr[i];
            int value = Integer.parseInt(priceStr.substring(0, priceStr.length() - 1));
            char currency = priceStr.charAt(priceStr.length() - 1);
            if (currency == 'S') {
                value *= 7;
            }
            prices[i] = value;
        }

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
