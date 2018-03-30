package java;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class PaginationHelperTest {
    @Test
    public void paginationTest() {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g'), 3);

        Assert.assertEquals(3, helper.pageCount());
        Assert.assertEquals(7, helper.itemCount());
        Assert.assertEquals(1, helper.pageItemCount(2));
        Assert.assertEquals(-1, helper.pageIndex(20));
    }
}
