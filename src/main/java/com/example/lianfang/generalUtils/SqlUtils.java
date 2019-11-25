package com.example.lianfang.generalUtils;

import java.util.HashMap;
import java.util.Map;

public class SqlUtils {
    public static String success = "{\"status\":\"SUCCESS\"}";
    public static String wrong = "{\"status\":\"FAILURE\"}";
    public static Map getMap(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("status","SUCCESS");
        return map;
    }


}
