package com.learning.java.reflect.field;

import java.lang.reflect.Field;

/**
 * @program java
 * @author jiuson
 * @create 2019/08/20 11:26
 * @description field reflect test
 */
public class FieldReflectTest {

    public static void main(String[] args){
        try {
            //1、通过类名获取Class对象
            Class clazz = Class.forName("com.learning.java.reflect.field.Person");
            Person person = (Person) clazz.newInstance();//相当于调用Person的无参数构造函数创建Person对象
            //2、通过Class对象，根据属性名称获取Filed对象
            Field field = clazz.getField("name");//(公有属性)
            Field field1 = clazz.getDeclaredField("age");//私有属性
            Field field2 = clazz.getDeclaredField("address");//默认属性（包级别属性）
            System.out.println("----------------Field常用方法--------------");
            //获取属性修饰符
            int fieldModifiers = field.getModifiers();
            System.out.println("属性修饰符：" + fieldModifiers);
            //获取属性名
            String name = field.getName();
            System.out.println("属性名：" + name);
            //给属性设置值
            field.set(person, "person_name");
            //如果是私有属性，想要通过反射设置值，还需要下面一步,设置私有属性可以访问
            field1.setAccessible(true);
            field1.set(person, 10);
            field2.set(person, "person_address");
            System.out.println("设置值之后的person对象：" + person);

            System.out.println("---------------获取所有属性的两种方式--------------");
            Field[] fields = clazz.getFields();
            for (Field fieldTemp : fields) {
                System.out.println(fieldTemp.getName());
            }
            System.out.println("-------------------------");
            Field[] fields1 = clazz.getDeclaredFields();
            for (Field fieldTemp : fields1) {
                System.out.println(fieldTemp.getName());
            }

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }
}
