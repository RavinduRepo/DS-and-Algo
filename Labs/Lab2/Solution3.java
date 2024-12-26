import java.math.BigInteger;
import java.util.Scanner;
  

public class Solution3 { 
    public static void main(String[] args) {   
        // pre calcultea values to optimize and reduce re calculating values (in try block to close the scanner)
        try (Scanner scanner = new Scanner(System.in)) {
            // pre calcultea values to optimize and reduce re calculating values
            // int maxW = 16; // max W value
            BigInteger[] fibonacci = new BigInteger[988]; // arr to store fib numbers(987 is the max index since the tasks required that much)
            // Base cases  
            fibonacci[0] = BigInteger.ZERO;  
            fibonacci[1] = BigInteger.ONE;  
             
            // calculate Fibonacci numbers to array 
            for (int i = 2; i < 988; i++) {
                fibonacci[i] = fibonacci[i - 1].add(fibonacci[i - 2]);
            }
            
            // Innput the number of test cases 
            int T = scanner.nextInt(); 
             
            for (int t = 0; t < T; t++) { 
                // Input the value of W  
                int W = scanner.nextInt();

                // calcuate Fibonacci(W) using pre-calculated values
                int innerFibonacci = fibonacci[W].intValueExact(); // Convert BigInteger to int
                BigInteger result = fibonacci[innerFibonacci]; // Get the Fibonacci of that result
                
                // print the secret number
                System.out.println(result);
            }
        }
    }
}
