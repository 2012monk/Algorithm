package BOJ.N14238출근기록;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] path;
    static boolean[][][][][] d = new boolean[51][51][51][51][51];
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int a = 0, b = 0, c = 0;
        n = s.length();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'A') a++;
            if (ch == 'B') b++;
            if (ch == 'C') c++;
        }
        path = new int[s.length()];
        if (f(0,a, b, c,0,0)) {
            print();
        } else {
            System.out.println("-1");
        }
    }

     static void print() {
        StringBuilder sb = new StringBuilder();
         for (int i : path) {
             sb.append((char) (i + 'A'));
         }
         System.out.println(sb);
    }

    static boolean f(int i, int a, int b, int c, int prev, int prev2) {
        if (i >= n) {
            return a + b + c == 0;
        }
        if (d[a][b][c][prev][prev2]) return false;
        d[a][b][c][prev][prev2] = true;
        if (a > 0) {
            path[i] = 0;
            if (f(i + 1, a - 1,b, c, 0, prev)) {
                return true;
            }
        }
        if (prev != 1 && b > 0) {
            path[i] = 1;
            if (f(i + 1,a,b - 1, c, 1, prev)) {
                return true;
            }
        }
        if (prev2 == 2 || prev == 2 || c < 1) return false;
        path[i] = 2;
        return f(i + 1, a, b, c - 1, 2, prev);
    }
}
