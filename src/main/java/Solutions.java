package java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Solutions {

    /**
     * x Simple, given a string of words, return the length of the shortest word(s).

     String will never be empty and you do not need to account for different data types.
     */
    public static int findShort(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(String::length).min().getAsInt();
    }

    /**
     * It's pretty straightforward. Your goal is to create a function that removes the first and last characters of a string.
     * You're given one parameter, the original string. You don't have to worry with strings with less than two characters.
     */
    public static String remove(String str) {
        return str.substring(1, str.length()-1);
    }

    /**
     * Write function makeUpperCase.
     */
    public static String MakeUpperCase(String str){
        return str.toUpperCase();
    }


    /**
     * Write function RemoveExclamationMarks which removes all exclamation marks from a given string.
     */
    public static String removeExclamationMarks(String s) {
        return s.replaceAll("!", "");
    }


    /**
     * There is a queue for the self-checkout tills at the supermarket. Your task is write a function to calculate the total time required for all the customers to check out!

     The function has two input variables:
     * @param customers an array (list in python) of positive integers representing the queue. Each integer represents a customer, and its value is the amount of time they require to check out.
     * @param n a positive integer, the number of checkout tills.
     * @return The function should return an integer, the total time required.
     */
    public static int solveSuperMarketQueue(int[] customers, int n) {
        Integer time = 0;
        IntStream.of(customers).asDoubleStream().forEach(customer -> System.out.println(customer % n == 0 ? 1 : customer / n > 0 ? customer / n : customer));
//        return customers.length == 1 ? customers[0] : Arrays.stream(customers).reduce(0, (x, y) -> x + y) / n;
        return Double.valueOf(Arrays.stream(customers).asDoubleStream().map(customer -> customer % n == 0 ? 1 : customer / n > 0 ? customer / n : customer).sum()).intValue();
    }


    /**
     * You are given two arrays a1 and a2 of strings. Each string is composed with letters from a to z. Let x be any string in the first array and y be any string in the second array.

     Find max(abs(length(x) − length(y)))

     If a1 and/or a2 are empty return -1 in each language except in Haskell (F#) where you will return Nothing (None).
     */
    public static int mxdiflg(String[] a1, String[] a2) {
        if (a1.length == 0 || a2.length == 0) {
            return -1;
        }

        IntSummaryStatistics a1stat = Arrays.stream(a1).mapToInt(String::length).summaryStatistics();
        IntSummaryStatistics a2stat = Arrays.stream(a2).mapToInt(String::length).summaryStatistics();

        return Math.max(Math.abs(a1stat.getMax() - a2stat.getMin()), Math.abs(a2stat.getMax() - a1stat.getMin()));
    }



    public static void finalTests() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        final ArrayList<Integer> fList = list;
        final Integer vari = fList.get(0);

        System.out.println(vari);
        System.out.println(fList.toString());

        System.out.println();

        list.add(2);
        fList.add(4);
        System.out.println();
        System.out.println(list.toString());
        System.out.println(fList.toString());
    }


    /**
     * Two tortoises named A and B must run a race. A starts with an average speed of 720 feet per hour. Young B knows she runs faster than A, and furthermore has not finished her cabbage.

     When she starts, at last, she can see that A has a 70 feet lead but B's speed is 850 feet per hour. How long will it take B to catch A?

     More generally: given two speeds v1 (A's speed, integer > 0) and v2 (B's speed, integer > 0) and a lead g (integer > 0) how long will it take B to catch A?

     The result will be an array [hour, min, sec] which is the time needed in hours, minutes and seconds (don't worry for fractions of second).

     If v1 >= v2 then return nil, nothing, null, None or {-1, -1, -1} for C++, C, Go, Nim, [] for Kotlin.
     */

    public static int[] race(int v1, int v2, int g) {
        int h = g/(v2-v1);
        int m = (g % (v2-v1)) * 60 / (v2-v1);
        int s = (((g % (v2-v1)) * 60) % (v2-v1)) * 60 / (v2-v1);

        return v1 >= v2 ? null : new int[] {h, m, s};
    }

    /**
     * You might know some pretty large perfect squares. But what about the NEXT one?

     Complete the findNextSquare method that finds the next integral perfect square after the one passed as a parameter. Recall that an integral perfect square is an integer n such that sqrt(n) is also an integer.

     If the parameter is itself not a perfect square, than -1 should be returned. You may assume the parameter is positive.
     */
    public static long findNextSquare(long sq) {
        double num = Math.sqrt(sq) + 1;
        return num % 1 == 0 ? (long)Math.pow(num, 2) : -1;
    }
}