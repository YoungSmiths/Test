package cn.young.dev.test.base;

/**
 * @ Desc
 * @ Author YoungSmith
 * @ Date 17-11-6 上午11:52
 */
public class Utils {
    /**
     * 是不是基本类型
     *
     * @param value
     * @return
     */
    public static boolean isBaseType(Object value) {
        if (value instanceof Integer) {
            return true;
        }
        if (value instanceof Long) {
            return true;
        }
        if (value instanceof Boolean) {
            return true;
        }
        if (value instanceof Double) {
            return true;
        }
        if (value instanceof Float) {
            return true;
        }
        if (value instanceof Short) {
            return true;
        }
        if (value instanceof Character) {
            return true;
        }
        if (value instanceof String) {
            return true;
        }
        return false;
    }

    /**
     * 判空
     *
     * @param obj
     * @return
     */
    public static boolean isNull(Object obj) {
        if (obj == null) {
            return true;
        } else {
            return false;
        }
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            //do nothing
        }
    }
}
