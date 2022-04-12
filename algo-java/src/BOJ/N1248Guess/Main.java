package BOJ.N1248Guess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static char[][] matrix = new char[11][11];
    static int[] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        path = new int[n];
        int idx = 0;
        String s = br.readLine();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                matrix[i][j] = s.charAt(idx++);
            }
        }
        find(0);
    }

    static void find(int x) {
        if (x == n) {
            for (int i : path) {
                System.out.printf("%d ", i);
            }
            System.exit(0);
        }
        for (int i = -10; i <= 10; i++) {
            path[x] = i;
            if (isValid(x)) {
                find(x + 1);
            }
        }
    }

    static boolean isValid(int s) {
        int sum = 0;
        for (int i = s; i >= 0; i--) {
            sum += path[i];
            char op = matrix[i][s];

            if (op == '0' && sum != 0) {
                return false;
            }
            if (op == '+' && sum <= 0) {
                return false;
            }
            if (op == '-' && sum >= 0) {
                return false;
            }
        }
        return true;
    }
}
