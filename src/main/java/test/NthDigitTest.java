package test;

import algorithm.NthDigit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * \* User: lucaskc
 * \* Date: 2017/9/24
 * \* Time: 下午5:33
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class NthDigitTest {
    private NthDigit solution;

    @Before
    public void setUp(){
        solution =new NthDigit();
    }

    @Test
    public void test(){
        int n =solution.findNthDigit(11);
        Assert.assertEquals("not equals",n,0);
    }

}
