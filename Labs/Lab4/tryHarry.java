import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tryHarry {
    
    private static void merge (int[] arr, int left, int middle, int right) {
        int n1 = middle - left +1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i]  = arr[left + 1];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = arr[middle + 1 + i];
        }

        // Initialize pointer indexes for leftArray, rightArray.
        int i = 0, j = 0;

        // initialize pointer index for merged arr.arr
        int k = left;
        
        // Merge the two arrays.
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            }
            else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Coppy remainning elements if any.
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = leftArray[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            /// getting the midle element
            int middle = left + (right - left) / 2;

            // Sort first and second halfs
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            // merge the sorted halfs
            merge(arr, left, middle, right);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // take num of arrays
        int n = scanner.nextInt();
        scanner.nextLine();

        List<int[]> resultArrays = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // read the input and splli to two.
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            int[] arr = new int[parts.length];
            for (int j = 0; j < parts.length; j++) {
                arr[j] = Integer.parseInt(parts[j]);
            }

            // SORT
            mergeSort(arr, 0, arr.length - 1);

            // store to print later
            resultArrays.add(arr);
        }        
        scanner.close();
        
        // Print the sorted arrays
        for (int[] array : resultArrays) {
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
