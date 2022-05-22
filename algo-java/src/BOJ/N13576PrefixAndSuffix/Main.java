package BOJ.N13576PrefixAndSuffix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
        new Main().solve(s);
    }

    void solve(String s) {
        char[] src = s.toCharArray();
        int size = 0;
        int[] z = z(src);
        z[0] = src.length;
        int[] arr = Arrays.copyOf(z, z.length);
        Arrays.sort(arr);
        StringBuilder sb  = new StringBuilder();
        for (int i = src.length - 1; i >= 0; i--) {
            if (i + z[i] != src.length) continue;
            size++;
            sb.append(z[i]).append(' ')
                .append(z.length - lb(arr, z[i])).append('\n');
        }
        sb.insert(0, size + "\n");
        System.out.println(sb);
    }

    int lb(int[] a, int v){
        int mid,l = 0, h = a.length - 1;
        while (l < h) {
            mid = (l + h) / 2;
            if (a[mid] >= v) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }

    int[] z(char[] src) {
        int[] z = new int[src.length];
        for (int i = 1, l = 0, r = 0; i < src.length; i++) {
            if (i <= r) {
                z[i] = Math.min(z[i - l], r-i+1);
            }
            while (i + z[i] < src.length && src[i+z[i]] == src[z[i]]) z[i]++;
            if (r < i + z[i] - 1) {
                r = i + z[i] - 1;
                l = i;
            }
        }
        return z;
    }
}
