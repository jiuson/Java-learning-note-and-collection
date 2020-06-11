package com.javabase;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chali
 * @desc set排序测试
 * @date 2020-06-11-6:42 下午
 */
public class TestSetSorted {

    //268701696, 537133056, 537149440, 470031360, 537141248, 402929664, 134481920
    public static void main(String[] args) {
        Set<Long> longSet = new HashSet<Long>();
        longSet.add((long) 268701696);
        longSet.add((long) 537133056);
        longSet.add((long) 537149440);
        longSet.add((long) 470031360);
        longSet.add((long) 537141248);
        longSet.add((long) 402929664);
        longSet.add((long) 134481920);

        longSet.stream().sorted(Comparator.comparing(Long :: longValue));
        System.out.println(longSet.toArray());
    }
}
