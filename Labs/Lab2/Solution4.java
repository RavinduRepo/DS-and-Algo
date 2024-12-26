import java.util.*;

public class Solution4 {
    public static void main(String[] args) {      
        try (Scanner scanner = new Scanner(System.in)) {   
            // getting inputs
            int p = scanner.nextInt();    
            int q = scanner.nextInt();    
  
            // creatings lists. 
            int[] X = new int[p]; 
            int[] Y = new int[q]; 
             
            for (int i = 0; i < p; i++) {
                X[i] = scanner.nextInt();
            } 

            for (int i = 0; i < q; i++) {
                Y[i] = scanner.nextInt();
            }

            // find and print the LCS
            List<Integer> lcs = findLCS(X, Y);
            for (int num : lcs) {
                System.out.print(num + " ");      
                 
            }
        }
    }

    private static List<Integer> findLCS(int[] X, int[] Y) {
        int p = X.length;
        int q = Y.length;

        // DP table to store the lengths of LCS
        int[][] dp = new int[p + 1][q + 1];

        // fill the DP table
        for (int i = 1; i <= p; i++) {
            for (int j = 1; j <= q; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // add one to diagoanl value
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // get the max from the top and left values
                }
            }
        }

        // back-trcking to find the LCS
        List<Integer> lcs = new ArrayList<>();
        int i = p, j = q; // start from the end of the table
        while (i > 0 && j > 0) {
            if (X[i - 1] == Y[j - 1]) { // arrow is to diagonal element
                lcs.add(X[i - 1]); // add to lcs since it is common
                // walk diagonaly backwords
                i--;
                j--;
            } else if (dp[i - 1][j] == dp[i][j]) { // arrow is to top element
                // walk up
                i--;
            } else { // arrow is to left element
                // walk backwords
                j--;
            }
        }

        //sive we added each element to the end of the list; revverse the list. 
        Collections.reverse(lcs);
        return lcs;
    }
}
