package cn.young.dev.test.date20170919;

import org.junit.Assert;
import org.junit.Test;

/**
 * @ Desc
 * @ Author YoungSmith
 * @ Date 17-9-19 下午10:33
 */
public class TestPoint {
    @Test
    public void testPoint_1() {
        Assert.assertEquals(TestString.resultStr, Point_1.getMaxNumberStr(TestString.str));
    }
}
