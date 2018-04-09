package com.lc.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Leetcode
 * @description: Leetcode刷题
 * @author: lic
 * @create: 2018-04-02 15:27
 **/
public class Leetcode {


    /**
     * 两数之和   :
     * 给定一个整数数列，找出其中和为特定值的那两个数。
     * 你可以假设每个输入都只会有一种答案，同样的元素不能被重用。
     * <p>
     * 示例：
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * @param nums
     * @param target
     * @return 和为 target 两个数的下标
     */
    public static int[] twoSum(int[] nums, int target) {


        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int v = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == v && j != i) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }


    /**
     * 002 两数相加
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * 问题描述：给定两个非空的链表，表示两个非负整数。
     * 数字以相反的顺序存储，每个节点包含一个数字。 添加两个数字并将其作为链表返回。
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;

        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3 = newHead;

        while (p1 != null || p2 != null) {
            if (p1 != null) {
                carry += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }

            p3.next = new ListNode(carry % 10);
            p3 = p3.next;
            carry /= 10;
        }

        if (carry == 1) {
            p3.next = new ListNode(1);
        }
        return newHead.next;

    }


    /**
     * 003 无重复字符的最长子串
     * 给定一个字符串，找出不含有重复字符的 最长子串 的长度。
     * 示例：给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
     * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列 而不是子串。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int start = 0, result = 0, length = s.length();
        Map<Character, Integer> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch) && map.get(ch) >= start) {
                start = map.get(ch) + 1;
            } else {
                result = Math.max(result, i - start + 1);
            }
            map.put(ch, i);
        }

        return result;

    }

    /**
     * 004  两个数组的中位数
     * 有两个大小为 m 和 n 的排序数组 nums1 和 nums2 。
     * 请找出两个排序数组的中位数并且总的运行时间复杂度为 O(log (m+n)) 。
     * <p>
     * 示例：
     * nums1 = [1, 3]
     * nums2 = [2]
     * 中位数是 2.0
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            nums1 = new int[0];
        }

        if (nums2 == null) {
            nums2 = new int[0];
        }

        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 < len2) { //确保第一个数组比第二个数组长度大
            return findMedianSortedArrays(nums2, nums1);
        }

        // 如果长度小的数组长度为0，就返回前一个数组的中位数
        if (len2 == 0) {
            return (nums1[(len1 - 1) / 2] + nums1[len1 / 2]) / 2.0;
        }


        int lo = 0;
        int hi = len2 * 2;
        int mid1;
        int mid2;
        double l1;
        double l2;
        double r1;
        double r2;

        while (lo <= hi) {
            mid2 = (lo + hi) / 2;
            mid1 = len1 + len2 - mid2;

            l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];

            r1 = (mid1 == len1 * 2) ? Integer.MAX_VALUE : nums1[mid1 / 2];
            r2 = (mid2 == len2 * 2) ? Integer.MAX_VALUE : nums2[mid2 / 2];

            if (l1 > r2) {
                lo = mid2 + 1;
            } else if (l2 > r1) {
                hi = mid2 - 1;
            } else {
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
            }
        }

        return -1;
    }


    /**
     * 007  颠倒整数
     * 给定一个范围为 32 位 int 的整数，将其颠倒。
     * 例 1:
     * 输入: 123
     * 输出:  321
     * 例 2:
     * 输入: -123
     * 输出: -321
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? 0 : (int) res;

    }


    /**
     * 回文数 009
     *
     * @param x
     * @return
     */

    public static boolean isPalindrome(int x) {


      /*  if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;                         //注意这个过程
        }

        return x == revertedNumber || x == revertedNumber/10;
        */

        //此方法实现判断数字是不是回文数   此方法为百度提供的方法
        //思路： 翻转后比较

        String num = String.valueOf(x);
        return new StringBuffer(num).reverse().toString().equalsIgnoreCase(num);
    }


    /**
     * 罗马数字转int 013
     * 返回的结果要求在 1 到 3999 的范围内。
     *
     * @param s
     * @return
     */
    /*
     public static int romanToInt(String s) {
        int[] tagVal = new int[256];
        tagVal['I'] = 1;
        tagVal['V'] = 5;
        tagVal['X'] = 10;
        tagVal['L'] = 50;
        tagVal['C'] = 100;
        tagVal['D'] = 500;
        tagVal['M'] = 1000;
        int val = 0;
        for(int i = 0; i < s.length(); i++){
            if(i+1 >= s.length() || tagVal[s.charAt(i+1)] <= tagVal[s.charAt(i)])
                val += tagVal[s.charAt(i)];
            else
                val -= tagVal[s.charAt(i)];
        }
        return val;
    }*/


    //此代码为Leetcode效率最高的代码  51ms
    public static int romanToInt(String s) {
        if (s.length() < 1) {
            return 0;
        }
        int result = 0;
        int sub = getRomanValue(s.charAt(0));
        int lastv = sub;
        for (int i = 1; i < s.length(); i++) {
            char curc = s.charAt(i);
            int curv = getRomanValue(curc);
            if (curv == lastv) {
                sub += curv;
            } else if (curv < lastv) {
                result += sub;
                sub = curv;
            } else {
                sub = curv - sub;
            }
            lastv = curv;
        }
        result += sub;
        return result;
    }

    private static int getRomanValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }


    /**
     * 最长公共前缀 0014
     * @param strs
     * @return
     */

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0 || strs[0].length() == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int i = 0;
        while (i < strs[0].length()) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i + 1 || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
            i++;
        }
        return strs[0];

    }


    /**
     * 宝石与石头   771
     * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
     * S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     * 示例 1:
     * 输入: J = "aA", S = "aAAbbbb"
     * 输出: 3
     *
     * @param J
     * @param S
     * @return
     */
    public static int numJewelsInStones(String J, String S) {
        int i = 0;
        int jLen = J.length();
        int sLen = S.length();
        for (int j = 0; j < jLen; j++) {
            for (int s = 0; s < sLen; s++) {
                if (J.charAt(j) == S.charAt(s)) {
                    i++;
                }
            }
        }
        return i;
    }


}
