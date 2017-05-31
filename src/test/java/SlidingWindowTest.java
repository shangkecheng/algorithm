import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/** 
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>五月 17, 2017</pre> 
* @version 1.0 
*/

@RunWith(Parameterized.class)
public class SlidingWindowTest {

    @Parameterized.Parameter(0)
    public int[] nums;
    @Parameterized.Parameter(1)
    public int k;
    @Parameterized.Parameter(2)
    public int[] output;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[]{1,2,3,4,5}, 3,new int[]{3,4,5}},
                { new int[]{5,4,3,2,1}, 2,new int[]{5,4,3,2}}

        });
    }


@Before
public void before() throws Exception {

} 

@After
public void after() throws Exception {

} 

/** 
* 
* Method: maxSlidingWindow(int[] nums, int k) 
* 
*/ 
@Test
public void testMaxSlidingWindow() throws Exception {
    int[] actual = SlidingWindow.maxSlidingWindow(nums,k) ;
    Assert.assertArrayEquals(output,actual);

} 


} 
