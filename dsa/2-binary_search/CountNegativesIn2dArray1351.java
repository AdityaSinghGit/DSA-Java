public class CountNegativesIn2dArray1351 {
    public static void main(String[] args) {
        int[][] grid = {
                { 4, 3, 2, -1 },
                { 3, 2, 1, -1 },
                { 1, 1, -1, -2 },
                { -1, -1, -2, -3 }
        };
        int ans = countNegatives(grid);
        System.out.println(ans);
    }

    public static int countNegatives(int[][] grid) {
        int row = 0;
        int col = grid[0].length - 1;
        int count = 0;
        while (row <= grid.length - 1 && col >= 0) {
            if (grid[row][col] < 0) {
                count += grid.length - row;
                col--;
            } else {
                row++;
            }
        }
        return count;
    }
}
