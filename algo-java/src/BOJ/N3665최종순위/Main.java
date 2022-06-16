package BOJ.N3665최종순위;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[] inDegree, table;
    static List<Integer>[] g;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            input();
            LinkedList<Integer> res = sort();
            if (res == null) {
                sb.append("?\n");
                continue;
            }
            if (res.size() != n) {
                sb.append("IMPOSSIBLE\n");
                continue;
            }
            for (Integer i : res) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static LinkedList<Integer> sort() {
        Queue<Integer> q=  new LinkedList<>();
        LinkedList<Integer> res= new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            if (q.size() > 1) return null;
            int x = q.poll();
            res.add(x);
            for (Integer c : g[x]) {
                if (--inDegree[c] == 0) {
                    q.add(c);
                }
            }
        }
        return res;
    }

    static void input() throws Exception{
        n = Integer.parseInt(br.readLine());
        inDegree = new int[n + 1];
        g = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        stz = new StringTokenizer(br.readLine());
        table = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int v = Integer.parseInt(stz.nextToken());
            table[i] = v;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                g[table[i]].add(table[j]);
                inDegree[table[j]]++;
            }
        }
        m = Integer.parseInt(br.readLine());
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int hi = Integer.parseInt(stz.nextToken());
            int lo = Integer.parseInt(stz.nextToken());
            if (!g[hi].contains(lo)) {
                int tmp = hi;
                hi = lo;
                lo = tmp;
            }
            g[hi].remove(Integer.valueOf(lo));
            g[lo].add(hi);
            inDegree[hi]++;
            inDegree[lo]--;
        }
    }
}
