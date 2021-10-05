package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * PeekingIteratorSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 10/05/2021
 */
public class PeekingIteratorSolutionTest {

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void test1() throws Exception {
        Integer[] integers = {1, 2, 3};
        List<Integer> list = Arrays.asList(integers);
        PeekingIteratorSolution.PeekingIterator iterator = new PeekingIteratorSolution().new PeekingIterator(list.iterator());
        System.out.println(iterator.next());
        System.out.println(iterator.peek());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }


}
