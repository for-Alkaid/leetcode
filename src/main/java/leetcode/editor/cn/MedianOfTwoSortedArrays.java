package leetcode.editor.cn;
//这一行为CodeFileName内容
//MedianOfTwoSortedArrays
 
//这一段为CodeTemplate内容，每次打开新题会自动生成main方法，代码块以内部类的形式存在
//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7397 👎 0

public class MedianOfTwoSortedArrays{
    public static void main(String[] args) {
         Solution solution = new MedianOfTwoSortedArrays().new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{4}, new int[]{1,2,3}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int idx1=0,idx2=0, count =1;
        int l1 = nums1.length;
        int l2 = nums2.length;
        int mid = (l1 + l2)/2 +1;
        boolean flag = (l1 + l2)%2 == 0;
        Double pre = null , now =null;
        double res = 0;
        if (l1 ==0 && l2==0) {
            return 0;
        }
        if (l1 == 0) {
            if (flag) {
                return (nums2[mid-2] + nums2[mid - 1]) / 2.0;
            }else {
                return nums2[mid-1];
            }
        }
        if (l2 == 0) {
            if (flag) {
                return (nums1[mid-2] + nums1[mid - 1]) / 2.0;
            }else {
                return nums1[mid-1];
            }
        }
        // 1 | 2,3
        // 1,2 | 3
        while (idx1 < l1 || idx2 < l2) {
            if (idx1 >= l1) {
                pre = now;
                now = nums2[idx2]*1.0;
                idx2++;
            }
            else if (idx2>=l2) {
                pre = now;
                now = nums1[idx1]*1.0;
                idx1++;
            }
            else if(nums1[idx1] < nums2[idx2]) {
                pre = now;
                now = nums1[idx1]*1.0;
                idx1++;
            }
            else {
                pre = now;
                now = nums2[idx2]*1.0;
                idx2++; // 1
            }
            if (count == mid) {
                if (flag) {
                    return (pre + now) / 2;
                } else {
                    return now;
                }
            }
            count++;

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


// 4 | 1,2,3
// d2 =1 , idx3 = 1, d1=null
// d2 = 2, idx3 = 2, d1=null
// d2 = 3 ,idx3 = 3 ,d1 =null \/