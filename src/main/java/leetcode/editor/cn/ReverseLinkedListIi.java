package leetcode.editor.cn;
//这一行为CodeFileName内容
//ReverseLinkedListIi

//这一段为CodeTemplate内容，每次打开新题会自动生成main方法，代码块以内部类的形式存在
//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics 链表 👍 1945 👎 0

import leetcode.ListNode;

import java.util.List;

public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        System.out.println(solution.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4, new ListNode(5))))), 2,4).toString());
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode protect = new ListNode(0, head);
            // 前驱
            ListNode pre = skip(protect, left - 1);
            ListNode leftNode = skip(protect, left);
            // 后继
            ListNode rightNode = skip(protect, right);
            ListNode after = rightNode.next;
            // 反转
            reverse(leftNode, rightNode.next);
            // 组外链接
            pre.next = rightNode;
            leftNode.next = after;
            return protect.next;
        }

        private ListNode skip(ListNode head, int k) {
            while (head != null) {
                if (k <= 0) return head;
                k--;
                head = head.next;
            }
            return head;
        }

        private ListNode reverse(ListNode head, ListNode end) {
            ListNode pre = head;
            head = head.next;
            while (head != end) {
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}