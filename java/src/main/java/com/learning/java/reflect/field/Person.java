package com.learning.java.reflect.field;

/**
 * @program java
 * @author jiuson
 * @create 2019/08/20 11:19
 * @description test object
 */
public class Person {

    /*
    成员变量修饰符不同，反射获取属性的方式不同
     */
    public String name;
    private Integer age;
    String address;

    /*
    无参数构造方法
     */
    public Person(){
        System.out.println("there is no parameter constructor");
    }

    /*
    有参数构造方法
     */
    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
        System.out.println("there is parameter constructor ");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
