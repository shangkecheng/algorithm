package test;

import algorithm.Fibonacci;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* Fibonacci Tester.
* 
* @author <Authors name> 
* @since <pre>九月 28, 2017</pre> 
* @version 1.0 
*/ 
public class FibonacciTest {

    private Fibonacci solution;

    @Before
public void before() throws Exception {
    solution  = new Fibonacci();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: compute(int n) 
* 
*/ 
@Test
public void testCompute() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: memorized(int n) 
* 
*/ 
@Test
public void testMemorized() throws Exception {
    Assert.assertEquals("wrong",solution.compute(10),solution.memorized(10));
} 


/** 
* 
* Method: fab(int n, List<Integer> list) 
* 
*/ 
@Test
public void testFab() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = Fibonacci.getClass().getMethod("fab", int.class, List<Integer>.class);
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
