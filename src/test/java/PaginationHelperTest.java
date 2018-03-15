import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;

public class PaginationHelperTest {
    @Test
    public void paginationTest() {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g'), 3);

        Assert.assertEquals(3, helper.pageCount());
        Assert.assertEquals(7, helper.itemCount());
        Assert.assertEquals(1, helper.pageItemCount(3));
        System.out.println(helper.pageCount());
        System.out.println(helper.pageIndex(5));
    }
}
