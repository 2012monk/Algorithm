package BOJ.N12931두배더하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] a, b;
    static int n, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        stz = new StringTokenizer(br.readLine());
        a = new int[n];
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(stz.nextToken());
        }
        solve(0);
        if (ans > 0) ans--;
        System.out.println(ans);
    }

    static void solve(int count) {
        if (Arrays.stream(b).sum() == 0) {
            ans = Math.min(ans, count);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (b[i] == 0) continue;
            if (b[i] % 2 != 0) {
                b[i]--;
                count++;
            }
            b[i] /= 2;
        }
        solve(count + 1);
    }
}
