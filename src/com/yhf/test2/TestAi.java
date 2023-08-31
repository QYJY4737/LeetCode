package com.yhf.test2;

import java.util.Scanner;

/**
 * Created on 2023/8/28.
 *
 * @author qyjy4737
 */
public class TestAi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        while (true){
            str = scanner.next();
            str = str.replace("吗", "");
            str = str.replace("？", "！");
            str = str.replace("？", "！");
            System.out.println(str);
        }
    }
}
