package BOJ.N2637장난감조립;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static int n,m;
    static List<Part>[] g;
    static int[] inDegree, a;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        inDegree = new int[n + 1];
        g = new List[n + 1];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int hi = Integer.parseInt(stz.nextToken());
            int lo = Integer.parseInt(stz.nextToken());
            int q = Integer.parseInt(stz.nextToken());
            g[lo].add(new Part(hi, q));
            inDegree[hi]++;
        }
        StringBuilder sb = new StringBuilder();
        for (Part part : solve()) {
            sb.append(part.target).append(' ').append(part.q).append('\n');
        }
        System.out.println(sb);
    }

    static List<Part> solve() {
        Queue<Integer> q = new LinkedList<>();
        int[][] cost = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                cost[i][i] = 1;
            }
        }
        List<Integer> basic = new ArrayList<>(q);
        while (!q.isEmpty()) {
            int x = q.poll();
            for (Part part : g[x]) {
                for (int i = 1; i <= n; i++) {
                    cost[part.target][i] += cost[x][i] * part.q;
                }
                if (--inDegree[part.target] == 0) q.add(part.target);
            }
        }
        return basic.stream().map(i -> new Part(i, cost[n][i])).collect(Collectors.toList());
    }

    static class Part {
        int target, q;

        public Part(int target, int q) {
            this.target = target;
            this.q = q;
        }
    }
}
