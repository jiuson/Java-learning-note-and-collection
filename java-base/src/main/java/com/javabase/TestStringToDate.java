package com.javabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description: TestStringToDate <br>
 * date: 2019/12/1 19:24 <br>
 * author: chali <br>
 * version: 1.0 <br>
 */
public class TestStringToDate {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse("2018-07-25 17:24:30");
        System.out.println(date);
    }
}
