package com.learning.java.reflect.clazz;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program java
 * @author jiuson
 * @create 2019/08/20 16:37
 * @description Class reflect test
 */
public class ClassReflectTest {

    public static void main(String[] args){

        try {
            Class clazz = Class.forName("com.learning.java.reflect.clazz.Person");

            int modifiers = clazz.getModifiers();
            String name = clazz.getName();
            String simpleName = clazz.getSimpleName();
            Package p = clazz.getPackage();
            ClassLoader classLoader = clazz.getClassLoader();
            System.out.println("classLoader is :" + classLoader);
            Person person = (Person) clazz.newInstance();

            //通过Class对象获取Field对象
            Field field = clazz.getField("name");
            Field field1 = clazz.getDeclaredField("address");
            Field[] fields = clazz.getFields();
            Field[] fields1 = clazz.getDeclaredFields();

            //通过Class对象获取Method对象
            Method method = clazz.getMethod("eat", String.class);
            Method method1 = clazz.getDeclaredMethod("run", String.class);
            Method[] methods = clazz.getMethods();
            Method[] methods1 = clazz.getDeclaredMethods();

            //通过Class对象获取Constructor对象
            System.out.println("-------------constructor-------------");
            Constructor constructor = clazz.getConstructor(String.class);
            Constructor constructor1 = clazz.getDeclaredConstructor(int.class);
            Constructor[] constructors = clazz.getConstructors();
            Constructor[] constructors1 = clazz.getDeclaredConstructors();

            //通过Class对象获取Annotation对象
            Annotation annotation = clazz.getAnnotation(MyAnnotation.class);
            Annotation[] annotations = clazz.getAnnotations();

            System.out.println("-----------superclass----------");
            Class sClass = clazz.getSuperclass();
            System.out.println("person's super class is : " + sClass.getName());

            System.out.println("------------interface-----------");
            Class[] interfaces = clazz.getInterfaces();
            System.out.println("person implemented interfaces:");
            for (Class c : interfaces) {
                System.out.println(c.getName());
            }


            System.out.println("---------------annotation--------------");
            boolean isAnnotation = clazz.isAnnotation();
            boolean isAnnotationPresent = clazz.isAnnotationPresent(MyAnnotation.class);
            System.out.println(isAnnotation + ", " + isAnnotationPresent);




        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }


    }
}
