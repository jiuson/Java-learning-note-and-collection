package com.javabase;

/**
 * description: ClassLoaderTest <br>
 * date: 2019/12/8 11:05 <br>
 * author: user <br>
 * version: 1.0 <br>
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader.toString());
            classLoader = classLoader.getParent();
        }
    }
}
