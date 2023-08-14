package com.yhf.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test137 {
    /**
     * 题目0137-二叉树层次遍历
     * 题目描述
     * 有一棵二叉树
     * 每一个节点用一个大写字母标识
     * 最多26个节点
     * 现有两组字母
     * 分别表示后序遍历（左孩子指向右孩子指向父节点）
     * 和中序遍历（左孩子指向父节点指向右孩子）
     * 请输出层次遍历的结果
     *
     * 输入描述
     * 输入为两个字符串
     * 分别为二叉树的后序遍历和中序遍历结果
     *
     * 输出描述
     * 输出二叉树的层次遍历结果
     *
     * 示例一
     * 输入
     * CBEFDA CBAEDF
     * 输出
     * ABDCEF
     */

    private static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
        }
    }

    private static class Tree {
        Node root;

        public Tree() {
            this.root = null;
        }

        public static Tree createTree(char[] post, char[] in) {
            Tree res = new Tree();
            res.root = createTree(post, 0, post.length - 1, in, 0, in.length - 1);
            return res;
        }

        private static Node createTree(char[] post, int s1, int end1, char[] in, int s2, int end2) {
            if (s1 > end1 || s2 > end2) {
                return null;
            }
            Node root = new Node(post[end1]);
            for (int i = s2; i <= end2; i++) {
                if (post[end1] == in[i]) {
                    root.left = createTree(post, s1, s1 + i - s2 - 1, in, s2, i - 1);
                    root.right = createTree(post, s1 + i - s2, end1 - 1, in, i + 1, end2);
                    break;
                }
            }
            return root;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        char[] post = split[0].toCharArray();
        char[] in = split[1].toCharArray();

        Tree t = Tree.createTree(post, in);

        ArrayList<Character> wide = wide(t.root);
        StringBuilder builder = new StringBuilder();
        wide.forEach(builder::append);
        System.out.println(builder);

    }

    public static ArrayList<Character> wide(Node root) {
        ArrayList<Character> lists = new ArrayList<>();
        if (root == null)
            return lists;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            lists.add(node.data);
        }
        return lists;
    }
}
