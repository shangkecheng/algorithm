package test;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.core.IsEqual.equalTo;


/**
 * Created by lucaskc on 2017/5/31.
 */
public class StreamOpFlagTest {
    @Test
    public void testDistinct (){
        ArrayList<Integer> list = new ArrayList<>();
        BiConsumer <ArrayList<Integer>,Integer> consumer = ArrayList::add;
        consumer.accept(list,5);
        Assert.assertThat(5 ,equalTo(list.get(0)));
    }





}
