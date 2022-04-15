package BOJ.N16987계란으로계란치기;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] weight, health;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        weight = new int[n];
        health = new int[n];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            health[i] = Integer.parseInt(stz.nextToken());
            weight[i] = Integer.parseInt(stz.nextToken());
        }
        System.out.println(crackIt(0, 0));
    }

    static int crackIt(int x, int count) {
        if (x == n ||  count >= n - 1) {
            return count;
        }
        if (health[x] <= 0) {
            return crackIt(x + 1, count);
        }
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (x == i || health[i] <= 0) {
                continue;
            }
            health[i] -= weight[x];
            health[x] -= weight[i];
            int k = 0;
            if (health[i] <= 0) {
                k++;
            }
            if (health[x] <= 0) {
                k++;
            }
            r = max(r, crackIt(x + 1, count + k));
            health[i] += weight[x];
            health[x] += weight[i];
        }
        return r;
    }
}
