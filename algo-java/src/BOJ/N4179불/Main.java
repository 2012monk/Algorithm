package BOJ.N4179불;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int n, m, dx, dy;
    static int[][] room;
    static Queue<Pos> q;
    static Pos cur;
    static int[][] dt = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) throws IOException {
        init();
        while (!q.isEmpty()) {
            cur = q.poll();
            for (int[] t : dt) {
                dx = cur.x+t[0];
                dy = cur.y+t[1];
                if (cur.d == -2 && dx >= 0 && dx < n && dy >= 0 && dy < m && room[dx][dy] >= 0) {
                    room[dx][dy] = -2;
                    q.offer(new Pos(dx,dy,-2));
                }
                if (cur.d > 0){
                    if (dx >= 0 && dx < n && dy >= 0 && dy < m) {
                        if (room[dx][dy] == 0) {
                            room[dx][dy] = cur.d + 1;
                            q.offer(new Pos(dx,dy,room[dx][dy]));
                        }
                    }
                    else{
                        System.out.println(cur.d);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    static void init() throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        q = new ArrayDeque<>();
        room = new int[1002][1002];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == '#') room[i][j] = -1;
                if (s.charAt(j) == 'J') {
                    room[i][j]=1;
                    cur =new Pos(i,j,1);
                }
                if (s.charAt(j) == 'F') {
                    room[i][j]=-2;
                    q.offer(new Pos(i,j,-2));
                }
            }
        }
        q.offer(cur);
        cur = null;
    }

    static class Pos {
        int x;
        int y;
        int d;
        public Pos(int i, int j,int di) {
            x=i;
            y=j;
            d=di;
        }
    }
}
