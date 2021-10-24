package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * ShoppingOffersSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 10/24/2021
 */
public class ShoppingOffersSolutionTest {
    ShoppingOffersSolution.Solution solution = new ShoppingOffersSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs)
     */
    @Test
    public void testShoppingOffers1() throws Exception {
        List<Integer> price = new ArrayList<>();
        List<List<Integer>> special = new ArrayList<>();
        List<Integer> needs = new ArrayList<>();
        int[] priceArray = {2, 5};
        int[][] specialArray = {{3, 0, 5}, {1, 2, 10}};
        int[] needArray = {3, 2};
        for (int i : priceArray) {
            price.add(i);
        }
        for (int[] ints : specialArray) {
            List<Integer> temp = new ArrayList<>();
            for (int anInt : ints) {
                temp.add(anInt);
            }
            special.add(temp);
        }
        for (int i : needArray) {
            needs.add(i);
        }
        int expected = 14;
        int actual = solution.shoppingOffers(price, special, needs);
        assertEquals(expected, actual);
    }

    @Test
    public void testShoppingOffers2() throws Exception {
        List<Integer> price = new ArrayList<>();
        List<List<Integer>> special = new ArrayList<>();
        List<Integer> needs = new ArrayList<>();
        int[] priceArray = {2, 3, 4};
        int[][] specialArray = {{1, 1, 0, 4}, {2, 2, 1, 9}};
        int[] needArray = {1, 2, 1};
        for (int i : priceArray) {
            price.add(i);
        }
        for (int[] ints : specialArray) {
            List<Integer> temp = new ArrayList<>();
            for (int anInt : ints) {
                temp.add(anInt);
            }
            special.add(temp);
        }
        for (int i : needArray) {
            needs.add(i);
        }
        int expected = 11;
        int actual = solution.shoppingOffers(price, special, needs);
        assertEquals(expected, actual);
    }

}
