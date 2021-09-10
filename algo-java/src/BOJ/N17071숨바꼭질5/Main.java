package BOJ.N17071숨바꼭질5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static final int MAX = 500001;
    static int[][] visited = new int[2][MAX];
    static int n, k;
    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        Arrays.fill(visited[0], -1);
        Arrays.fill(visited[1], -1);
        bfs();
        int t = 0;
        int state = 0;
        int res = -1;
        while (k < MAX) {
            if (visited[state][k] == -1) continue;
            if (visited[state][k] <= t) {
                res = t;
                break;
            }
            k += ++t;
            state^=1;
        }
        System.out.println(res);
    }

    static void bfs(){
        q.offer(new int[]{n, 0});
        visited[0][n] = 0;
        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int time = q.poll()[1];
            int state = 1-(time%2);
            for (int dx: new int[]{x*2,x-1,x+1}) {
                if (dx < 0 || dx >= MAX) continue;
                if (visited[state][dx] != -1) continue;
                visited[state][dx] = time + 1;
                q.offer(new int[]{dx, time+1});
            }
        }
    }
}
