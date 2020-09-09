package com.javabase;

/**
 * @ProjectName: java-base
 * @Author chali
 * @Description 包装类型初始化默认值
 * @Date 2020/9/9 10:48 上午
 */
public class TestIntegerInit {

    private Integer i;//初始化的时候会置null值
    private int j;//初始化的时候会置0值

    public static void main(String[] args) {
        TestIntegerInit testIntegerInit = new TestIntegerInit();
        System.out.println("Integer i = " + testIntegerInit.i);
        System.out.println("int j = " + testIntegerInit.j);
    }
}
