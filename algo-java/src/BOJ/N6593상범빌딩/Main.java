package BOJ.N6593상범빌딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int n, m, h;
    static char[][][] cube;
    static int[] nx = {0,0,0,0,1,-1};
    static int[] ny = {0,0,1,-1,0,0};
    static int[] nh = {1,-1,0,0,0,0};
    static Queue<Dot> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {


        while (true){
            stz = new StringTokenizer(br.readLine());
            h = Integer.parseInt(stz.nextToken());
            n = Integer.parseInt(stz.nextToken());
            m = Integer.parseInt(stz.nextToken());
            cube = new char[h][n][m];
            if ((h+n+m)==0) break;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < n; j++) {
                    cube[i][j] = br.readLine().toCharArray();
                    for (int k = 0; k < m; k++) {
                        if (cube[i][j][k] == 'S') {
                            q.offer(new Dot(i,j,k,0));
                        }
                    }
                }
                br.readLine();
            }
            bfs();
            q.clear();
        }

    }
    static void bfs() {
        while (!q.isEmpty()) {
            Dot cur = q.poll();
            for (int t = 0; t < 6; t++) {
                int di = nx[t] + cur.i;
                int dj = ny[t] + cur.j;
                int dk = nh[t] + cur.k;
                if (di < 0 || di >= h || dj < 0 || dj >= n || dk < 0 || dk >= m) continue;
                if (cube[di][dj][dk] == 'E'){
                    System.out.printf("Escaped in %d minute(s).\n", cur.d+1);
                    return;
                }
                if (cube[di][dj][dk] != '.') continue;
                cube[di][dj][dk] = ',';
                q.offer(new Dot(di,dj,dk,cur.d+1));
            }
        }
        System.out.println("Trapped!");
    }

    static class Dot{
        int i;int j;int k;int d;
        public Dot(int i, int j,int k,int d) {
            this.i = i;this.j = j;this.k =k;this.d=d;
        }
    }
}
