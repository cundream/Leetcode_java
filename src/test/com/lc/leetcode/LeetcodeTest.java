package com.lc.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @program: Leetcode
 * @description: Leetcode测试
 * @author: lic
 * @create: 2018-04-02 15:31
 **/
public class LeetcodeTest {


    @Test
    public void leetcode_twoSum_test001() throws  Exception{
        int[] twoSum = Leetcode.twoSum(new  int[]{2,7,11,15},9);
        print(twoSum);

    }

    @Test
    public void leetcode_addTwoNumbers_test002() throws  Exception{
        ListNode l = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l.next = l2;
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l4.next = l5;
        l5.next = l6;

        ListNode listNode = Leetcode.addTwoNumbers(l,l4);
        while (listNode.next != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    @Test
    public void leetcode_lengthOfLongestSubstring_test003() throws  Exception{
        int i = Leetcode.lengthOfLongestSubstring("pwwkew");
        print(i);
    }

    @Test
    public void leetcode_findMedianSortedArrays_test004() throws  Exception{

        double sorted = Leetcode.findMedianSortedArrays(new int[]{1, 2},new int[]{3,4});
        print(sorted);
    }

    @Test
    public void leetcode_reverse_test007() throws  Exception{
        print(Leetcode.reverse(123));//321
        print(Leetcode.reverse(-123));//-321
        print(Leetcode.reverse(1234546499));//0
    }

    @Test
    public void leetcode_isPalindrome_test009() throws  Exception{
        print(Leetcode.isPalindrome(123));//false
       // print(Leetcode.isPalindrome(-123));//false
       // print(Leetcode.isPalindrome(12321));//true
    //    print(Leetcode.isPalindrome(123321));//true
    }

    @Test
    public void leetcode_romanToInt_test013() throws  Exception{
        print(Leetcode.romanToInt("IMMMM"));//3999
    }

    @Test
    public void leetcode_longestCommonPrefix_test014() throws Exception{

       // print(Leetcode.longestCommonPrefix(new String[]{"sffbda","dafsa","fsasfdaf","ffsdaf","fdsfdda","dafsa1287"}));
        print(Leetcode.longestCommonPrefix(new String[]{"a","b"}));
    }


    private void print(int[] arrays) {
        Arrays.stream(arrays).forEach(System.out::println);
    }

    private void print(Object o) {
        System.out.println(o);
    }

    private void print(OptionalInt optionalInt) {
        System.out.println(optionalInt.getAsInt());
    }
}
