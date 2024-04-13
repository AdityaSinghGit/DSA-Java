package greedy_algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class ShopInCandyStoreGFG {
    // Geeks For Geeks
    // https://www.geeksforgeeks.org/problems/shop-in-candy-store1145/1
    public static ArrayList<Integer> candyStore(int candies[], int N, int K) {
        ArrayList<Integer> minMax = new ArrayList<>();
        int min = 0;
        int max = 0;
        int s = 0;
        int e = candies.length - 1;
        Arrays.sort(candies);

        while (s <= e) {
            min += candies[s];
            s += 1;
            e -= K;
        }

        minMax.add(min);
        s = 0;
        e = candies.length - 1;

        while (s <= e) {
            max += candies[e];
            s += K;
            e -= 1;
        }

        minMax.add(max);

        return minMax;
    }
}
