package BOJ.N4013ATM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n,m,start, id, sccSize;
    static int[] cash, inDegree, idTable, sccIndex, dp;
    static boolean[] isRestaurant, fin;
    static List<Integer>[] g, sccGraph;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws Exception {
        handleInput();
        convertToSccGraph();
        topology();
        long ret = 0;
        for (int i = 1; i <= n; i++) {
            if (isRestaurant[i]) {
              ret = Math.max(ret, dp[sccIndex[i]]);
            }
        }
        System.out.println(ret);
    }

    static void handleInput() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        g = new List[n + 1];
        sccGraph = new List[n + 1];
        isRestaurant = new boolean[n + 1];
        fin = new boolean[n + 1];
        cash = new int[n + 1];
        dp = new int[n + 1];
        sccIndex = new int[n + 1];
        idTable = new int[n + 1];
        inDegree = new int[n + 1];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
            sccGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz.nextToken());
            int v = Integer.parseInt(stz.nextToken());
            g[u].add(v);
        }
        for (int i = 1; i <= n; i++) {
            cash[i] = Integer.parseInt(br.readLine());
        }
        stz = new StringTokenizer(br.readLine());
        start = Integer.parseInt(stz.nextToken());
        int p = Integer.parseInt(stz.nextToken());
        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < p; i++) {
            isRestaurant[Integer.parseInt(stz.nextToken())] = true;
        }

    }

    static void topology() {
        Queue<Integer> q = new LinkedList<>();
        int[] values = new int[n + 1];
        for (int i = 1; i <= sccSize; i++) {
            if (inDegree[i] == 0) q.add(i);
        }
        for (int i = 1; i <= n; i++) {
            values[sccIndex[i]] += cash[i];
        }
        dp[sccIndex[start]] = values[sccIndex[start]];
        boolean is = false;
        while (!q.isEmpty()) {
            int cur = q.poll();
            is = is || cur == sccIndex[start];
            for (Integer next : sccGraph[cur]) {
                if (is) {
                    dp[next] = Math.max(dp[next], dp[cur] + values[next]);
                }
                if (--inDegree[next] == 0) q.add(next);
            }
        }
    }

    static void convertToSccGraph() {
        for (int i = 1; i <= n; i++) {
            if (idTable[i] == 0) dfs(i);
        }
        for (int parent = 1; parent <= n; parent++) {
            for (Integer child : g[parent]) {
                if (sccIndex[child] != sccIndex[parent]) {
                    sccGraph[sccIndex[parent]].add(sccIndex[child]);
                    inDegree[sccIndex[child]]++;
                }
            }
        }
    }

    static int dfs(int x) {
        idTable[x] = ++id;
        stack.add(x);
        int parent = idTable[x];
        for (Integer c : g[x]) {
            if (idTable[c] == 0) {
                parent = Math.min(parent, dfs(c));
            } else if (!fin[c]) {
                parent = Math.min(parent, idTable[c]);
            }
        }
        if (parent != idTable[x]) return parent;
        sccSize++;
        while (!stack.isEmpty()) {
            int val = stack.pop();
            fin[val] = true;
            sccIndex[val] = sccSize;
            if (val == x) break;
        }
        return parent;
    }
}
