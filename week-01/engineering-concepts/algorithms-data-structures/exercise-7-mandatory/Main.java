/*
 * ## Exercise 7: Financial Forecasting
 * Scenario:
 * You are developing a financial forecasting tool that predicts future values based on past data.
 * ## Steps:
 * Understand Recursive Algorithms:
 * Explain the concept of recursion and how it can simplify certain problems.
 * Setup:
 * Create a method to calculate the future value using a recursive approach.
 * Implementation:
 * Implement a recursive algorithm to predict future values based on past growth rates.
 * Analysis:
 * Discuss the time complexity of your recursive algorithm.
 * Explain how to optimize the recursive solution to avoid excessive computation.
 */
public class Main {
    static int baseValue = 1000;
    static double growthRate = 0.05;

    public static double predictFutureValue(int years) {
        if (years == 0) {
            return baseValue;
        }
        return predictFutureValue(years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        // TODO: Implement Financial Forecasting
        System.out.println(predictFutureValue(5));
        System.out.println(predictFutureValue(10));
    }
}
