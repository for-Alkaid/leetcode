//这一行为CodeFileName内容
//PalindromeNumber
 
//这一段为CodeTemplate内容，每次打开新题会自动生成main方法，代码块以内部类的形式存在
//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 
// 例如，121 是回文，而 123 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
//
// Related Topics 数学 👍 2960 👎 0

package leetcode.editor.cn;

public class PalindromeNumber{
    public static void main(String[] args) {
         Solution solution = new PalindromeNumber().new Solution();
         
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        int num = 0;
        int originalNum = x;  // 记录原始值，用于判断回文数是否和自身相等
        while (x > 0) {
            int temp = x % 10;
            num = num * 10 + temp;
            x = x / 10;
        }
        return num == originalNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}