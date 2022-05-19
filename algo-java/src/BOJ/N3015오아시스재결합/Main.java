package BOJ.N3015오아시스재결합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k, n = Integer.parseInt(br.readLine());
        long ans = 0;
        Stack<long[]> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            k = Integer.parseInt(br.readLine());
            int cnt = 1;
            while (!s.isEmpty() && s.peek()[0] <= k) {
                long[] p = s.pop();
                ans += p[1];
                if (p[0] == k) {
                    cnt = (int) p[1] + 1;
                } else {
                    cnt = 1;
                }
            }
            if (!s.isEmpty()) ans++;
            s.push(new long[]{k, cnt});
        }
        System.out.println(ans);
    }
}
