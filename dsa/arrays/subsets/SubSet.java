package subsets;

import java.util.List;
import java.util.ArrayList;

public class SubSet {
    // *****************CODE NOT RUNNING***************** */
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> ans = findSubSequence(arr);
        for (List<Integer> i : ans) {
            System.out.println(i);
        }
    }

    static List<List<Integer>> findSubSequence(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for (int num : arr) {
            int n = outer.size();
            for (int j = 0; j < n; j++) {
                System.out.println("O SIZE: " + n);
                List<Integer> inner = new ArrayList<>(outer.get(j));
                System.out.println("O ELEMENT: " + outer.get(j));
                inner.add(num);
                System.out.println("INNER : " + inner);
                outer.add(inner);
                System.out.println("OUTER : " + outer);
            }
        }
        return outer;
    }

}
