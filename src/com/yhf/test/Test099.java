package com.yhf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test099 {
    /**
     * 题目0099-计算堆栈中的剩余数字
     * 题目描述
     * 向一个空栈中依次存入正整数
     * 假设入栈元素N(1<=N<=2^31-1)
     * 按顺序依次为Nx ... N4、N3、N2、N1,
     * 当元素入栈时，如果N1=N2+...Ny(y的范围[2,x],1 <= x <= 1000)
     * 则N1到Ny全部元素出栈,重新入栈新元素M(M=2*N1)
     * 如依次向栈存储6、1、2、3,当存储6、1、2时
     * 栈底至栈顶以此为[6、1、2]:当存入3时，3=2+1,
     * 3、2、1全部出栈，重新入栈元素6，(6=2*3)此时栈中有元素6
     * 因为6=6,所有两个六全部出栈存入12
     * 最终栈中只剩一个元素12
     * <p>
     * 输入描述
     * 使用单个空格隔开的正整数的字符串
     * 如：5 6 7 8,左边的数字先入栈
     * 输入的正整数个数为x
     * 1 <= x <= 1000
     * <p>
     * 输出描述
     * 最终栈中存留的元素值，元素值使用空格隔开，
     * 如8 7 6 5，栈顶数字在左边
     * <p>
     * 示例一
     * 输入
     * 5 10 20 50 85 1
     * 输出
     * 1 170
     * 说明
     * 5+10+20+50=85
     * 输入85时， 5、10、20、50、85全部出栈
     * 入栈170
     * 最终依次出栈的数字为1和170
     * <p>
     * 示例二
     * 输入
     * 6 7 8 13 9
     * 输出
     * 9 13 8 7 6
     * 示例三
     * 输入
     * 1 2 5 7 9 1 2 2
     * 输出
     * 4 1 9 14 1
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        String[] strings = line.split(" ");

        List<Integer> list = new ArrayList<>();

        for (String string : strings) {
            list.add(Integer.parseInt(string));
        }
        boolean isChange = true;
        while (list.size() != 1 && (isChange)) {
            for (int i = 1; i < list.size(); i++) {
                int n = i;
                int num = list.get(i);
                boolean isEnd = false;
                int count = 0;
                while (!isEnd) {
                    n--;
                    count += list.get(n);
                    if (count == num) {
                        if (i >= n) {
                            list.subList(n, i + 1).clear();
                        }
                        list.add(n, 2 * num);
                        isChange = true;
                        break;
                    }
                    if (count > num || n == 0) {
                        isEnd = true;
                        isChange = false;
                    }
                }
                if (isChange) {
                    break;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            res.append(list.get(i));
            if (i != 0) {
                res.append(" ");
            }
        }

        System.out.print(res);

    }
}
