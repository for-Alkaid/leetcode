//这一行为CodeFileName内容
//AddTwoNumbers
 
//这一段为CodeTemplate内容，每次打开新题会自动生成main方法，代码块以内部类的形式存在
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 11068 👎 0

package leetcode.editor.cn;

import leetcode.ListNode;

public class AddTwoNumbers{
    public static void main(String[] args) {
         Solution solution = new AddTwoNumbers().new Solution();
        solution.addTwoNumbers(new ListNode(1), new ListNode(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int l1Index = 0, l2Index = 1;
        int temp = 0;
        ListNode headNode = new ListNode();
        ListNode tempNode = headNode;
        while (l1 != null || l2 != null) {
            int v1 = l1==null?0:l1.val;
            int v2 = l2==null?0:l2.val;
            int value = v1 + v2 + temp;
            temp = 0;
            if (value >= 10) {
                temp = 1;
                value = value % 10;
            }
            tempNode.next = new ListNode(value);
            tempNode = tempNode.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (temp == 1) {
            tempNode.next = new ListNode(1);
        }
        return headNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}