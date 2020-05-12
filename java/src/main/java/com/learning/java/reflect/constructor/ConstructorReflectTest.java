package com.learning.java.reflect.constructor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @program java
 * @author jiuson
 * @create 2019/08/23 13:05
 * @description constructor reflect test
 */
public class ConstructorReflectTest {

    public static void main(String[] args){

        try {
            //1、通过类型获取Class对象
            Class clazz = Class.forName("com.learning.java.reflect.constructor.Person");

            //2、获取无参数构造方法对象
            Constructor constructor = clazz.getConstructor();
            /*
            Constructor对象常用方法
             */
            //获取构造方法修饰符
            int modifiers = constructor.getModifiers();
            //获取构造方法名
            String name = constructor.getName();
            //获取构造方法参数列表类型
            Class[] parameterTypes = constructor.getParameterTypes();
            //获取构造方法抛出异常列表类型
            Class[] exceptionTypes = constructor.getExceptionTypes();
            //获取构造方法参数对应的注解类型
            Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
            //获取构造方法注解
            Annotation[] annotations = constructor.getAnnotations();

            //3、通过Constructor对象获取Person对象
            Person person = (Person) constructor.newInstance();
            System.out.println("person is created, by no parameter constructor:" + person);


        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }
    }
}
