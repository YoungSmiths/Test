package cn.young.dev.test.date20170919;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ Desc 这里如果直接笔试,flag逻辑处理可能会有点乱,StringBuilder也是后来修改的,刚开始直接用Character的数组,后发现转字符串有些麻烦
 * @ Author YoungSmith
 * @ Date 17-9-19 下午11:07
 */
public class Point_2 {
    private static List<String> lists = new ArrayList<>();

    private static List<String> numList = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

    static String getMaxNumberStr(String str) {
        boolean flag;
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            flag = false;
            char c = str.charAt(i);
            if (numList.contains(String.valueOf(c))) {
                sb.append(c);
            } else {
                flag = true;
            }
            if (flag && sb.length() != 0) {
                lists.add(sb.toString());
                sb.delete(0,sb.length());
            }
        }
        return lists.stream().max(Comparator.comparingInt(String::length)).get();
    }
}
