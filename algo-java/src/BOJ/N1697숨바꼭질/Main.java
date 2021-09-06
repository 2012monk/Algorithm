package BOJ.N1697숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int n, m;
    static int[] d;
    static Queue<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(dfs(m));
        bfs();
    }
    static void bfs(){
        q.offer(n);
        d[n] = 0;
        while (!q.isEmpty()) {
            Integer x = q.poll();
            if (x == m) {
                System.out.println(d[x]);
                System.exit(0);
            }
            for (int dx : new int[]{x + 1, x - 1, x * 2}) {
                if (dx >= 0 && dx <= 100001 && d[dx] == 0) {
                    q.offer(dx);
                    d[dx] = d[x] + 1;
                }
            }
        }
    }


    static void init() throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        d = new int[100002];
    }

    static int dfs(int m) {
        if (m <= n) return n-m;
        else if (m == 1) return 1;
        else if (m % 2 != 0) return 1 + Math.min(dfs(m-1), dfs(m+1));
        return Math.min(m-n,1+dfs(m/2));
    }


}
