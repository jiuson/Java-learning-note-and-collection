package com.javabase;

import java.util.ArrayList;
import java.util.List;

/**
 * description: Test <br>
 * date: 2019/12/1 20:10 <br>
 * author: user <br>
 * version: 1.0 <br>
 */
public class Solution {

    List<Integer> list = new ArrayList<Integer>();
    public boolean findTarget(TreeNode root, int k) {
        inOrder(root);
        int head = 0;
        int tail = list.size() - 1;
        while(head < tail) {
            if(list.get(head) + list.get(tail) == k) {
                return true;
            }
            if(list.get(head) + list.get(tail) < k) {
                head++;
            }
            if(list.get(head) + list.get(tail) > k) {
                tail--;
            }
        }
        return false;
    }
    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }


    public static void main(String[] args) {
//        boolean result = false;
//        List<Integer> integerList = new ArrayList<>();
//        integerList.add(24);
//        integerList.add(16);
//        integerList.add(32);
//        integerList.add(8);
//        for (int i = 0; i < integerList.size(); i++) {
//            int m = 48 - integerList.remove(i);
//            if (integerList.contains(m)) {
//                result = true;
//            }
//        }
//        System.out.println(result);
        TreeNode root = new TreeNode(24);
        root.left = new TreeNode(16);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(32);
        System.out.println(new Solution().findTarget(root, 48));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
