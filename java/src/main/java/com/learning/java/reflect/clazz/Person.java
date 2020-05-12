package com.learning.java.reflect.clazz;

/**
 * @program java
 * @author jiuson
 * @create 2019/08/20 12:08
 * @description test person object
 */

@MyAnnotation("person")
public class Person implements PersonInterface{

    public String name;
    private String address;
    private Integer age;


    /*
    无参数构造方法
     */
    public Person() {
        System.out.println("there is no parameter constructor");
    }

    /*
    有参数构造方法
     */
    public Person(String name) {
        this.name = name;
        System.out.println("there is parameter constructor");
    }

    private Person(int age){
        this.age = age;
        System.out.println("there is parameter private constructor");
    }

    public void eat(String param){
        System.out.println("this is eat method, param is :" + param);
    }

    public void eat(String param, int num){
        System.out.println("this is eat overload method, param is :" + param + ", " + num);
    }

    private void run(String param){
        System.out.println("this is run method, param is :" + param);
    }

    public void sing(String param) {
        System.out.println("this is sing method implement from PersonInterface, param is :" + param);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
