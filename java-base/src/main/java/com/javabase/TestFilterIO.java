package com.javabase;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * description: TestFilterIO <br>
 * date: 2019/12/9 15:05 <br>
 * author: user <br>
 * version: 1.0 <br>
 */
public class TestFilterIO {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\user\\Desktop\\mongodb索引-彭冲.txt");
        InputStream inputStream = new FileInputStream(file);
        inputStream.read();
        inputStream.available();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        bufferedInputStream.read();
    }
}
