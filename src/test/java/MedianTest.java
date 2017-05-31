import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by lucaskc on 2017/5/19.
 */
@RunWith(Parameterized.class)
public class MedianTest {
    @Parameterized.Parameter
    public int[] nums;
    @Parameterized.Parameter(1)
    public double output;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[]{1,2,3,4,5}, (double)3,},
                { new int[]{5,4,2,1}, (double)3,}

        });
    }

    private MedianFinderI mf ;

    @Before
    public void before() throws Exception {
        mf = new MedianFinderI();
    }

    @Test
    public void testMedianFinder(){
        for(int i:nums){
            mf.addNum(i);
        }
        Assert.assertEquals(output,mf.findMedian(),0.01);
    }

}
