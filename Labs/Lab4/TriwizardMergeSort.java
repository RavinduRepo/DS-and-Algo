import java.util.*;

public class TriwizardMergeSort {

    private static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++)
            leftArray[i] = array[left + i];
        for (int i = 0; i < n2; i++)
            rightArray[i] = array[middle + 1 + i];

        // Initialize pointer indexes for leftArray, rightArray.
        int i = 0, j = 0;
        // initialize pointer index for merged arr.arr
        int k = left;

        // Merge the two arrays.
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Coppy remainning elements if any.
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }


    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            /// getting the midle element
            int middle = left + (right - left) / 2;

            // Sort first and second halfs
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            // merge the sorted halfs
            merge(array, left, middle, right);
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
            int[] array = new int[parts.length];
            for (int j = 0; j < parts.length; j++) {
                array[j] = Integer.parseInt(parts[j]);
            }

            // SORT
            mergeSort(array, 0, array.length - 1);

            // store to print later
            resultArrays.add(array);
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
