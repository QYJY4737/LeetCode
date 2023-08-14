package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test120 {
    /**
     * 题目0120-九宫格按键输入
     * 题目描述
     * 九宫格按键输入，有英文和数字两种模式，
     * 默认是数字模式，数字模式直接输出数字，
     * 英文模式连续按同一个按键会依次出现这个按键上的字母，
     * 如果输入/或者其他字符，则循环中断，输出此时停留的字母。
     * 数字和字母的对应关系如下，注意0只对应空格：
     *
     * 1(,.)   2(abc)  3(def)
     * 4(ghi)  5(jkl)  6(mno)
     * 7(pqrs) 8(tuv)  9(wxyz)
     * #       0(空格)  /
     * 输入一串按键，要求输出屏幕显示
     *
     * #用于切换模式，默认是数字模式，执行#后切换为英文模式；
     * /表示延迟，例如在英文模式下，输入22/222，显示为bc,数字模式下/没有效果；
     * 英文模式下，多次按同一键，例如输入22222，显示为b;
     * 输入描述
     * 输入范围为数字0~9和字符#,/,输出屏幕显示，例如,
     * 在数字模式下，输入1234，显示1234
     * 在英文模式下，输入1234，显示 ,adg
     *
     * 输出描述
     * 输出屏幕显示的字符
     *
     * 示例一
     * 输入
     * 2222/22
     * 输出
     * 222222
     * 说明
     * 默认数字模式，字符直接显示，数字模式下/无效
     *
     * 示例二
     * 输入
     * #2222/22
     * 输出
     * ab
     * 说明
     * #进入英文模式，连续的数字输入会循环选择字母，直至输入/，
     * 故第一段2222输入显示a，第二段22输入显示b
     *
     * 示例二
     * 输入
     * #222233
     * 输出
     * ae
     * 说明
     * #进入英文模式，连续的数字输入会循环选择字母，
     * 直至输入其他数字，故第一段2222输入显示a，第二段33输入显示e
     */

    private static final char[][] buttonWords = {
            {' '},
            {',','.'},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'n', 'm', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        boolean numMode = true;
        StringBuilder builder = new StringBuilder();

        char[] inputs = line.toCharArray();


        for (int i = 0; i < inputs.length; i++) {
            char c = inputs[i];


            if (Character.isDigit(c) && c != '0') {
                if (numMode) {
                    builder.append(c);
                } else {
                    char last = c;
                    int count = 0;
                    while (i < inputs.length && last == inputs[i]) {
                        last = inputs[i];
                        count++;
                        i++;
                    }
                    int num = Character.digit(c, 10);
                    char[] buttonWord = buttonWords[num];
                    char word = buttonWord[(count-1) % buttonWord.length];
                    builder.append(word);
                    i--;
                }
                continue;
            }


            switch (c) {
                case '#':
                    numMode = !numMode;
                    break;
//        case '/':
//          if (!numMode) builder.append('/');
//          break;
                case '0':
                    builder.append(numMode ? '0' : ' ');
                    break;
                default:
                    break;
            }
        }


        System.out.print(builder);

    }
}
