package BOJ.N12995트리나라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static final int MOD = 1_000_000_007;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int N, K;
    static List<Integer>[] graph = new ArrayList[51];
    static List<Integer>[] tree = new ArrayList[51];
    static long[][][] dp = new long[51][51][51];

    static long find(int root, int idx, int k) {
        if (k == 0) return 1;
        if (idx >= tree[root].size()) return k == 1 ? 1 : 0;
        if (dp[root][idx][k] != -1) return dp[root][idx][k];
        dp[root][idx][k] = 0;
        int child = tree[root].get(idx);
        for (int i = 0; i < k; i++) {
            dp[root][idx][k] += find(child, 0, i) * find(root, idx+1, k-i);
            dp[root][idx][k] %= MOD;
        }
        return dp[root][idx][k];
    }

    static void build(int root, int parent) {
        if (parent != -1) tree[parent].add(root);
        for (Integer child : graph[root]) {
            if (child == parent) continue;
            build(child, root);
        }
    }


    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stz.nextToken());
        K = Integer.parseInt(stz.nextToken());
        for (long[][] d : dp) {
            for (long[] dd : d) {
                Arrays.fill(dd, -1);
            }
        }
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz.nextToken());
            int v = Integer.parseInt(stz.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        build(1,-1);
        long result = 0;
        for (int i = 1; i < N + 1; i++) {
            result = (result + find(i, 0, K)) % MOD;
        }
        System.out.println(result);

    }


}
/*Test Case
4 3
1 2
2 3
2 4

answer 2
 */