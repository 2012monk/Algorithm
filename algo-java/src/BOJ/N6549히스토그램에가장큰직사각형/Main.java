package BOJ.N6549히스토그램에가장큰직사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        while (true) {
            stz = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stz.nextToken());
            if (n == 0) break;
            int[] a = new int[n];
            int i = 0;
            while (stz.hasMoreTokens()) {
                a[i++] = Integer.parseInt(stz.nextToken());
            }
            System.out.println(find(a, n));
        }
    }

    static long find(int[] a, int n) {
        long mx = 0;
        Stack<Integer> s = new Stack<>();
        s.add(0);
        for (int i = 1; i < n; i++) {
            while (!s.isEmpty() && a[s.peek()] >= a[i]) {
                int h = a[s.pop()];
                long w = i;
                if (!s.isEmpty()) w -= 1 + s.peek();
                mx = Math.max(mx, w*h);
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
            int h = a[s.pop()];
            long w = n;
            if (!s.isEmpty()) w -= 1 + s.peek();
            mx = Math.max(mx, w*h);
        }
        return mx;
    }
}
