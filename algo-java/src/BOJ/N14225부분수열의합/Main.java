package BOJ.N14225부분수열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static int n;
    static int[] a;
    static SortedSet<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        n = Integer.parseInt(br.readLine());
        stz = new StringTokenizer(br.readLine());
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stz.nextToken());
        }
        solution();
    }

    static void solution() {
        Arrays.sort(a);
        int r = 1;
        for (int i = 0; i < n; i++) {
            if (r < a[i]) break;
            r+=a[i];
        }
        System.out.println(r);
    }

    static void brutForceSolution() {
        comb(0,0);
        int x = 1;
        while (set.contains(x)) x++;
        System.out.println(x);
    }

    static void comb(int x, int total) {
        if (x == n) {
            set.add(total);
            return;
        }
        comb(x + 1, total + a[x]);
        comb(x + 1, total);
    }
}
