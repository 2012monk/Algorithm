package BOJ.N11047동전0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,k;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int ans = 0, i = n - 1;
        while (k > 0 && i >= 0) {
            if (k < a[i]) {
                i--;
                continue;
            }
            int c = k / a[i];
            k -= a[i] * c;
            ans += c;
        }
        System.out.println(ans);
    }
}
