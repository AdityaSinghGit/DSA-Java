package arrayss;

import java.util.Arrays;

public class BoatsToSavePeople881 {
    // Leetcode 881
    // https://leetcode.com/problems/boats-to-save-people/?envType=daily-question&envId=2024-05-04
    public static void main(String[] args) {
        int people[] = { 3, 5, 3, 4 };
        int limit = 5; // limit >= people[i]
        int ans = numRescueBoats(people, limit);
        System.out.println(ans);
    }

    public static int numRescueBoats(int[] people, int limit) {
        int i = 0;
        int j = people.length - 1;
        int count = 0;

        Arrays.sort(people);

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
            } else {
                j--;
            }
            count++;
        }

        return count;
    }
}
