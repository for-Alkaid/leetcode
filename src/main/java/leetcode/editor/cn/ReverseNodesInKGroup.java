package leetcode.editor.cn;
//这一行为CodeFileName内容
//ReverseNodesInKGroup
 
//这一段为CodeTemplate内容，每次打开新题会自动生成main方法，代码块以内部类的形式存在
//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 2530 👎 0

import leetcode.ListNode;

public class ReverseNodesInKGroup{

    public static void main(String[] args) {
         Solution solution = new ReverseNodesInKGroup().new Solution();
        solution.reverseKGroup(new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode protect = new ListNode(0);
        ListNode last = protect;
        while (head != null) {
            // 1 划分k个一组
            ListNode end = kGroup(head, k);
            if (end == null) break;
            ListNode next = end.next;
            // 2 组内反转
            reverse(head, next);
            // 3 组外处理
            last.next = end;
            head.next = next;
            last = head;
            head = next;
        }

        return protect.next;
    }

    public ListNode reverse(ListNode head, ListNode end) {
        ListNode pre = null;
        while (head != end) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return head;
    }


    public ListNode kGroup(ListNode head, int k) {
        while (head != null) {
            k--;
            if (k == 0) return head;
            head = head.next;
        }
        return null;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}