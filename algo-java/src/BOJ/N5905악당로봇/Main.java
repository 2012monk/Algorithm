package BOJ.N5905악당로봇;


import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Trie root = new Trie();
    static int[][] dp = new int[1001][1001];
    static int n,m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        for (int i = 0; i < n; i++) {
            root.add(br.readLine());
        }
        root.init();
        System.out.println(root.ans());
    }

    static class Trie {
        int[][] trie = new int[1000][3];
        int[] fail = new int[1000];
        int[] match = new int[1000];
        int size = 0;

        void add(String s) {
            int cur = 0;
            for (int i = 0; i < s.length(); i++) {
                int next = s.charAt(i) - 'A';
                if (trie[cur][next] == 0) {
                    trie[cur][next] = ++size;
                }
                cur = trie[cur][next];
            }
            match[cur] = 1;
        }
        void init() {
            fail();
            initDp();
        }

        void fail() {
            Queue<Integer> q = new ArrayDeque<>();
            q.add(0);
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int i = 0; i < 3; i++) {
                    int next = trie[cur][i];
                    if (next == 0) continue;
                    if (cur == 0) {
                        fail[next] = 0;
                    }else {
                        int f = fail[cur];
                        while (f != 0 && trie[f][i] == 0) f = fail[f];
                        if (trie[f][i] != 0) f = trie[f][i];
                        fail[next] = f;
                    }
                    if (match[fail[next]] != 0) {
                        match[next] += match[fail[next]];
                    }
                    q.add(next);
                }
            }
        }

        void initDp() {
            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[3]);
            while (!q.isEmpty()) {
                int[] a = q.poll();
                dp[a[1]][a[0]] = max(dp[a[1]][a[0]], match[a[0]]);
                for (int i = 0; i < 3; i++) {
                    int next = trie[a[0]][i];
                    if (next == 0) continue;
                    q.add(new int[]{next, a[1] + 1, a[2] + match[a[0]]});
                }
            }
        }

        int ans() {
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j <= size; j++) {
                    if (dp[i][j] == 0) continue;
                    for (int k = 0; k < 3; k++) {
                        int cur = j;
                        while (cur != 0 && trie[cur][k] == 0) cur = fail[cur];
                        if (trie[cur][k] != 0) cur = trie[cur][k];
                        dp[i + 1][cur] = max(dp[i+1][cur], dp[i][j] + match[cur]);
                    }
                }
            }

            for (int i = 0; i <= size; i++) {
                ans = Math.max(ans, dp[m][i]);
            }
            return ans;
        }
    }
}
