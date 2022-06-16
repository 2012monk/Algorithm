package BOJ.N2523음악프로그램;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[] inDegree;
    static List<Integer>[] g;
    public static void main(String[] args) throws Exception {
        handleInput();
        if (isCycle()) {
            System.out.println(0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : sort()) {
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }

    static List<Integer> sort() {
        Queue<Integer> q=  new LinkedList<>();
        List<Integer> a = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            a.add(x);
            for (Integer c : g[x]) {
                if (--inDegree[c] == 0) {
                    q.add(c);
                }
            }
        }
        return a;
    }
    static boolean isCycle() {
        boolean[] v = new boolean[n + 1];
        boolean[] t = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (isCycle(i, v, t)) return true;
        }
        return false;
    }

    static boolean isCycle(int x, boolean[] v, boolean[] trace) {
        if (trace[x]) return true;
        if (v[x]) return false;
        v[x] = true;
        trace[x] = true;
        for (Integer c : g[x]) {
            if (isCycle(c, v, trace)) return true;
        }
        trace[x] = false;
        return false;
    }

    static void handleInput() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        inDegree = new int[n + 1];
        g = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            stz.nextToken();
            int prev = Integer.parseInt(stz.nextToken());
            while (stz.hasMoreTokens()) {
                int v = Integer.parseInt(stz.nextToken());
                g[prev].add(v);
                inDegree[v]++;
                prev = v;
            }
        }
    }
}
