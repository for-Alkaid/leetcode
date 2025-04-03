package leetcode.editor.cn;
//这一行为CodeFileName内容
//AddStrings
 
//这一段为CodeTemplate内容，每次打开新题会自动生成main方法，代码块以内部类的形式存在
//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
//
// Related Topics 数学 字符串 模拟 👍 863 👎 0

public class AddStrings{
    public static void main(String[] args) {
         Solution solution = new AddStrings().new Solution();
         
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        String res = "";
        int temp = 0;
        int idx1=num1.length()-1,idx2=num2.length()-1;
        while (idx1 >= 0 || idx2 >= 0) {
            int i1 = idx1<0?0:num1.codePointAt(idx1) - '0';
            int i2 = idx2<0?0:num2.codePointAt(idx2) - '0';
            char x;
            int sum = i1 + i2 + temp;
            temp = 0;
            if (sum >= 10) {
                x = (char) ('0' + (sum %10));
                temp = 1;
            }else {
                x = (char) ('0' + sum);
            }
            res = x + res;
            idx1--;
            idx2--;
            if (idx1 < 0 && idx2 <0 && temp > 0) {
                res = (char)('0' + temp) + res;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}