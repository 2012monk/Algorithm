package BOJ.N12969ABC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][][] d = new boolean[31][31][451];
    static int[] path;
    static int n,k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        path = new int[n];
        if (f(0,0,0,0)) {
            print();
        } else {
            System.out.println("-1");
        }
    }

    static boolean f(int i, int a, int b, int pair) {
        if (i == n) {
            return pair == k;
        }
        if (d[a][b][pair]) return false;
        d[a][b][pair] = true;
        path[i] = 0;
        if (f(i + 1, a + 1, b, pair)) return true;
        path[i] = 1;
        if (f(i + 1, a, b + 1, pair + a)) return true;
        path[i] = 2;
        return f(i + 1, a, b, pair + a + b);
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i : path) {
            sb.append((char) (i + 'A'));
        }
        System.out.println(sb);
    }
}