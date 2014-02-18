package org.github.search;

import org.github.search.implementation.RecursiveInclusiveStartInclusiveEnd;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BinarySearcherTest {
    private final int[] array;
    private final int num;
    private final int expectedPosition;

    private BinarySearcher searcher;

    @Before
    public void setUp() throws Exception {
        searcher = new RecursiveInclusiveStartInclusiveEnd();
    }

    public BinarySearcherTest(int[] array, int num, int expectedPosition) {
        this.array = array;
        this.num = num;
        this.expectedPosition = expectedPosition;
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {new int[]{}, 0, -1}, // Empty array
                {new int[]{1}, 1, 0}, // Single item array, item in array
                {new int[]{1}, 0, -1}, // Single item array, item not in array
                {new int[]{2, 3, 5, 8, 13}, 2, 0}, // Odd size, first item
                {new int[]{2, 3, 5, 8, 13}, 5, 2}, // Odd size, middle item
                {new int[]{2, 3, 5, 8, 13}, 13, 4}, // Odd size, last item
                {new int[]{2, 3, 5, 8, 13, 21}, 2, 0}, // Even size, first item
                {new int[]{2, 3, 5, 8, 13, 21}, 5, 2}, // Even size, middle left item
                {new int[]{2, 3, 5, 8, 13, 21}, 8, 3}, // Even size, middle right item
                {new int[]{2, 3, 5, 8, 13, 21}, 21, 5} // Even size, last item});
        });
    }

    @Test
    public void testSearch() throws Exception {
        final int position = searcher.search(num, array);
        assertEquals(expectedPosition, position);
    }

    //    @Test
//    public void emptyArray() throws Exception {
//        // when
//        final int pos = searcher.search(0, new int[0]);
//
//        // then
//        assertEquals(-1, pos);
//    }
//
//    @Test
//    public void arrayWithOneItem_isTheOneSearchedAfter() throws Exception {
//        // given
//
//        // when
//        searcher.search(5, new int[]{1});
//
//        // then
//    }
}
