package com.javabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chali
 * @desc 测试通过stream将list转换成set
 * @date 2020-07-01-4:12 下午
 */
public class TestListStream {

    public static void main(String[] args) {
        List<Long> longList = new ArrayList<Long>();

        longList.add(100l);
        longList.add(100l);
        longList.add(200l);
        longList.add(300l);

        Set<Long> longSet = longList.stream().collect(Collectors.toSet());

        System.out.println(longList.size() == longSet.size());
    }
}
