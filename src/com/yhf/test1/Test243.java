package com.yhf.test1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test243 {
    /**
     * 题目0243-模拟商场优惠打折
     * 题目描述
     * 模拟商场优惠打折，有三种优惠券可以用，满减券、打折券和无门槛券。
     *
     * 满减券：满100减10，满200减20，满300减30，满400减40，以此类推不限制使用；
     *
     * 打折券：固定折扣92折，且打折之后向下取整，每次购物只能用1次；
     *
     * 无门槛券：一张券减5元，没有使用限制。
     *
     * 每个人结账使用优惠券时有以下限制：
     *
     * 每人每次只能用两种优惠券，并且同一种优惠券必须一次用完，不能跟别的穿插使用（比如用一张满减，再用一张打折，再用一张满减，这种顺序不行）。
     *
     * 求不同使用顺序下每个人用完券之后得到的最低价格和对应使用优惠券的总数；如果两种顺序得到的价格一样低，就取使用优惠券数量较少的那个。
     *
     * 输入描述
     * 第一行三个数字m,n,k，分别表示每个人可以使用的满减券、打折券和无门槛券的数量;
     * 第二行一个数字x, 表示有几个人购物;
     * 后面x行数字，依次表示是这几个人打折之前的商品总价。
     *
     * 输出描述
     * 输出每个人使用券之后的最低价格和对应使用优惠券的数量
     *
     * 示例一
     * 输入
     * 3 2 5
     * 3
     * 100
     * 200
     * 400
     * 输出
     * 65 6
     * 135 8
     * 275 8
     * 说明
     * 输入：
     *
     * 第一行三个数字m,n,k，分别表示每个人可以使用的满减券、打折券和无门槛券的数量。
     *
     * 输出：
     *
     * 第一个人使用 1 张满减券和5张无门槛券价格最低。（100-10=90, 90-5*5=65）
     *
     * 第二个人使用 3 张满减券和5张无门槛券价格最低。（200-20-10-10=160, 160 – 5*5 = 135）
     *
     * 第二个人使用 3 张满减券和5张无门槛券价格最低。（400-40-30-30=300, 300 – 5*5=275）
     *
     * 思路解析和复杂度分析
     * 该问题可以被视为动态规划（Dynamic Programming, DP）问题。
     *
     * 思路解析
     * 首先，我们需要创建一个数组dp，其大小是可能的最大商品价格，也就是最大可用的优惠券的10倍（以10为单位因为满减券的门槛是100元）。dp[j]表示达到价格j需要使用的最小优惠券数量。初始化dp数组，除了dp[price]设为0外，其他全部设为无穷大（这里我们用常量MAX_COUPONS表示）。
     *
     * 然后，对每个购物者的商品总价，我们首先尝试使用满减券和无门槛券。对于满减券，我们检查是否满足满减条件（100元），如果满足，我们就更新dp数组。对于无门槛券，只要其数量大于0，我们就可以使用，同样更新dp数组。
     *
     * 使用满减券和无门槛券后，我们查找dp数组，寻找最小的可能价格，同时记录所需的优惠券数量。
     *
     * 最后，我们检查是否可以使用打折券。如果打折后的价格低于使用满减券和无门槛券后的最小价格，我们就选择使用打折券，并增加使用的优惠券数量。
     *
     * 复杂度分析
     * 时间复杂度：对每个购物者，我们需要遍历其商品总价次，而对于满减券，我们需要在每个价格上遍历满减券的数量，所以总的时间复杂度是O(nmprice)，其中n是购物者的数量，m是满减券的数量，price是商品总价。
     *
     * 空间复杂度：我们需要一个大小为MAX_PRICE的数组来保存状态，所以空间复杂度是O(MAX_PRICE)。
     */

    private static final int MAX_PRICE = 10005;
    private static final int MAX_COUPONS = 105;
    private static int[] dp = new int[MAX_PRICE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();

        int[] prices = new int[x];
        for (int i = 0; i < x; i++) {
            prices[i] = sc.nextInt();
        }

        for (int i = 0; i < x; i++) {
            int price = prices[i];

            Arrays.fill(dp, MAX_COUPONS);
            dp[price] = 0;

            // Full Reduction and No Threshold coupons
            for (int j = price; j >= 10; --j) {
                // Using Full Reduction coupons
                for (int l = 1; l <= m && l * 100 <= j; ++l) {
                    dp[j - l * 10] = Math.min(dp[j - l * 10], dp[j] + l);
                }
                // Using No Threshold coupons
                if (j >= 5 && k > 0) {
                    dp[j - 5] = Math.min(dp[j - 5], dp[j] + 1);
                }
            }

            int minPrice = price;
            int minCoupons = dp[0];
            for (int j = 0; j < price; ++j) {
                if (dp[j] <= k) {
                    minPrice = j;
                    minCoupons = dp[j];
                    break;
                }
            }

            // Discount coupons
            if (n > 0 && price * 0.92 < minPrice) {
                minPrice = (int) (price * 0.92);
                minCoupons += 1;
            }

            System.out.println(minPrice + " " + minCoupons);
        }
    }
}
