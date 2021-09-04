package BOJ.N12920평범한배낭2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int n,m,p;
    static int[][] items, memo;
    static int[] cache;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(knapsack(m, p));
        for (int i=0;i<=p;i++) {
            for (int j=m;j>=items[i][0];j--) {
                if (cache[j] < cache[j-items[i][0]] + items[i][1]) cache[j] = cache[j-items[i][0]] + items[i][1];
            }
        }
        System.out.println(cache[m]);
    }

    static void init() throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());

        items = new int[2345][2];
        cache = new int[m+1];
        memo = new int[2345][m+1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        p=0;
        for (int i=0;i<n;i++) {
            stz = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(stz.nextToken());
            int v = Integer.parseInt(stz.nextToken());
            int k = Integer.parseInt(stz.nextToken());
            for (int j=1;k>0;j<<=1) {
                int x = Math.min(j, k);
                items[p++] = new int[]{x * w, x * v};
                k-=x;
            }
        }

    }

    public static int knapsack(int weight, int k) {
        if (k < 0) return 0;
        if (memo[k][weight] != -1) return memo[k][weight];

        if (items[k][0] > weight) return memo[k][weight] = knapsack(weight, k-1);
        return memo[k][weight] = Math.max(
            knapsack(weight,k - 1),
            knapsack(weight-items[k][0], k -1) + items[k][1]);

    }

}
