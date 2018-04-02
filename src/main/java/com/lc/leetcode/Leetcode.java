package com.lc.leetcode;


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
     *
     * 示例：
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * @param nums
     * @param target
     * @return  和为 target 两个数的下标
     */
    public static int[] twoSum(int[] nums, int target) {


        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int v = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == v && j != i){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }


    /**
     *
     * 002 两数相加
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * 问题描述：给定两个非空的链表，表示两个非负整数。
     * 数字以相反的顺序存储，每个节点包含一个数字。 添加两个数字并将其作为链表返回。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry =0;

        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3=newHead;

        while(p1 != null || p2 != null){
            if(p1 != null){
                carry += p1.val;
                p1 = p1.next;
            }

            if(p2 != null){
                carry += p2.val;
                p2 = p2.next;
            }

            p3.next = new ListNode(carry%10);
            p3 = p3.next;
            carry /= 10;
        }

        if(carry==1) {
            p3.next = new ListNode(1);
        }
        return newHead.next;

    }


    /**
     * 003 无重复字符的最长子串
     *给定一个字符串，找出不含有重复字符的 最长子串 的长度。
     * 示例：给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
     * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列 而不是子串。
     * @param s
     * @return
     */
    public static  int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        int start = 0,result = 0,length = s.length();
        Map<Character,Integer> map = new HashMap<>(length);
        for(int i =0; i <length; i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch) && map.get(ch) >=start){
                start = map.get(ch)+1;
            }else{
                result = Math.max(result,i - start+1);
            }
            map.put(ch,i);
        }

        return result;

    }

    /**
     *004  两个数组的中位数
     *有两个大小为 m 和 n 的排序数组 nums1 和 nums2 。
     * 请找出两个排序数组的中位数并且总的运行时间复杂度为 O(log (m+n)) 。
     *
     *  示例：
     *  nums1 = [1, 3]
     *  nums2 = [2]
     *  中位数是 2.0
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null){
            nums1 = new int[0];
        }

        if(nums2 == null){
            nums2 = new int[0];
        }

        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len1 < len2){ //确保第一个数组比第二个数组长度大
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





}
