public class Numbertest {

    private static void printNums() throws Exception {
        long num = Long.MAX_VALUE;
        System.out.println(getN(num));
    }

    private static long getN(long n) throws Exception {
        if (n < 0) {
            throw new Exception("Number is negative");
        } else if(n > Integer.MAX_VALUE) {
            throw new Exception("Number is bigger than max value");
        } else {
            return (n / 10) > 10 ? getN(n / 10) + (n % 10) : (n % 10) + (n / 10);
        }
    }

    public static void main(String[] args) throws Exception {
        printNums();
    }
}
