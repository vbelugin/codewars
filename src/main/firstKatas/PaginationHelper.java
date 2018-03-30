package firstKatas;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * For this exercise you will be strengthening your page-fu mastery. You will complete the PaginationHelper class, which is a utility class helpful for querying paging information related to an array.

 The class is designed to take in an array of values and an integer indicating how many items will be allowed per each page. The types of values contained within the collection/array are not relevant.

 The following are some examples of how this class is used:
     PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
     helper.pageCount(); //should == 2
     helper.itemCount(); //should == 6
     helper.pageItemCount(0); //should == 4
     helper.pageItemCount(1); // last page - should == 2
     helper.pageItemCount(2); // should == -1 since the page is invalid

     // pageIndex takes an item index and returns the page that it belongs on
     helper.pageIndex(5); //should == 1 (zero based index)
     helper.pageIndex(2); //should == 0
     helper.pageIndex(20); //should == -1
     helper.pageIndex(-10); //should == -1

 https://www.codewars.com/kata/paginationhelper/train/java
 */

public class PaginationHelper<I> {
    private List<I> collection;
    private HashMap<Integer, List<I>> mappedCollection;
    private int itemsPerPage;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
        mapCollection();
    }

    /**
     * Mapper takes collection and maps it to HashMap where key is pageIndex and value is List of items
     */
    private void mapCollection() {
        mappedCollection = new HashMap<>();

        int counter = 0;
        for (int i = 0; i < pageCount(); i++) {
            mappedCollection.put(i, collection.subList(counter, counter + itemsPerPage > collection.size() ? collection.size() : counter + itemsPerPage));
            counter += itemsPerPage;
        }
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return BigDecimal.valueOf(collection.size()).divide(BigDecimal.valueOf(itemsPerPage), new MathContext(1, RoundingMode.UP)).intValue();
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        return mappedCollection.containsKey(pageIndex) ? mappedCollection.get(pageIndex).size() : -1;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex < collection.size() && itemIndex >= 0) {
            for (Map.Entry<Integer, List<I>> entry : mappedCollection.entrySet()) {
                if (entry.getValue().stream().anyMatch(x -> x.equals(collection.get(itemIndex)))) {
                    return entry.getKey();
                }
            }
        }
        return -1;
    }
}