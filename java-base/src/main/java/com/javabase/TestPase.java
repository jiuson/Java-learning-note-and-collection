package com.javabase;

import java.util.HashMap;
import java.util.Map;

public class TestPase {

    public static void main(String[] args) {
        Map image = new HashMap();
        image.put("isGif", false);

        if (image.get("isGif") != null && (image.get("isGif").toString().equalsIgnoreCase("false") || image.get("isGif").toString().equalsIgnoreCase("1"))) {
//            if (image.get("isGif").toString().equalsIgnoreCase("false") || image.get("isGif").toString().equalsIgnoreCase("1")){
                System.out.println("hahahhahahhahha");
//            }
        }
    }
}
