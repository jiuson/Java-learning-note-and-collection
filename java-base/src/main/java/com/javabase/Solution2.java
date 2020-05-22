package com.javabase;

import java.util.ArrayList;
import java.util.List;

/**
 * description: Solution2 <br>
 * date: 2020/1/1 17:33 <br>
 * author: user <br>
 * version: 1.0 <br>
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> integerList1 = new ArrayList<>();
        List<Integer> integerList2 = new ArrayList<>();
        while (l1 != null){
            integerList1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            integerList2.add(l2.val);
            l2 = l2.next;
        }
        if (integerList1.size() >= integerList2.size()){
            List<Integer> integerListTemp = integerList1;
            integerList1 = integerList2;
            integerList2 = integerListTemp;
        }
        Integer temp = 0;
        for (int i = 0; i < integerList2.size(); i++) {
            Integer sum = 0;
            if (i < integerList1.size()){
                sum = integerList1.get(i) + integerList2.get(i) + temp;
            }else {
                sum = integerList2.get(i) + temp;
            }
            integerList2.remove(i);
            if (sum > 9){
                String sumStr = String.valueOf(sum);
                char[] chars = sumStr.toCharArray();
                sum = Integer.valueOf(String.valueOf(chars[1]));
                temp = 1;
                integerList2.add(i, sum);
            }else {
                integerList2.add(i, sum);
                temp = 0;
            }
        }
        if (temp == 1){
            integerList2.add(1);
        }
        ListNode resultListNode = new ListNode(integerList2.get(0));
        ListNode currentListNode = resultListNode;
        for (int i = 1; i < integerList2.size(); i++) {
            currentListNode.next = new ListNode(integerList2.get(i));
            currentListNode = currentListNode.next;
        }
        return resultListNode;
    }

    public static void main(String[] args) {
        /*ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);*/
        /*ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(0);*/
        /*ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);*/
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        new Solution2().addTwoNumbers(l1, l2);
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
