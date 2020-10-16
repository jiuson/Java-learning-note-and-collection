package com.javabase;

/**
 * @ProjectName: java-base
 * @Author chali
 * @Description 测试类继承的问题
 * @Date 2020/10/16 9:36 上午
 */
public class ClassExtendsTest {

    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();
        animal.move();
        dog.move();
        //dog.bark();//Animal类里面没有bark方法，故用Animal作为Dog的对象应用，就不能调用Dog类专有的bark方法
    }
}

class Animal {
    public void move() {
        System.out.println("move animal");
    }
}
class Dog extends Animal {
    public void move() {
        System.out.println("move dog");
    }
    public void bark() {
        System.out.println("bark dog");
    }
}