package cn.young.dev.test.fastJson;

import cn.young.dev.test.common.bean.Country;
import cn.young.dev.test.common.bean.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @ Desc
 * @ Author YoungSmith
 * @ Date 17-9-14 下午5:48
 */
public class FirstJson {

    @Test
    public void test() {

        try {
//            File file = new File("../template/testJson");

            File file = FileUtils.getFile("../template/testJson");
            JSONObject jsonObject = JSON.parseObject(FileUtils.readFileToString(file, "utf-8"));
            System.out.println(jsonObject);
            int size = jsonObject.size();
            Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                String key = entry.getKey();
                Object value = entry.getValue();
                entry.setValue(key);
            }
            System.out.println(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        User user = new User();
        user.setName("shiyang");
        user.setSex("男");
        Country country = new Country();
        country.setCityMount(123);
        country.setCountryName("中国");
        user.setCountry(country);
        Object o = JSON.toJSON(user);
//        System.out.println(o.toString());
        String userStr = JSON.toJSONString(user, true);
        System.out.println(userStr);

        SerializeConfig globalInstance = SerializeConfig.getGlobalInstance();
        globalInstance.setAsmEnable(true);
        JSON.toJSON(user,globalInstance);
    }
}
