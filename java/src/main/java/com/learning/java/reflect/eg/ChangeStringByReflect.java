package com.learning.java.reflect.eg;

import java.lang.reflect.Field;

/**
 * @program java
 * @author jiuson
 * @create 2019/08/20 11:51
 * @description String对象一旦创建，其内容不允许修改
 *              通过反射修改字符串的值，而不改变当前String对象
 */
public class ChangeStringByReflect {

    public static void main(String[] args){
        try {
            //1、创建str对象
            String str = new String("abc");
            System.out.println(str.hashCode());
            //2、通过str对象获取Class对象
            Class clazz = str.getClass();
            //3、通过Class对象获取value对应的Field对象
            Field field = clazz.getDeclaredField("value");
            field.setAccessible(true);
            char[] value = (char[]) field.get(str);
            System.out.println(value.length);
            for (char temp : value) {
                System.out.println(temp);
            }
            value[0] = 'd'; value[1] = 'e'; value[2] = 'f';
            //value[3] = 'g';//此处会抛出数组越界异常
            System.out.println("修改后的str：" + str);


        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }
}
