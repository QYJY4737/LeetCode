package com.yhf.test;

import java.util.*;

/**
 * Created on 2023/8/11.
 *
 * @author qyjy4737
 */
public class Test095 {
    /**
     * 题目0095-删除指定目录
     * 题目描述
     * 某文件系统中有N个目录，
     * 每个目录都一个独一无二的ID。
     * 每个目录只有一个付目录，
     * 但每个目录下可以有零个或多个子目录，
     * 目录结构呈树状结构。
     * 假设 根目录的ID为0，且根目录没有父目录
     * ID用唯一的正整数表示，并统一编号
     * 现给定目录ID和其付目录ID的对应父子关系表
     * [子目录ID,父目录ID]，以及一个待删除的目录ID，
     * 请计算并返回一个ID序列，
     * 表示因为删除指定目录后剩下的所有目录，
     * 返回的ID序列以递增序输出
     * 注意：
     * 1、被删除的目录或文件编号一定在输入的ID序列中；
     * 2、当一个目录删除时，它所有的子目录都会被删除。
     *
     * 输入描述
     * 输入的第一行为父子关系表的长度m；接下来的m行为m个父子关系对；
     * 最后一行为待删除的ID。
     * 序列中的元素以空格分割，
     * 参见样例。
     *
     * 输出描述
     * 输出一个序列，表示因为删除指定目录后，剩余的目录ID。
     *
     * 示例一
     * 输入
     * 5
     * 8 6
     * 10 8
     * 6 0
     * 20 8
     * 2 6
     * 8
     * 输出
     * 2 6
     */

    private static final Map<Integer, List<Integer>> tree = new TreeMap<>();

    public static void main(String[] args) {
        List<Integer> parents = new ArrayList<>();
        List<Integer> nodes = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            int num = scanner.nextInt();
            for (int i = 0; i < num; i++) {
                nodes.add(scanner.nextInt());
                parents.add(scanner.nextInt());
            }
            int rmId = scanner.nextInt();
            buildTree(parents, nodes);
            rmNode(rmId);
            tree.keySet().forEach(e -> {
                System.out.print(e);
                System.out.print(" ");
            });
            System.out.println();
        }
    }


    public static void buildTree(List<Integer> parent, List<Integer> node) {
        for (int i = 0; i < node.size(); i++) {
            Integer nodeKey = node.get(i);
            Integer parentKey = parent.get(i);
            if (!tree.containsKey(nodeKey)) {
                tree.put(nodeKey, new ArrayList<>());
            }
            if (parentKey.equals(0)) {
                continue;
            }
            List<Integer> parentList = null;
            if (tree.containsKey(parentKey)) {
                parentList = tree.get(parentKey);
            } else {
                parentList = new ArrayList<>();
                tree.put(parentKey, parentList);
            }

            parentList.add(nodeKey);
        }
    }

    public static void rmNode(Integer node) {
        List<Integer> children = tree.get(node);
        if (children == null) {
            return;
        }
        if (children.size() == 0) {
            tree.remove(node);
            return;
        }

        for (Integer child : children) {
            rmNode(child);
        }
        tree.remove(node);
    }
}
