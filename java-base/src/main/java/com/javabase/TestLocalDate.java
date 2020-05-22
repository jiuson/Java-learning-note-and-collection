package com.javabase;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class TestLocalDate {

    public static void main(String[] args) {
        // 取当前日期：
        LocalDate today = LocalDate.now();
        System.out.println(today);// -> 2019-11-05
        System.out.println(today.toString());// -> 2019-11-05

        // 根据年月日取日期，12月就是12：
        LocalDate crischrismas = LocalDate.of(2019, 12, 25);
        System.out.println(crischrismas);

        // 根据字符串取：
        LocalDate endOfFeb = LocalDate.parse("2019-02-28");// 严格按照ISO yyyy-MM-dd验证，02写成2都不行，当然也有一个重载方法允许自己定义格式
        System.out.println(endOfFeb);
//        LocalDate.parse("2019-02-29");// 无效日期无法通过：DateTimeParseException: Invalid date

        long time = System.currentTimeMillis();
        Date date = new Date(time);
        System.out.println(date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(simpleDateFormat1.format(new Date()));
    }
}
