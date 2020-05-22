package com.javabase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * description: 遍历Map <br>
 * date: 2019/12/1 19:24 <br>
 * author: chali <br>
 * version: 1.0 <br>
 */

public class TraversalMap{
	
	public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "ab");
        map.put("4", "ab");
        map.put("4", "ab");// 和上面相同 ， 会覆盖，因为HashMap不能存在相同的key
        System.out.println(map.size());
        // 第一种：
        /*
         * Set<String> set = map.keySet(); //得到所有key的集合
         *
         * for (String in : set) { String str = map.get(in);
         * System.out.println(in + "     " + str); }
         */
        System.out.println("第一种：通过Map.keySet遍历key和value：");
        for (String in : map.keySet()) {
            //map.keySet()返回的是所有key的值
            String str = map.get(in);//得到每个key多对用value的值
            System.out.println(in + "     " + str);
        }
        // 第二种：
        System.out.println("第二种：通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        // 第三种：推荐，尤其是容量大时
        System.out.println("第三种：通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            //Map.entry<String,String> 映射项（键-值对）  有几个方法：用上面的名字entry
            //entry.getKey() ;entry.getValue(); entry.setValue();
            //map.entrySet()  返回此映射中包含的映射关系的 Set视图。
            System.out.println("key= " + entry.getKey() + " and value= "
                    + entry.getValue());
        }
        // 第四种：
        System.out.println("第四种：通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }
    }
}
