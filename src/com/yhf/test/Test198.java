package com.yhf.test;

import java.util.*;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test198 {
    /**
     * 题目0198-整理扑克牌
     * 题目描述
     * 给定一组数字，表示扑克牌的牌面数字，忽略扑克牌的花色，请安如下规则对这一组扑克牌进行整理。
     * <p>
     * 步骤一：
     * 对扑克牌进行分组，规则如下
     * 当牌面数字相同张数大于等于4时，组合牌为炸弹；
     * 三张相同牌面数字+两张相同牌面数字，且三张牌与两张牌不相同时，组合牌为葫芦；
     * 三张相同牌面数字，组合牌为三张，
     * 两张相同牌面数字，组合牌为对子，
     * 剩余没有相同的牌则为单张
     * 步骤二：
     * 对上述组合牌进行由大到小排列，规则如下：
     * 不同类型组合牌之间由大到小排列规则：
     * 炸弹 > 葫芦 > 三张 > 对子 > 单张
     * 相同类型组合牌之间，除葫芦外，按组合牌全部牌面数字加总，由大到小排列
     * 葫芦则先按三张相同牌面数字加总，由大到小排列，三张相同牌面数字加总相同时，再按另外两张牌面数字加总，由大到小排列；
     * 由于葫芦大于三张，因此如果能形成更大的组合牌，也可以将三张拆分为两张或一张，其中的两张可以和其他三张重新组合成葫芦，剩下的一张为单张；
     * 步骤三：
     * 当存在多个可能组合方案时，按如下规则排序取最大的一个组合牌：
     * 依次对组合方案中的组合牌进行大小比较，规则同上；
     * 当组合方案A中的第N个组合牌 > 组合方案B中的第N个组合牌时，即组合方案A大于组合方案B；
     * 输入描述
     * 第一行为空格分隔的N个正整数，每个整数取值范围 [1,13][1,13][1,13]，N的取值范围 [1,1000][1,1000][1,1000]
     * <p>
     * 输出描述
     * 经重新排列后的扑克牌数字列表，每个数字以空格分隔
     * <p>
     * 示例一
     * 输入
     * 1 3 3 3 2 1 5
     * 输出
     * 3 3 3 1 1 5 2
     * 示例二
     * 输入
     * 4 4 2 1 2 1 3 3 3 4
     * 输出
     * 4 4 4 3 3 2 2 1 1 3
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        String[] split = line.split(" ");
        Map<Integer, Integer> map = new HashMap<>();
        for (String s : split) {
            int number = Integer.parseInt(s);
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        Comparator<Map.Entry<Integer, Integer>> entryComparator = (e1, e2) -> {
            if (!e2.getValue().equals(e1.getValue())) {
                return e2.getValue() - e1.getValue();
            } else {
                return e2.getKey() - e1.getKey();
            }
        };

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());


        StringBuilder builder = new StringBuilder();
        while (list.size() > 0) {
            list.sort(entryComparator);

            Map.Entry<Integer, Integer> first = list.get(0);
            // 炸弹
            if (first.getValue() >= 4) {
                append(builder, first.getKey(), 4);
                if (first.getValue() - 4 == 0) {
                    list.remove(0);
                } else {
                    first.setValue(first.getValue() - 4);
                }
                continue;
            }

            // 葫芦 或 三
            if (first.getValue() == 3 && list.size() > 1) {
                Map.Entry<Integer, Integer> second = list.get(1);
                if (second.getValue() >= 2) {
                    append(builder, first.getKey(), 3);
                    append(builder, second.getKey(), 2);
                    if (second.getValue() == 2) {
                        list.remove(1);
                    } else {
                        second.setValue(second.getValue() - 2);
                    }
                    list.remove(0);
                    continue;
                } else {
                    append(builder, first.getKey(), 3);
                    list.remove(0);
                    continue;
                }
            }

            //其他

            int size = list.size();
            for (int i = 0; i < size; i++) {
                append(builder, list.get(0).getKey(), list.get(0).getValue());
                list.remove(0);
            }

        }
        System.out.print(builder.substring(0, builder.length() - 1));

    }

    private static void append(StringBuilder builder, int number, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(number).append(" ");
        }
    }
}
