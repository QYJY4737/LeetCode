package com.yhf.test1;

import java.util.*;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test250 {
    /**
     * 题目0250-选修课
     * 题目描述
     * 现有两门选修课，每门选修课都有一部分学生选修，每个学生都有选修课的成绩，需要你找出同时选修了两门选修课的学生，先按照班级进行划分，班级编号小的先输出，每个班级按照两门选修课成绩和的降序排序，成绩相同时按照学生的学号升序排序。
     * <p>
     * 输入描述
     * 第一行为第一门选修课学生的成绩，
     * 第二行为第二门选修课学生的成绩，
     * 每行数据中学生之间以英文分号分隔，每个学生的学号和成绩以英文逗号分隔，
     * 学生学号的格式为8位数字
     * 2位院系编号+入学年份后2位+院系内部1位专业编号+所在班级3位学号
     * 学生成绩的取值范围为[0,100]之间的整数，
     * 两门选修课选修学生数的取值范围为[1-2000]之间的整数。
     * <p>
     * 输出描述
     * 同时选修了两门选修课的学生的学号，如果没有同时选修两门选修课的学生输出NULL，
     * 否则，先按照班级划分，班级编号小的先输出，每个班级先输出班级编号(学号前五位)，
     * 然后另起一行输出这个班级同时选修两门选修课的学生学号，学号按照要求排序(按照两门选修课成绩和的降序，成绩和相同时按照学号升序学生之间以英文分号分隔。
     * <p>
     * 示例一
     * 输入
     * 01202021,75;01201033,95;01202008,80;01203006,90;01203088,100
     * 01202008,70;01203088,85;01202111,80;01202021,75;01201100,88
     * 输出
     * 01202
     * 01202008;01202021
     * 01203
     * 01203088
     * 说明
     * 同时选修了两选修课的学生01202021、01202008、01203088，这三个学生两门选修课的成绩和分别为150、150、185，
     * <p>
     * 01202021、01202008属于01202班的学生，按照成绩和降序，成绩相同时按学号升序输出的结果为01202008;01202021,
     * <p>
     * 01203088属于01203班的学生，按照成绩和降序，成绩相同时按学号升序输出的结果为01203088，
     * <p>
     * 01202的班级编号小于01203的班级编号，需要先输出。
     * <p>
     * 示例二
     * 输入
     * 01201022,75;01202033,95;01202018,80;01203006,90;01202066,100
     * 01202008,70;01203102,85;01202111,80;01201021,75;01201100,88
     * 输出
     * NULL
     * 说明
     * 没有同时选修了两门选修课的学生，输出NULL.
     * <p>
     * ¶思路解析和复杂度分析
     */

    static class Student {
        String id;
        int totalScore;

        public Student(String id, int totalScore) {
            this.id = id;
            this.totalScore = totalScore;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] course1 = scanner.nextLine().split(";");
            String[] course2 = scanner.nextLine().split(";");
            solution(course1, course2);
        }
    }

    private static void solution(String[] course1, String[] course2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (String s : course1) {
            String[] parts = s.split(",");
            map1.put(parts[0], Integer.parseInt(parts[1]));
        }

        for (String s : course2) {
            String[] parts = s.split(",");
            map2.put(parts[0], Integer.parseInt(parts[1]));
        }

        Map<String, List<Student>> classMap = new TreeMap<>(); // Use TreeMap to maintain order of classes

        for (String id : map1.keySet()) {
            if (map2.containsKey(id)) {
                String classId = id.substring(0, 5);
                classMap.putIfAbsent(classId, new ArrayList<>());
                classMap.get(classId).add(new Student(id, map1.get(id) + map2.get(id)));
            }
        }

        if (classMap.isEmpty()) {
            System.out.println("NULL");
            return;
        }

        classMap.forEach((classId, students) -> {
            // Sort students by totalScore in descending order, if equal then by id in ascending order
            students.sort((s1, s2) -> s2.totalScore != s1.totalScore ? s2.totalScore - s1.totalScore : s1.id.compareTo(s2.id));
            System.out.println(classId);
            for (int i = 0; i < students.size(); i++) {
                if (i != students.size() - 1) {
                    System.out.print(students.get(i).id + ";");
                } else {
                    System.out.println(students.get(i).id); // Do not print ";" for the last id
                }
            }
        });
    }
}
