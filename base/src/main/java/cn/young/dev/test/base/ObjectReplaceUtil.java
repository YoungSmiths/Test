package cn.young.dev.test.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ Desc
 * @ Author YoungSmith
 * @ Date 17-11-6 上午11:51
 */
public class ObjectReplaceUtil {

    /**
     * 不支持基本数据类型替换
     *
     * @param dist
     * @param sour
     */
    public static void replaceVariable(Object dist, Object sour) {
        if (Utils.isNull(dist) || Utils.isNull(sour)) {
            return;
        }
        if (dist instanceof ArrayList && sour instanceof ArrayList) {
            replaceVariable((List<Object>) dist, (List<Object>) sour);
        }
        if (dist instanceof ArrayList && sour instanceof Map) {
            replaceVariable((List<Object>) dist, (Map<Integer, Object>) sour);
        }
        if (dist instanceof Map && sour instanceof Map) {
            replaceVariable((Map<String, Object>) dist, (Map<String, Object>) sour);
        }
    }

    /**
     * 将源Map中的value替换到目标Map和源Map共有的key对应的value中。
     *
     * @param dist 目标Map
     * @param sour 源Map
     */
    public static void replaceVariable(Map<String, Object> dist, Map<String, Object> sour) {
        if (Utils.isNull(dist) || Utils.isNull(sour)) {
            return;
        }
        for (Map.Entry<String, Object> entry : dist.entrySet()) {
            String key = entry.getKey();
            Object sourValue = sour.get(key);
            if (sourValue != null) {
                Object value = entry.getValue();
                if (isBaseType(value, sourValue)) {
                    dist.put(key, sourValue);
                } else {
                    replaceVariable(value, sourValue);
                }
            }
        }
    }

    /**
     * 整体替换dist,依次遍历替换
     *
     * @param dist
     * @param sour
     */
    private static void replaceVariable(List<Object> dist, List<Object> sour) {
        if (Utils.isNull(dist) || Utils.isNull(sour)) {
            return;
        }
        for (int i = 0; dist.size() > 0 && sour.size() > 0 && i < sour.size() && i < dist.size(); i++) {
            if (isBaseType(dist.get(i), sour.get(i))) {
                dist.set(i, sour.get(i));
            } else {
                replaceVariable(dist.get(i), sour.get(i));
            }
        }
    }

    /**
     * 替换dist的固定位置,根据sour的key记录dist的位置替换
     *
     * @param dist
     * @param sour
     */
    private static void replaceVariable(List<Object> dist, Map<Integer, Object> sour) {
        if (Utils.isNull(dist) || Utils.isNull(sour))
            return;
        for (Map.Entry<Integer, Object> entry : sour.entrySet()) {
            Integer key = entry.getKey();
            if (key < dist.size()) {
                Object value = entry.getValue();
                Object indexValue = dist.get(key);
                if (isBaseType(indexValue, value)) {
                    dist.set(key, value);
                } else {
                    replaceVariable(indexValue, value);
                }
            }
        }
    }

    /**
     * 两者都是基本类型,且类型相同
     * @param value
     * @param sourValue
     * @return
     */
    private static boolean isBaseType(Object value, Object sourValue) {
        if (value instanceof Integer && sourValue instanceof Integer) {
            return true;
        }
        if (value instanceof Long && sourValue instanceof Long) {
            return true;
        }
        if (value instanceof Boolean && sourValue instanceof Boolean) {
            return true;
        }
        if (value instanceof Double && sourValue instanceof Double) {
            return true;
        }
        if (value instanceof Float && sourValue instanceof Float) {
            return true;
        }
        if (value instanceof Short && sourValue instanceof Short) {
            return true;
        }
        if (value instanceof Character && sourValue instanceof Character) {
            return true;
        }
        if (value instanceof String && sourValue instanceof String) {
            return true;
        }
        return false;
    }
}
