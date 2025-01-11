import java.util.*;

public class BicornHornSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the unique strength value of the Bicorn Horn
        int S = scanner.nextInt();

        // Input the number of items in Snape's Cabinet
        int N = scanner.nextInt();

        // Input the array of strengths of items in Snape's Cabinet
        int[] strengthArr = new int[N];
        for (int i = 0; i < N; i++) {
            strengthArr[i] = scanner.nextInt();
        }

        // Combine indices and strengths into a list of pairs
        List<Map.Entry<Integer, Integer>> pairedList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            pairedList.add(new AbstractMap.SimpleEntry<>(i, strengthArr[i]));
        }

        // Sort the paired list based on strength values
        pairedList.sort(Comparator.comparingInt(Map.Entry::getValue));

        // Extract sorted strengths and maintain original indices
        int[] sortedStrengths = new int[N];
        int[] originalIndices = new int[N];
        for (int i = 0; i < N; i++) {
            originalIndices[i] = pairedList.get(i).getKey();
            sortedStrengths[i] = pairedList.get(i).getValue();
        }

        // Perform binary search on sorted strengths
        int index = binarySearch(sortedStrengths, S);

        // Output the result
        if (index != -1) {
            System.out.println("Bicorn Horn is present at index " + originalIndices[index]);
        } else {
            System.out.println("Bicorn Horn is not found!");
        }
    }
    // 228
    // 20
    // 283 158 188 166 100 175 273 257 179 296 241 258 228 183 181 224 279 286 285 237

    
    // Binary search implementation
    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }
}
