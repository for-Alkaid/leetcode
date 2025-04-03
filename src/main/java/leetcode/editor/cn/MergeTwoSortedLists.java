package leetcode.editor.cn;
//这一行为CodeFileName内容
//MergeTwoSortedLists
 
//这一段为CodeTemplate内容，每次打开新题会自动生成main方法，代码块以内部类的形式存在
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics 递归 链表 👍 3742 👎 0

import leetcode.ListNode;

public class MergeTwoSortedLists{
    public static void main(String[] args) {
         Solution solution = new MergeTwoSortedLists().new Solution();
         solution.mergeTwoLists(new ListNode(1, new ListNode(2)), new ListNode(2, new ListNode(3)));
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode protect = new ListNode(0, list1);
        while (list1 != null) {
            if (list2 == null || list1.val < list2.val) {
                list1 = list1.next;
            }
            else {
                ListNode list1Next = list1.next;
                list1.next = list2;
                ListNode list2Next = list2.next;
                list2.next = list1Next;
                list2 = list2Next;
            }
        }
        return protect.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}