package com.yhf.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on 2023/8/10.
 *
 * @author qyjy4737
 */
public class Test032 {
    /**
     * 题目0032-众数和中位数
     * 题目描述
     * 众数是指一组数据中出现次数多的数
     * 众数可以是多个
     * 中位数是指把一组数据从小到大排列，最中间的那个数，
     * 如果这组数据的个数是奇数，那最中间那个就是中位数
     * 如果这组数据的个数为偶数，那就把中间的两个数之和除以2就是中位数
     * 查找整型数组中元素的众数并组成一个新的数组
     * 求新数组的中位数
     * 输入描述
     * 输入一个一维整型数组，数组大小取值范围 0 < n < 1000
     * 数组中每个元素取值范围， 0 < e < 1000
     * <p>
     * 输出描述
     * 输出众数组成的新数组的中位数
     * <p>
     * 示例一
     * 输入
     * 10 11 21 19 21 17 21 16 21 18 16
     * 输出
     * 21
     * 示例二
     * 输入
     * 2 1 5 4 3 3 9 2 7 4 6 2 15 4 2 4
     * 输出
     * 3
     * 示例三
     * 输入
     * 5 1 5 3 5 2 5 5 7 6 7 3 7 11 7 55 7 9 98 9 17 9 15 9 9 1 39
     * 输出
     * 7
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }

    }

    private static void solution(String line) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(line.split(" "))
                .forEach(x -> {
                    int i = Integer.parseInt(x);
                    map.put(i, map.getOrDefault(i, 0) + 1);
                });

        Integer max = map.values().stream().max(Integer::compareTo).get();

        List<Integer> newArr = map.keySet().stream()
                .filter(k -> map.get(k).equals(max))
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());

        Integer res = 0;
        int size = newArr.size();
        if (size % 2 == 0) {
            res = (newArr.get(size / 2) + newArr.get(size / 2 - 1)) / 2;
        } else {
            res = newArr.get(size / 2);
        }
        System.out.print(res);
    }
}
