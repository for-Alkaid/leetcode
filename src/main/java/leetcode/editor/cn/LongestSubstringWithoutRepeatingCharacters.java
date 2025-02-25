package leetcode.editor.cn;
//这一行为CodeFileName内容
//LongestSubstringWithoutRepeatingCharacters
 
//这一段为CodeTemplate内容，每次打开新题会自动生成main方法，代码块以内部类的形式存在
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 10601 👎 0

public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
         Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring(" "));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int idx1 = 0,idx2=0;
        String temp = "";
        int maxLength = Integer.MIN_VALUE;
        while (idx1 < s.length() || idx2 < s.length()) {
            temp = s.substring(idx1, idx2);

            if (idx2 > s.length()-1) {
                idx1++;
            }else {
                String nextValue = String.valueOf(s.charAt(idx2));
                if (temp.contains(nextValue)) {
                    idx1 = s.indexOf(nextValue, idx1)+1;
                }
                idx2++;
            }
            maxLength = Math.max(temp.length(), maxLength);

        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}