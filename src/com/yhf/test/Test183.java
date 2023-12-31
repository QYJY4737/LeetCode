package com.yhf.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test183 {
    /**
     * 题目0183-货币单位换算
     * 题目描述
     * 记账本上记录了若干条多国货币金额，需要转换成人民币分（fen），汇总后输出。
     * 每行记录一条金额，金额带有货币单位，格式为数字+单位，可能是单独元，或者单独分，或者元与分的组合。
     * 要求将这些货币全部换算成人民币分（fen）后进行汇总，汇总结果仅保留整数，小数部分舍弃。
     * 元和分的换算关系都是1:100，如下：
     * 1CNY=100fen（1元=100分）
     * 1HKD=100cents（1港元=100港分）
     * 1JPY=100sen（1日元=100仙）
     * 1EUR=100eurocents（1欧元=100欧分）
     * 1GBP=100pence（1英镑=100便士）
     * 汇率如下表
     * <p>
     * CNY	JPY	HKD	EUR	GBP
     * 100	1825	123	14	12
     * 即100CNY = 1825JPY = 123HKD = 14EUR = 12GBP
     * <p>
     * 输入描述
     * 第一行输入为 NNN，NNN 表示记录数。0<N<1000 < N < 1000<N<100
     * 之后 NNN 行，每行表示一条货币记录，且该行只会是一种货币。
     * <p>
     * 输出描述
     * 将每行货币转换成人民币分（fen）后汇总求和，只保留整数部分。
     * 输出格式只有整数数字，不带小数，不带单位。
     * <p>
     * 示例一
     * 输入
     * 1
     * 100CNY
     * 输出
     * 10000
     * 说明
     * 100CNY转换后是10000fen，所以输出结果为10000
     * <p>
     * 示例二
     * 输入
     * 1
     * 3000fen
     * 输出
     * 3000
     * 说明
     * 3000fen，结果就是3000
     * <p>
     * 示例三
     * 输入
     * 1
     * 123HKD
     * 输出
     * 10000
     * 说明
     * HKD与CNY的汇率关系是123:100，所以换算后，输出结果为10000
     * <p>
     * 示例四
     * 输入
     * 2
     * 20CNY53fen
     * 53HKD87cents
     * 输出
     * 6432
     * 说明
     * 20元53分+53港元87港分，换算成人民币分后汇总，为6432
     */

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] input = new String[n];
            for (int i = 0; i < n; i++) {
                input[i] = scanner.nextLine();
            }
            int res = solution(input);
            System.out.println(res);
        }
    }

    private static final Pattern pNum = Pattern.compile("[0-9]+");
    private static final Pattern pWord = Pattern.compile("([a-z]|[A-Z])+");

    private static int solution(String[] input) {
        Map<String, Double> exchange = new HashMap<>();
        exchange.put("CNY", 0.01);
        exchange.put("fen", 1.);
        exchange.put("JPY", .1825);
        exchange.put("sen", 18.25);
        exchange.put("HKD", 0.0123);
        exchange.put("cents", 1.23);
        exchange.put("EUR", 0.0014);
        exchange.put("eurocents", 0.14);
        exchange.put("GBP", 0.0012);
        exchange.put("pence", 0.12);


        double res = 0.;
        for (String s : input) {
            String str = s;
            String num = "";
            String word = "";
            while (str.length() > 0) {
                Matcher mNum = pNum.matcher(str);
                if (mNum.find()) {
                    num = mNum.group();
                    str = str.substring(num.length());
                }

                Matcher mWord = pWord.matcher(str);
                if (mWord.find()) {
                    word = mWord.group();
                    str = str.substring(word.length());
                }
                res += Double.parseDouble(num) / exchange.get(word);
            }
        }
        return (int) res;
    }
}
