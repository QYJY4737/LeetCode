package com.yhf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test151 {
    /**
     * 题目0151-最多获得的短信条数
     * 题目描述
     * 某云短信厂商，为庆祝国庆，推出充值优惠活动。
     * 现在给出客户预算，和优惠售价序列，求最多可获得的短信总条数。
     *
     * 输入描述
     * 第一行客户预算M，其中 0≤M≤1060 \leq M \leq 10^60≤M≤10
     * 6
     *
     * 第二行给出售价表，P1,P2...PnP_1,P_2...P_nP
     * 1
     * ​
     *  ,P
     * 2
     * ​
     *  ...P
     * n
     * ​
     *   , 其中 1≤n≤1001 \leq n \leq 1001≤n≤100 ,
     * PiP_iP
     * i
     * ​
     *   为充值 iii 元获得的短信条数。
     * 1≤Pi≤1000,1≤n≤1001 \leq Pi \leq 1000, 1 \leq n \leq 1001≤Pi≤1000,1≤n≤100
     *
     * 输出描述
     * 最多获得的短信条数
     *
     * 示例一
     * 输入
     * 6
     * 10 20 30 40 60
     * 输出
     * 70
     * 说明
     * 分两次充值最优，111 元、555 元各充一次。总条数 10+60=7010 + 60 = 7010+60=70
     *
     * 示例二
     * 输入
     * 15
     * 10 20 30 40 60 60 70 80 90 150
     * 输出
     * 210
     * 说明
     * 分两次充值最优，101010 元 555 元各充一次，总条数 150+60=210150 + 60 = 210150+60=210
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int amount = Integer.parseInt(scanner.nextLine());
            String msgCount = scanner.nextLine();
            int max = solution(amount, msgCount);
            System.out.print(max);
        }
    }

    private static class Bundle {
        int price;
        int count;
        double rating;

        public Bundle(int price, int count, double rating) {
            this.price = price;
            this.count = count;
            this.rating = rating;
        }
    }

    private static int solution(int amount, String msgCount) {
        int max = 0;

        String[] split = msgCount.split(" ");
        List<Bundle> bundles = new ArrayList<>(split.length);
        for (int i = 0; i < split.length; i++) {
            int price = i + 1;
            int count = Integer.parseInt(split[i]);
            double rating = count * 1.0 / (i + 1);
            bundles.add(new Bundle(price, count, rating));
        }

        bundles.sort((b1, b2) -> Double.compare(b2.rating, b1.rating));

        for (int i = 0; amount > 0; i++) {
            Bundle bundle = bundles.get(i);
            if (bundle.price <= amount) {
                max += bundle.count;
                amount -= bundle.price;
            }
            if (i == bundles.size() - 1) {
                i = 0;
            }
        }

        return max;
    }
}
