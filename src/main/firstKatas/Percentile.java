package firstKatas;

import java.util.ArrayList;
import java.util.Collections;

public class Percentile {

    public static int getPercentile(ArrayList<Integer> entries, int percentile) {
        //Sort the list of entries
        Collections.sort(entries);

        double percent = percentile * 0.01;

        //Calculate index of required percentile
        double i = entries.size() * percent;
        Integer index;

        if (Math.floor(i) == i ) {
            //If index is whole number - calculate percentile by getting
            //average from value under the index and preceding one
            index = Double.valueOf(i).intValue();
            return (entries.get(index-1)+entries.get(index)) / 2;
        }
        //If index is not a whole number - calculate percentile by rounding up
        //index and getting value under that index from the list
        index = Math.toIntExact(Math.round(i));
        return entries.get(index);
    }

    public static double getPercentile(int percentile, ArrayList<Double> entries) {
        //Sort the list of entries
        Collections.sort(entries);

        double percent = percentile * 0.01;

        //Calculate index of required percentile
        double i = entries.size() * percent;
        Integer index;

        if (Math.floor(i) == i ) {
            //If index is whole number - calculate percentile by getting
            //average from value under the index and preceding one
            index = Double.valueOf(i).intValue();
            return (entries.get(index-1)+entries.get(index)) / 2;
        }
        //If index is not a whole number - calculate percentile by rounding up
        //index and getting value under that index from the list
        index = Double.valueOf(Math.floor(i)).intValue();
        return entries.get(index);
    }
}
