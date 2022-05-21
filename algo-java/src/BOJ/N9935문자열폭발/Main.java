package BOJ.N9935문자열폭발;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String EMPTY = "FRULA";
    static char[] target,s, a;
    static int head = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine().toCharArray();
        target = br.readLine().toCharArray();
        a = new char[s.length];
        solve();
        String result = new String(a, 0, head);
        if (result.equals("")) result = EMPTY;
        System.out.println(result);
    }

    static void solve() {
        for (char c : s) {
            a[head++] = c;
            if (match()) {
                head -= target.length;
            }
        }
    }

    private static boolean match() {
        if (head < target.length) return false;
        for (int i = 0; i < target.length; i++) {
            if (a[head -target.length + i] != target[i]) return false;
        }
        return true;
    }
}
