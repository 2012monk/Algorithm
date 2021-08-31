package BOJ.N14002가장긴증가하는부분수열4;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] a, b, c;
    static int n;

    public static void init() throws IOException {
        a = new int[1001];
        b = new int[1001];
        c = new int[1001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < n; i++) {
            int t = 0;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && t < b[j]) {
                    t = b[j];
                }
            }
            b[i] = t + 1;
        }

        int t = 0;
        for (int i = 0; i < n; i++) {
            t = Math.max(t, b[i]);
        }

        System.out.println(t);
        int end = t;
        for (int i = n - 1; i >= 0; i--) {
            if (b[i] == t) {
                c[t--] = a[i];
            }
        }

        for (int i = 1; i <= end; i++) {
            System.out.printf("%d ", c[i]);
        }
    }

}
