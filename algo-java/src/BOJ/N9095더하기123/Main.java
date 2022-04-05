package BOJ.N9095더하기123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] c = new int[11];

    public static void main(String[] args) throws IOException {
        c[0] = 1;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int r = Integer.parseInt(br.readLine());
            System.out.println(dfs(r));
        }
    }

    private static int dfs(int n) {
        if (n < 0) {
            return 0;
        }
        if (c[n] != 0) {
            return c[n];
        }
        return dfs(n - 1) + dfs(n - 2) + dfs(n - 3);
    }
}
