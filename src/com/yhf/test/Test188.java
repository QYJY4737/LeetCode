package com.yhf.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test188 {
    /**
     * 题目0188-网上商城优惠活动（一）
     * 题目描述
     * 背景
     * 某网上商城举办优惠活动，发布了满减、打折、无门槛3种优惠券，分别为：
     * 每满100元优惠10元，无使用数限制，如100~199元可以使用1张减10元，200~299可使用2张减20元，以此类推；
     * 92折券，1次限使用1张，如100元，则优惠后为92元；
     * 无门槛5元优惠券，无使用数限制，直接减5元。
     * 优惠券使用限制
     * 每次最多使用2种优惠券，2种优惠可以叠加（优惠叠加时以优惠后的价格计算），
     * 以购物200元为例，可以先用92折券优惠到184元，再用1张满减券优惠10元，最终价格是174元，
     * 也可以用满减券2张优惠20元为180元，再使用92折券优惠到165（165.6向下取整）元，
     * 不同使用顺序的优惠价格不同，以最优惠价格为准。
     * 在一次购物中，同一类型优惠券使用多张时必须一次性使用，
     * 不能分多次拆开穿插使用（不允许先使用1张满减券，再用打折券，再使用一张满减券）。
     * 问题
     * 请设计实现一种解决方法，帮助购物者以最少的优惠券获得最优的优惠价格。
     * 优惠后价格越低越好，同等优惠价格，使用的优惠券越少越好，可以允许某次购物不使用优惠券。
     * 约定
     * 优惠活动每人只能参加一次，每个人的优惠券种类和数量是一样的。
     * 输入描述
     * 第一行：每个人拥有的优惠券数量（数量取值范围为[0, 10]），按满减、打折、无门槛的顺序输入。
     * 第二行：表示购物的人数n（1 <= n <= 10000）。
     * <p>
     * 最后n行：每一行表示某个人优惠前的购物总价格（价格取值范围(0, 1000]，都为整数）。
     * <p>
     * 约定：输入都是符合题目设定的要求的。
     * <p>
     * 输出描述
     * 每行输出每个人每次购物优惠后的最低价格以及使用的优惠券总数量，每行的输出顺序和输入的顺序保持一致。
     * <p>
     * 备注
     * 优惠券数量都为整数，取值范围为[0, 10]。
     * 购物人数为整数，取值范围为[1, 10000]。
     * 优惠券的购物总价为整数，取值范围为(0, 1000]。
     * 优惠后价格如果是小数，则向下取整，输出都为整数。
     * 示例一
     * 输入
     * 3 2 5
     * 3
     * 100
     * 200
     * 400
     * 输出
     * 65 6
     * 155 7
     * 338 4
     * 说明
     * 输入说明
     * 第一行：3种优惠券数量分别为满减券3张，打折券2张，无门槛5张
     * 第二行：总共3个人购物
     * 第三行：第一个人购物优惠前价格为100元
     * 第四行：第二个人购物优惠前价格为200元
     * 第五行：第三个人购物优惠前价格为400元
     * <p>
     * 输出说明
     * 输入3个人，输出3行结果，同输入的顺序，对应每个人的优惠结果，如下：
     * 第一行：先使用1张满减券优惠到90元，再使用5张无门槛券优惠25元，最终价格是65元，总共使用6张优惠券
     * 第二行：先使用2张满减券优惠到180元，再使用5张无门槛券优惠25元，最终价格是155元，总共使用7张优惠券
     * 第三行：先使用1张92折券优惠到368元，再使用3张满减券优惠30元，最终价格是338元，总共使用4张优惠券
     * <p>
     * 思路
     * 看似复杂，其实是简单计算和逻辑判断
     * 首先设计三个函数分别计算当前金额对每种优惠券使用后的结果，如代码中useT1 useT2 useT3
     * 之后分情况讨论：
     * <p>
     * 小于等于62元，优先使用优惠券3
     * 优惠券1和2比较后，再分情况比较2、3和1、3
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] tickets = new int[3];
            for (int i = 0; i < tickets.length; i++) {
                tickets[i] = scanner.nextInt();
            }
            scanner.nextLine();
            int n = scanner.nextInt();
            int[] amounts = new int[n];
            for (int i = 0; i < n; i++) {
                amounts[i] = scanner.nextInt();
            }

            solution(tickets, amounts);
        }
    }

    private static void solution(int[] tickets, int[] amounts) {
        int t1 = tickets[0];
        int t2 = tickets[1];
        int t3 = tickets[2];
        for (int amount : amounts) {
            int[] result = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
            int[] res1 = useT1(t1, new int[]{amount, 0});
            int[] res2 = useT2(t2, new int[]{amount, 0});
            int[] res3 = useT3(t3, new int[]{amount, 0});

            // 如果金额在100以内，不考虑第一种优惠券
            if (amount < 100) {
                // 如果金额在62以内，则优先使用-5元优惠券更划算，否则优先使用92折
                if (amount <= 62 && t3 > 0) {
                    result = useT2(t2, res3);
                } else {
                    result = useT3(t3, res2);
                }
                System.out.println(result[0] + " " + result[1]);
                return;
            }


            // 优惠券1和和2比较
            if (res1[0] < res2[0]) {
                // 1更为优惠则比较2和3
                int[] copyRes = Arrays.copyOf(res1, res1.length);
                int[] r3 = useT3(t3, res1);
                int[] r2 = useT2(t2, copyRes);
                result = r3[0] < r2[0] ? r3 : r2;
            } else {
                // 2更为优惠则比较1和3
                int[] copyRes = Arrays.copyOf(res2, res2.length);
                int[] r3 = useT3(t3, res2);
                int[] r1 = useT1(t1, copyRes);
                result = r3[0] < r1[0] ? r3 : r1;
            }


            System.out.println(result[0] + " " + result[1]);
        }
    }


    /**
     * 使用第一种优惠卷
     *
     * @param ticket 优惠券张数
     * @param res    一个数组包含两个元素，第一个元素为满减前的金额，第二个元素为满减前使用的券数
     * @return 一个输入含两个元素，第一个元素为满减后的金额，第二个元素为满减后使用的券数
     */
    private static int[] useT1(int ticket, int[] res) {
        int tmp = res[0];
        while (tmp >= 100 && ticket > 0) {
            res[0] -= 10;
            ticket--;
            res[1] += 1;
            tmp -= 100;
        }
        return res;
    }

    //同useT1
    private static int[] useT2(int ticket, int[] res) {
        if (ticket > 0) {
            res[0] = (int) (res[0] * 0.92);
            res[1] += 1;
        }
        return res;
    }

    //同useT1
    private static int[] useT3(int ticket, int[] res) {
        while (res[0] >= 5 && ticket > 0) {
            res[0] -= 5;
            res[1] += 1;
            ticket--;
        }
        return res;
    }
}
