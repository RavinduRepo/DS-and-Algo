import java.util.*;

public class Solution {

    static void printAll(String[] names, ArrayList<Integer> bravery_scores) {
        // Print names as a list with single quotes
        System.out.print("[");
        for (int i = 0; i < names.length; i++) {
            System.out.print("'" + names[i] + "'");
            if (i < names.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        // Print bravery scores as a list
        System.out.print("[");
        for (int i = 0; i < bravery_scores.size(); i++) {
            System.out.print(bravery_scores.get(i));
            if (i < bravery_scores.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    static void swapInt(ArrayList<Integer> d, int i, int j) {
        int tmp = d.get(i);
        d.set(i, d.get(j));
        d.set(j, tmp);
    }

    static void swapStr(String[] d, int i, int j) {
        String tmp = d[i];
        d[i] = d[j];
        d[j] = tmp;
    }

    public static void sort(String[] names, ArrayList<Integer> bravery_scores) {
        for (int i = 0; i < bravery_scores.size() - 1; i++) {
            int max = i;
            for (int j = i + 1; j < bravery_scores.size(); j++) {
                if (bravery_scores.get(j) > bravery_scores.get(max)) {
                    max = j;
                }
            }
            swapInt(bravery_scores, i, max);
            swapStr(names, i, max);
        }
        printAll(names, bravery_scores);
    }

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Number of students
        int n = scanner.nextInt();
        scanner.nextLine();

        // Names input
        String[] names = scanner.nextLine().split(" ");

        // Bravery scores input
        ArrayList<Integer> bravery_scores = new ArrayList<>();
        String[] scoreInputs = scanner.nextLine().split(" ");
        for (String score : scoreInputs) {
            bravery_scores.add(Integer.parseInt(score));
        }

        // Run the sorting algorithm
        sort(names, bravery_scores);

        // Print names line by line
        for (int i = 0; i < 4; i++) { // Print only the first 4 names
            System.out.println(names[i]);
        }
    }
}
