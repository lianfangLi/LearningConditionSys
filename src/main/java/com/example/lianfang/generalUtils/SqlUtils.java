package com.example.lianfang.generalUtils;

import java.util.HashMap;
import java.util.Map;

public class SqlUtils {
    public static String success = "{\"status\":\"SUCCESS\"}";
    public static String wrong = "{\"status\":\"FAILURE\"}";
    public static Map getMap(){
        return new HashMap<String,String>();
    }


}
