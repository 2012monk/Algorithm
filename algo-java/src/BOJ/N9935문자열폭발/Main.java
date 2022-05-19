package BOJ.N9935문자열폭발;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {

    private static final String EMPTY = "FRULA";
    static String target;
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        target = br.readLine();
        solve();
    }

    static void solve() {
        Stack<E> st = new Stack<>();
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == target.charAt(c)) {
                c++;
            } else if (s.charAt(i) == target.charAt(0)) {
                c = 1;
            } else {
                c = 0;
            }
            st.push(new E(s.charAt(i), c));
            if (c == target.length())  {
                while (c-- > 0) st.pop();
                c = 0;
                if (!st.isEmpty()) {
                    c = st.peek().p;
                }
            }
        }
        String res = st.stream().map(e -> String.valueOf(e.c))
            .collect(Collectors.joining());
        if (res.isEmpty()) res = EMPTY;
        System.out.println(res);
    }

    static class E {
        char c;
        int p;

        public E(char c, int p) {
            this.c = c;
            this.p = p;
        }
    }
}
