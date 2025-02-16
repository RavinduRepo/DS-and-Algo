import java.util.*;

public class PostfixEvaluator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline after the integer input

        for (int i = 0; i < N; i++) {
            String equation = scanner.nextLine();
            float result = evaluatePostfix(equation);
            System.out.println((int) result); // Print as integer
        }

        scanner.close();
    }

    public static float evaluatePostfix(String equation) {
        Stack<Float> stack = new Stack<>();
        String[] tokens = equation.split(" ");

        for (String token : tokens) {
            if (isOperator(token)) {
                float operand2 = stack.pop();
                float operand1 = stack.pop();
                float result = applyOperation(operand1, operand2, token);
                stack.push(result);
            } else {
                stack.push(Float.parseFloat(token));
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static float applyOperation(float operand1, float operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2; // Float division
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}