package BOJ.N13549숨바꼭질3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    final static int MAX = 1000001;
    static boolean[] v;
    static int n, k;
    static Deque<int[]> q = new ArrayDeque<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        init();
        dijkstra();
    }

    static void deque() {
        q.offer(new int[]{0, n});
        v[n]=true;
        while(!q.isEmpty()) {
            int[] nxt = q.poll();
            int d = nxt[0];
            int x = nxt[1];
            if (x == k) {
                System.out.println(d);
                return;
            }
            if (x*2<1000001&&!v[x*2]){
                v[x*2] = true;
                q.offerFirst(new int[]{d,x*2});
            }
            if (x+1<1000001&&!v[x+1]) {
                v[x+1] = true;
                q.offerLast(new int[]{d+1,x+1});
            }
            if (x-1>=0&&!v[x-1]) {
                v[x-1] = true;
                q.offerLast(new int[]{d+1,x-1});
            }
        }
    }

    static void dijkstra() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(t-> t[0]));
        q.offer(new int[]{0,n});
        dist[n] = 0;
        while (!q.isEmpty()) {
            int x = q.peek()[1];
            int d = q.poll()[0];
            dist[x] = 0;
            if (x == k) {
                System.out.println(d);
                return;
            }
            for (int dx: new int[]{x*2,x+1,x-1}) {
                if (dx < 0 || dx >= MAX) continue;
                int di = x*2==dx ? d : d+1;
                if (dist[dx] > di){
                    dist[dx] = di;
                    q.offer(new int[]{di,dx});
                }
            }
        }
        System.out.println(dist[k]);
    }

    static void init() throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        v = new boolean[MAX];
        dist = new int[MAX];
    }

}
