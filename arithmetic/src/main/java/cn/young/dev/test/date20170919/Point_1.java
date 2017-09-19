package cn.young.dev.test.date20170919;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ Desc 这里用到了正则表达式和java8中的max方法
 * <br/> 当然,如果是笔试,要是对正则表达式规则以及Pattern,Matcher类还有java8的流处理不熟的话,就懵逼了,最好乖乖的都自己实现吧
 * @ Author YoungSmith
 * @ Date 17-9-19 下午10:31
 */
class Point_1 {
    private static List<String> lists = new ArrayList<>();

    static String getMaxNumberStr(String str) {
        Pattern pattern = Pattern.compile("[1-9]+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            lists.add(matcher.group());
        }
        return String.valueOf(lists.stream().max(Comparator.comparingInt(String::length)));
    }
}
