package com.yhf.test1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test233 {
    /**
     * 题目0233-单向链表中间节点
     * 题目描述
     * 求单向链表中间的节点值，如果奇数个节点取中间，偶数个取偏右边的那个值。
     * <p>
     * 输入描述
     * 第一行 链表头节点地址 后续输入的节点数 nnn
     * <p>
     * 后续输入每行表示一个节点，格式 节点地址 节点值 下一个节点地址( -1 表示空指针)
     * <p>
     * 输入保证链表不会出现环，并且可能存在一些节点不属于链表。
     * <p>
     * 输出描述
     * 单向链表中间的节点值
     * <p>
     * 示例一
     * 输入
     * 00010 4
     * 00000 3 -1
     * 00010 5 12309
     * 11451 6 00000
     * 12309 7 11451
     * 输出
     * 6
     * 示例二
     * 输入
     * 10000 3
     * 76892 7 12309
     * 12309 5 -1
     * 10000 1 76892
     * 输出
     * 7
     * 思路解析和复杂度分析
     * 思路解析
     * 本题目要求找到单向链表中间的节点值，对于链表长度为奇数的情况，取中间节点；对于链表长度为偶数的情况，取中间偏右边的节点。解决此问题需要分为以下几个步骤：
     * <p>
     * 首先，定义一个链表节点类/结构体，用于存储节点的地址、值、下一个节点的地址以及实际的下一个节点指针。
     * 读取输入数据，从输入中获取链表头节点地址以及节点数量。对于每个节点，将其信息存储到一个哈希表/字典/映射中，以节点地址为键，节点实例为值。这样可以方便地根据地址快速查找到对应的节点。
     * 接下来，根据链表头节点地址从哈希表/字典/映射中找到头节点，然后遍历链表，将每个节点的下一个节点指针指向其下一个节点地址对应的节点实例。遍历结束后，得到完整的链表结构。
     * 寻找链表中间节点的值。使用快慢指针的方法，定义两个指针 slow 和 fast，初始时都指向头节点。每次迭代中，slow 指针移动到下一个节点，fast 指针移动到下下个节点。当 fast 指针指向空节点或者 fast 指针的下一个节点指向空节点时，slow 指针指向的就是链表的中间节点（对于链表长度为偶数的情况，此时 slow 指针指向的是中间偏右的节点）。最后返回 slow 指针指向节点的值即可。
     * 复杂度分析
     * 时间复杂度：构建链表的时间复杂度为 O(n)，因为需要遍历输入的所有节点。寻找链表中间节点的值的时间复杂度为 O(n/2)，因为 slow 指针需要走到链表中间。因此，总的时间复杂度为 O(n)。
     * 空间复杂度：使用哈希表/字典/映射存储节点信息，所以空间复杂度为 O(n)。此外，链表本身也需要 O(n) 的空间。因此，总的空间复杂度为 O(n)。
     * 总结
     * 本题使用了快慢指针的方法寻找链表中间节点的值，具有较高的时间和空间效率。在实际应用中，可以根据需要采用不同的编程语言来实现链表的构建和中间节点值的查找。
     */

    public static Node buildLinkedList(int headAddress, int n, Scanner scanner) {
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int address = scanner.nextInt();
            int value = scanner.nextInt();
            int nextAddress = scanner.nextInt();
            nodeMap.put(address, new Node(address, value, nextAddress));
        }

        Node head = nodeMap.get(headAddress);
        Node current = head;

        while (current.nextAddress != -1) {
            current.next = nodeMap.get(current.nextAddress);
            current = current.next;
        }

        return head;
    }

    public static int findMiddleValue(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int headAddress = scanner.nextInt();
        int n = scanner.nextInt();

        Node head = buildLinkedList(headAddress, n, scanner);
        int middleValue = findMiddleValue(head);

        System.out.println(middleValue);
    }
}

class Node {
    int address;
    int value;
    int nextAddress;
    Node next;

    public Node(int address, int value, int nextAddress) {
        this.address = address;
        this.value = value;
        this.nextAddress = nextAddress;
        this.next = null;
    }
}