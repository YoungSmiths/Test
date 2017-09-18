package cn.young.dev.test.gson;

import com.google.gson.*;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

/**
 * @ Desc
 * @ Author YoungSmith
 * @ Date 17-9-15 上午10:10
 */
public class TestGson {
    @Test
    public void testGson1() {
        String fileToString = null;
        try {
            fileToString = FileUtils.readFileToString(FileUtils.getFile("../template/testJson"), Charset.forName("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(fileToString);
        JsonParser parser = new JsonParser();
        JsonElement parse = parser.parse(fileToString);
        parser(parse);

    }

    private void parser(JsonElement element) {
        if (element.isJsonObject()) {
            JsonObject object = (JsonObject) element;
            Set<Map.Entry<String, JsonElement>> entries = object.entrySet();
            for (Map.Entry<String, JsonElement> entry : entries) {
                String key = entry.getKey();
                JsonElement value = entry.getValue();
                parser(value);
            }
        }
        if (element.isJsonArray()) {
            JsonArray array = (JsonArray) element;
            int size = array.size();
            for (int i = 0; i < size; i++) {
                JsonElement jsonElement = array.get(i);
                parser(jsonElement);
            }
        }
        if (element.isJsonPrimitive()) {
            JsonPrimitive primitive = (JsonPrimitive) element;
            if (primitive.isBoolean()) {
                Boolean b = primitive.getAsBoolean();
                System.out.println(b);
            }
            if (primitive.isNumber()) {
                Number n = primitive.getAsNumber();
                System.out.println(n);
            }
            if (primitive.isString()) {
                String s = primitive.getAsString();
                System.out.println(s);
            }
            if (primitive.isJsonNull()) {
                Object NULL = null;
                System.out.println(NULL);
            }
        }
        if (element.isJsonNull()) {
            Object NULL = null;
            System.out.println(NULL);
        }
    }

    @Test
    public void test3(){

    }

}
