package com.yhf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test118 {
    /**
     * 题目0118-叠放书籍
     * 题目描述
     * 书籍的长宽都是整数对应(l, w)
     * 如果书A的长宽度都比B长宽大时，
     * 则允许将B排列放在A上面，
     * 现在有一组规格的书籍，
     * 书籍叠放时要求,书籍不能做旋转，
     * 请计算最多能有多少个规格书籍能叠放在一起。
     *
     * 输入描述
     * 输入:books=[[20,16],[15,11],[10,10],[9,10]]
     * 说明:总共有4本书，第一本长度为20 宽度为16
     * 第一本长度为15 宽度为11
     * 以此类推
     * 最后一本书长度为9 宽度为10
     * 输出描述
     * 输出:3
     * 说明: 最多三个规格的书籍可以叠放在一起 ，
     * 从下到上依次是[20,16],[15,11],[10,10]
     * 示例一
     * 输入
     * [[20,16],[15,11],[10,10],[9,10]]
     * 输出
     * 3
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            solution(input);
        }
    }

    private static void solution(String input) {
        List<Book> books = new ArrayList<>();
        String[] split = input.substring(2, input.length() - 2)
                .split("],\\[");
        for (String book : split) {
            String[] lw = book.split(",");

            int l = Integer.parseInt(lw[0]);
            int w = Integer.parseInt(lw[1]);
            books.add(new Book(l, w));
        }

        books.sort(Book::compareTo);

        int res = counter(books);
        System.out.println(res);


    }

    private static int counter(List<Book> books) {
        int count = 0;
        Book last = null;
        for (Book cur : books) {
            if (last == null) {
                count = 1;
                last = cur;
            } else if (last.l > cur.l && last.w > cur.w) {
                count++;
                last = cur;
            }
        }
        return count;
    }

    private static class Book implements Comparable<Book> {
        int l;
        int w;

        public Book(int l, int w) {
            this.l = l;
            this.w = w;
        }

        @Override
        public int compareTo(Book o) {
            if (this.l >= o.l && this.w >= o.w) {
                return -1;
            } else {
                return o.l - this.l;
            }
        }
    }
}
