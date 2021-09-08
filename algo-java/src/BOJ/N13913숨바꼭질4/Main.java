package BOJ.N13913숨바꼭질4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int[] v;
    static int n, k, MAX=1000001;
    static ArrayDeque<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        init();
        v[n] = n;
        q.offer(n);
        while (!q.isEmpty()) {
            int x = q.poll();
            if (x == k) break;
            for (int dx: new int[]{x*2,x+1,x-1}) {
                if (dx < 0 || dx >= MAX) continue;
                if (v[dx] != -1) continue;
                v[dx] = x;
                q.offer(dx);
            }
        }
        LinkedList<String> l = new LinkedList<>();
        int res = 0;
        while (k != n) {
            l.addFirst(String.valueOf(k));
            k = v[k];
            res++;
        }
        l.addFirst(String.valueOf(n));
        System.out.println(res);
        System.out.println(String.join(" ", l));
    }

    static void init() throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        v = new int[MAX];
        Arrays.fill(v,-1);
    }
}
