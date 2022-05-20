package BOJ.N16909카드구매하기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int n = Integer.parseInt(br.readLine());
        stz = new StringTokenizer(br.readLine());
        Stack<int[]> min = new Stack<>(), max = new Stack<>();
        long ans = 0, cur = 0;
        for (int i = 1; i <= n; i++) {
            int k = Integer.parseInt(stz.nextToken());
            int mx = 1, mn = 1;
            while (!min.isEmpty() && min.peek()[0] >= k) {
                mn += min.peek()[1];
                cur += (long) (min.peek()[0] - k) * min.peek()[1];
                min.pop();
            }
            while (!max.isEmpty() && max.peek()[0] <= k) {
                mx += max.peek()[1];
                cur += (long) (k - max.peek()[0]) * max.peek()[1];
                max.pop();
            }

            min.push(new int[]{k, mn});
            max.push(new int[]{k, mx});
            ans += cur;
        }
        System.out.println(ans);
    }
}
