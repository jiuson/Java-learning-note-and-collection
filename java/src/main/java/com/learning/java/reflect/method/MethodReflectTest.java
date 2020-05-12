package com.learning.java.reflect.method;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program java
 * @author jiuson
 * @create 2019/08/23 12:33
 * @description test method reflect
 */
public class MethodReflectTest {

    public static void main(String[] args){
        try {
            //1、通过类名获取class对象
            Class clazz = Class.forName("com.learning.java.reflect.method.Person");
            Person person = (Person) clazz.newInstance();

            //2、通过class对象获取run方法
            Method method = clazz.getMethod("run", String.class);
            /*
            Method对象中常用的方法
             */
            //获取方法修饰符
            int modifiers = method.getModifiers();
            //获取方法名
            String methodName = method.getName();
            //获取方法参数列表类型
            Class[] parameterTypes = method.getParameterTypes();
            //获取方法抛出异常列表类型
            Class[] exceptionTypes = method.getExceptionTypes();
            //获取方法参数列表对应的注解类型
            Annotation[][] annotations = method.getParameterAnnotations();
            //获取方法的返回值类型
            Class returnType = method.getReturnType();
            //获取方法注解类型
            Annotation[] annotations1 = method.getAnnotations();

            //3、通过反射调用方法
            String result = (String) method.invoke(person, "abc");
            System.out.println("method run is invoked success, return value is:" + result);



            Method[] methods = clazz.getMethods();
            Method method1 = clazz.getDeclaredMethod("eat", String.class);
            Method[] methods1 = clazz.getDeclaredMethods();


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
