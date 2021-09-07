package BOJ.N2468안전영역;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int[][] h;
    static boolean[][] v;
    static int n,res=1,cnt,top;
    static int[][] dt = {{0,1},{0,-1},{1,0},{-1,0}};
    static int[] p;
    static ArrayList<Node> l = new ArrayList<>();

    static int find(int x){
        if (p[x] == x) return x;
        return p[x] = find(p[x]);
    }

    static int union(int a, int b){
        int l = find(a);
        int r = find(b);
        if (l == r) return 0;
        p[l] = r;
        return 1;
    }

    static void unionFindSolution() {
        l.sort(Comparator.comparingInt(node -> node.h));
        Collections.reverse(l);
        int i=0,j=0;
        while (j < l.size()){
            int hi = l.get(j).h;
            while (i < l.size() && hi == l.get(i).h){
                int x = l.get(i).i;
                int y = l.get(i).j;
                v[x][y] = true;
                cnt++;
                for (int[] d : dt) {
                    int dx = d[0]+x;
                    int dy = d[1]+y;
                    if (dx >= 0 && dx < n && dy >= 0 && dy < n && v[dx][dy]){
                        cnt -= union(dx*n+dy,x*n+y);
                    }
                }
                i++;
            }
            res = Math.max(res, cnt);
            j=i;
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        init();
        unionFindSolution();
//        solve();
    }

    static void solve() {
        int m = 1;
        for (int w = 1; w <= top; w++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    v[i][j] =  w < h[i][j];
                }
            }
            int r = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!v[i][j]) continue;
                    v[i][j] = false;
                    dfs(i,j);
                    r++;
                }
            }
            m = Math.max(r, m);
        }
        System.out.println(m);
    }

    static void dfs(int x, int y) {
        for (int[] d : dt) {
            int dx = x+d[0];
            int dy = y+d[1];
            if (dx < 0 || dx >= n || dy < 0 || dy >= n) continue;
            if (!v[dx][dy]) continue;
            v[dx][dy] = false;
            dfs(dx, dy);
        }
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        h =new int[n][n];
        v=new boolean[n][n];
        p = new int[n*n];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                h[i][j] = Integer.parseInt(stz.nextToken());
                top = Math.max(top, h[i][j]);
                l.add(new Node(i,j,h[i][j]));
                p[i*n+j]=i*n+j;
            }
        }
    }



    static class Node {
        int i;int j;int h;
        public Node(int f, int s, int d) {
            this.i = f;this.j = s;this.h = d;
        }
    }

}
