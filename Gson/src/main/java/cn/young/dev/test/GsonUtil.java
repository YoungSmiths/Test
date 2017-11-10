package cn.internetware.yancloud.dataretention.common.utils;

import com.google.gson.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @ Desc
 * @ Author YoungSmith
 * @ Date 17-10-18 下午11:24
 */
public class GsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(GsonUtil.class);

    private static GsonBuilder gsonBuilder = new GsonBuilder()
        .setPrettyPrinting()
        .disableHtmlEscaping()
//            .setExclusionStrategies(new ExclusionStrategy() {
//                @Override
//                public boolean shouldSkipField(FieldAttributes f) {
//                    return f.getName().equals("apiRequest") || f.getName().equals("apiConfiguration");
//                }
//
//                @Override
//                public boolean shouldSkipClass(Class<?> clazz) {
//                    return false;
//                }
//            })
        ;

    private static Gson gson = gsonBuilder.create();

    private static JsonParser jsonparser = new JsonParser();

    public static JsonObject str2Obj(String json) {
        return (JsonObject) jsonparser.parse(json);
    }

    public static Map<String, Object> json2Map(String json) {
        return json2Map(str2Obj(json));
    }

    public static Map<String, Object> json2Map(JsonObject json) {
        Map<String, Object> map = new HashMap<>();
        Set<Map.Entry<String, JsonElement>> entrySet = json.entrySet();
        for (Map.Entry<String, JsonElement> entry : entrySet) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof JsonArray)
                map.put(key, toList((JsonArray) value));
            else if (value instanceof JsonObject)
                map.put(key, json2Map((JsonObject) value));
            else
                map.put(key, value);
        }
        return map;
    }

    /**
     * 将JSONArray对象转换成List集合
     *
     * @param json
     * @return
     */
    private static List<Object> toList(JsonArray json) {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < json.size(); i++) {
            Object value = json.get(i);
            if (value instanceof JsonArray) {
                list.add(toList((JsonArray) value));
            } else if (value instanceof JsonObject) {
                list.add(json2Map((JsonObject) value));
            } else {
                list.add(value);
            }
        }
        return list;
    }

    public static String Obj2Str(Object obj) {
        return gson.toJson(obj);
    }
}
