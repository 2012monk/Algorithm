package BOJ.n2293동전1;

public class Main {
    static int[] dp;
    public static void print(int[] arr) {
        for (int j : arr) {
            System.out.printf("%d ", j);
        }
        System.out.println();
    }


    public static int solution(int[] arr, int total) {
        dp = new int[total+1];
        dp[0] = 1;

        for (int k : arr) {
            for (int j = k; j <= total; j++) {
                dp[j] = dp[j] + dp[j - k];
            }
        }

        return dp[total];


    }

    public static void main(String[] args) {
        int[] tc = {5,2,1};

        System.out.println(solution(tc, 10));
    }
}
