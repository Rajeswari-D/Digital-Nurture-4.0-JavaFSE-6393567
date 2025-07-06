import java.util.Scanner;

public class FinancialForecast {

    // Recursive method to calculate future value
    public static double futureValue(double initial, double rate, int years) {
        if (years == 0) return initial;
        return futureValue(initial, rate, years - 1) * (1 + rate);
    }

    // Optimized version using memoization
    public static double futureValueMemo(double initial, double rate, int years, double[] memo) {
        if (years == 0) return initial;
        if (memo[years] != 0) return memo[years];

        memo[years] = futureValueMemo(initial, rate, years - 1, memo) * (1 + rate);
        return memo[years];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial investment amount: ");
        double initial = sc.nextDouble();

        System.out.print("Enter annual growth rate (in %): ");
        double rate = sc.nextDouble() / 100;

        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        System.out.println("\n🔁 Recursive Forecast:");
        double result = futureValue(initial, rate, years);
        System.out.printf("Projected value after %d years: Rs %.2f\n", years, result);

        System.out.println("\n⚡ Optimized with Memoization:");
        double[] memo = new double[years + 1];
        double resultMemo = futureValueMemo(initial, rate, years, memo);
        System.out.printf("Projected value after %d years (memoized): Rs %.2f\n", years, resultMemo);

        sc.close();
    }
}
