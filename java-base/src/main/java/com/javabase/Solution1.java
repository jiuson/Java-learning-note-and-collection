package com.javabase;

/**
 * description: Solution1 <br>
 * date: 2020/1/1 9:25 <br>
 * author: user <br>
 * version: 1.0 <br>
 */
public class Solution1 {

    public int reverse(int x) {
        String str = String.valueOf(x);
        boolean flag = false;
        if (str.indexOf("-") != -1){
            flag = true;
            str = str.replaceAll("-", "").trim();
        }
        char[] cha = str.toCharArray();
        char[] chars = new char[cha.length];
        for (int i = cha.length - 1, j = 0; i >= 0; i--, j++) {
            chars[j] = cha[i];
        }
        str = new String(chars);
        if (flag){
            str = "-" + str;
        }
        long l = Long.parseLong(str.trim());
        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE){
            return 0;
        }
        x = Integer.valueOf(str.trim());
        return x;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().reverse(-2147483648));
    }
}
