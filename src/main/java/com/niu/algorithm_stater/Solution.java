package com.niu.algorithm_stater;

/**
 * Created by ami on 2019/5/26.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode func(ListNode l1, ListNode l2) {
        ListNode flag = new ListNode(0);
        ListNode firstflag = flag;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                flag.next = l1;
                l1 = l1.next;
            } else {
                flag.next = l2;
                l2 = l2.next;
            }
            flag = flag.next;
        }
        flag.next = l1 != null ? l1 : l2;
        return firstflag.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        ListNode l = new Solution().func(l1,l2);
        System.out.println(l.val);
        System.out.println(l.next.val);
        System.out.println(l.next.next.val);
        System.out.println(l.next.next.next.val);
        System.out.println(l.next.next.next.next.val);
        System.out.println(l.next.next.next.next.next.val);

    }
}


