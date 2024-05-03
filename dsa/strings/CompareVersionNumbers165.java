package strings;

public class CompareVersionNumbers165 {
    // Leetcode 165
    // https://leetcode.com/problems/compare-version-numbers/description/?envType=daily-question&envId=2024-05-03
    public static void main(String[] args) {
        String version1 = "1.1";
        String version2 = "1.0";
        int ans = compareVersion1(version1, version2);
        System.out.println(ans);

    }

    // MY VERSION 6ms
    public static int compareVersion1(String version1, String version2) {
        if (version1 == version2) {
            return 0;
        }

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int p1 = 0;
        int p2 = 0;

        while (p1 != v1.length && p2 != v2.length) {
            if (helper(v1[p1], v2[p2])) {
                p1++;
                p2++;
            } else {
                if (Integer.parseInt(v1[p1]) > Integer.parseInt(v2[p2])) {
                    return 1;
                } else {
                    return -1;
                }
            }

            if (p1 == v1.length && p2 != v2.length) {
                if (p2 != v2.length - 1) {
                    p2++;
                }

                v2[p2] = v2[p2].replaceAll("0", "");
                if (!v2[p2].isEmpty()) {
                    if (Integer.parseInt(v1[p1]) > 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
            if (p1 != v1.length && p2 == v2.length) {
                if (p1 != v1.length - 1) {
                    p1++;
                }

                v1[p1] = v1[p1].replaceAll("0", "");
                if (!v1[p1].isEmpty()) {
                    if (Integer.parseInt(v1[p1]) > 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }

        }
        return 0;
    }

    private static boolean helper(String v1, String v2) {

        v1 = v1.replaceAll("0", "");
        v2 = v2.replaceAll("0", "");

        return v1.equals(v2);
    }

    // IMPROVED ANS 0ms
    public int compareVersion2(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (num1 < num2) {
                return -1;
            }
            if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }
}
