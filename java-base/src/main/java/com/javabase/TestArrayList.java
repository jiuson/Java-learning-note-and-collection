package com.javabase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * description: TestArrayList <br>
 * date: 2020/1/1 11:56 <br>
 * author: user <br>
 * version: 1.0 <br>
 */
public class TestArrayList {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        System.out.println(stringList.size());
        stringList.add("a");
        stringList.add("a");
        /*for (int i = 0; i < stringList.size(); i++){
            if (stringList.get(i).equals("a")){
                stringList.remove(i);
            }
        }*/
        Iterator<String> stringIterator = stringList.iterator();
        while (stringIterator.hasNext()){
            if (stringIterator.next().equals("a")){
                stringIterator.remove();
            }
        }
        System.out.println(stringList);
    }
}
