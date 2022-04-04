package BOJ.N1107리모컨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static Set<Integer> broken = new HashSet<>();
    static int target, N, ans;

    public static void main(String[] args) throws IOException {
        target = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        if (N > 0) {
            stz = new StringTokenizer(br.readLine());
            while (stz.hasMoreTokens()) {
                broken.add(Integer.parseInt(stz.nextToken()));
            }
        }

        ans = Math.abs(target - 100);

        if (broken.size() != 10) {
            solve();
        }
        System.out.println(ans);
    }

    private static void solve() {

        for (int i = 0; i < 1000001; i++) {
            String number = String.valueOf(i);
            if (Arrays.stream(number.split(""))
                .anyMatch(s -> broken.contains(Integer.parseInt(s)))) {
                continue;
            }
            ans = Math.min(ans, Math.abs(target - i) + number.length());
        }

    }


}
