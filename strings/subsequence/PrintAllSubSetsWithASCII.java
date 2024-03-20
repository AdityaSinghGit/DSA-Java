package strings.subsequence;

import java.util.ArrayList;

public class PrintAllSubSetsWithASCII {
    public static void main(String[] args) {

        printSubsetWithASCII("", "abc");

        System.out.println(printSubsetWithASCIIArray("", "abc"));

    }

    static void printSubsetWithASCII(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        printSubsetWithASCII(p + ch, up.substring(1));
        printSubsetWithASCII(p + (ch + 0), up.substring(1));
        printSubsetWithASCII(p, up.substring(1));

    }

    static ArrayList<String> printSubsetWithASCIIArray(String p, String up) {
        ArrayList<String> list = new ArrayList<String>();
        if (up.isEmpty()) {
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> take = printSubsetWithASCIIArray(p + ch, up.substring(1));
        ArrayList<String> ascii = printSubsetWithASCIIArray(p + (ch + 0), up.substring(1));
        ArrayList<String> ignore = printSubsetWithASCIIArray(p, up.substring(1));

        take.addAll(ascii);
        take.addAll(ignore);

        return take;

    }

}
