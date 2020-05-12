package com.learning.java.reflect.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @program java
 * @author jiuson
 * @create 2019/08/19 22:28
 * @description annotation reflect test
 */
public class AnnotationReflectTest {

    public static void main(String[] args){
        try {
            //1、通过类名获取类对应的Class对象
            Class clazz = Class.forName("com.learning.java.reflect.annotation.Person");
            //2、通过属性名获取属性对应的Field对象
            Field field = clazz.getDeclaredField("name");
            int defaultFieldModifiers = field.getModifiers();
            System.out.println("对象默认属性的修饰符：" + defaultFieldModifiers);
            //3、通过Filed对象获取属性上的注解对象
            Annotation a = field.getAnnotation(MyAnnotation.class);
            //4、通过注解对象获取注解对应的Class对象
            Class aClass = a.getClass();
            //5、通过注解对应的Class对象获取名为value的Method对象
            Method aMethod = aClass.getMethod("value");
            //6、调用注解对象的value方法，接收返回值
            String[] result = (String[])aMethod.invoke(a);
            for (String str : result) {
                System.out.println(str);
            }
            System.out.println("---------------以下方式未使用反射，而是直接使用获得的MyAnnotation对象调用value方法---------------");
            //4、直接转换成对应的注解对象
            MyAnnotation myAnnotation = field.getAnnotation(MyAnnotation.class);
            //5、调用直接的value方法
            String[] result1 = myAnnotation.value();
            for (String str : result1) {
                System.out.println(str);
            }

            System.out.println("---------------获取方法上的注解信息--------");
            Method method = clazz.getMethod("eat", String.class);
            Annotation annotation = method.getAnnotation(MyAnnotation.class);
            Class aClass1 = annotation.getClass();
            Method method1 = aClass1.getMethod("value");
            String[] result2 = (String[])method1.invoke(annotation);
            for(String str : result2){
                System.out.println(str);
            }


        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }
    }
}
