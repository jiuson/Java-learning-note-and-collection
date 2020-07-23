package com.javabase;

/**
 * @ProjectName: java-base
 * @Author chali
 * @Description test
 * @Date 2020/7/13 5:44 下午
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().isPalindrome(0));
    }

    public boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        String reverseXStr = new StringBuilder(xStr).reverse().toString();
        return xStr.equalsIgnoreCase(reverseXStr);
    }
}
