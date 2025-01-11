import java.util.Scanner;

public class ShortestPathFinder {
    private static int minDistance = Integer.MAX_VALUE; // To store the minimum distance
    private static final int[] rowDir = {-1, 1, 0, 0}; // Directions: Up, Down, Left, Right
    private static final int[] colDir = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the grid dimensions
        int h = scanner.nextInt();
        int w = scanner.nextInt();

        
        scanner.nextLine(); // Consume the newline character
        

        // Input the start and destination points
        String[] start = scanner.nextLine().split(" ");
        int s1 = Integer.parseInt(start[0]);
        int s2 = Integer.parseInt(start[1]);

        String[] destination = scanner.nextLine().split(" ");
        int d1 = Integer.parseInt(destination[0]);
        int d2 = Integer.parseInt(destination[1]);

        // Input the grid
        int[][] grid = new int[h][w];
        for (int i = 0; i < h; i++) {
            String line = scanner.nextLine().trim();
            line = line.substring(1, line.length() - 1); // Remove the square brackets
            String[] values = line.split(",\\s*"); // Split by comma and optional space
            for (int j = 0; j < w; j++) {
                grid[i][j] = Integer.parseInt(values[j]);
            }
        }

        // Call the method to find the shortest path
        if (grid[s1][s2] == 1) { // Ensure the starting point is valid
            findMinDistance(grid, s1, s2, d1, d2, 0);
        }

        // Print the result
        if (minDistance == Integer.MAX_VALUE) {
            System.out.println("There is no possible path");
        } else {
            System.out.println("The minimum distance is " + minDistance);
        }

        scanner.close();
    }

    private static void findMinDistance(int[][] grid, int x, int y, int d1, int d2, int steps) {
        // If destination is reached, update the minimum distance
        if (x == d1 && y == d2) {
            minDistance = Math.min(minDistance, steps);
            return;
        }

        // Mark the current cell as visited
        grid[x][y] = 0;

        // Explore all four possible directions
        for (int i = 0; i < 4; i++) {
            int newX = x + rowDir[i];
            int newY = y + colDir[i];

            if (isValid(grid, newX, newY)) {
                findMinDistance(grid, newX, newY, d1, d2, steps + 1);
            }
        }

        // Backtrack: Mark the cell as unvisited
        grid[x][y] = 1;
    }

    private static boolean isValid(int[][] grid, int x, int y) {
        // Check if the cell is within bounds and is open (1)
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1;
    }
}

// 7
// 5
// 0 0
// 6 4
// [1, 1, 1, 1, 1]
// [0, 1, 1, 1, 1]
// [0, 0, 1, 0, 1]
// [1, 0, 1, 1, 1]
// [0, 0, 0, 1, 0]
// [1, 0, 1, 1, 1]
// [0, 0, 0, 0, 1]