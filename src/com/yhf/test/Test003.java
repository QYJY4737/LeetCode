package com.yhf.test;

import java.util.Scanner;

public class Test003 {

    /**
     * 题目0003-TLV编码
     * 题目描述
     * TLV编码是按TagLengthValue格式进行编码的。
     * 一段码流中的信元用tag标识，tag在码流中唯一不重复，
     * length表示信元value的长度，value表示信元的值，
     * 码流以某信元的tag开头，tag固定占一个字节，length固定占两个字节，字节序为小端序。
     * 现给定tlv格式编码的码流以及需要解码的信元tag，请输出该信元的value。
     * <p>
     * 输入码流的十六进制字符中，不包括小写字母；
     * 且要求输出的十六进制字符串中也不要包含小写字母；
     * 码流字符串的最大长度不超过50000个字节。
     * <p>
     * 输入描述
     * 第一行为一个字符串 ，表示待解码信元的tag；
     * 第二行为一个字符串， 表示待解码的十六进制码流；
     * 字节之间用空格分割。
     * <p>
     * 输出描述
     * 输出一个字符串，表示待解码信元以十六进制表示的value。
     * <p>
     * 示例一
     * 输入
     * 31
     * 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
     * 输出
     * 32 33
     * 说明
     * 需要解析的信源的tag是31；
     * 从码流的起始处开始匹配，tag为32的信元长度为1(01 00,小端序表示为1)；
     * 第二个信元的tag为90 其长度为2；
     * 第三个信元的tag为30 其长度为3；
     * 第四个信元的tag为31 其长度为2(02 00)；
     * 所以返回长度后面的两个字节即可，为 32 33。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String tag = scanner.nextLine();
            String source = scanner.nextLine();
            solution(tag, source);
        }
    }

    private static void solution(String tag, String source) {
        int p = 0;
        while (p < source.length()) {
            String curTag = source.substring(p, p + 2);
            String lenHEX = source.substring(p + 6, p + 8) + source.substring(p + 3, p + 5);
            int lenDEC = Integer.parseInt(lenHEX, 16);
            if (tag.equals(curTag)) {
                String value = source.substring(p + 9, p + 9 + lenDEC * 3);
                System.out.println(value);
            }
            p += 9 + lenDEC * 3;
        }
    }

}
