package kyu7;

public class Printer {

    public static String printerError(String s) {
        return s.replaceAll("[a-m]", "").length() +"/"+s.length();
    }
}
