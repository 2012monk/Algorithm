package BOJ.N12015가장긴증가하는수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int n = Integer.parseInt(br.readLine());
        stz = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        int hi = 0;
        a[0] = Integer.parseInt(stz.nextToken());
        while (stz.hasMoreTokens()) {
            int k = Integer.parseInt(stz.nextToken());
            if (a[hi] < k) {
                a[++hi] = k;
            } else {
                a[lowerBound(a, k, hi)] = k;
            }
        }
        System.out.println(hi + 1);
    }

    static int lowerBound(int[] a, int x, int hi) {
        int mid, lo = 0;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (a[mid] < x) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
