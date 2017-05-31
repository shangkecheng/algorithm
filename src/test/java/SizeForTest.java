import org.junit.Assert;
import org.junit.Test;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

/**
 * Created by lucaskc on 2017/5/13.
 */


public class SizeForTest {
    /**
     *
     * @param cap
     * @return
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    /**
     *
     */
    @Test
    public void sizeFor(){

        Assert.assertEquals(64,tableSizeFor(53));

    }


}
