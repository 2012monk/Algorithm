package BOJ.N16638괄호추가하기2;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    static char[] orig;
    static boolean[] parenthesis = new boolean[50];
    static List<P> o = new ArrayList<>();
    static int n, ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        orig = s.toCharArray();
        for (char c : s.toCharArray()) {
            o.add(new P(c));
        }
        solve(1);
        System.out.println(ans);
    }

    private static void solve(int x) {
        if (x >= n) {
            ans = max(ans, calculate(postFixFormula()));
            return ;
        }
        if (x == 1 || !parenthesis[x - 2]) {
            parenthesis[x] = true;
            solve(x + 2);
            parenthesis[x] = false;

        }
        solve(x + 2);
    }

    private static ArrayDeque<P> postFixFormula() {
        Stack<P> st = new Stack<>();
        ArrayDeque<P> out = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            P x = o.get(i);
            if (x.isDigit()) {
                out.addLast(x);
                continue;
            }
            if (parenthesis[i]) {
                x = new P(x.chr);
                x.p = 3;
            }
            while (!st.isEmpty() && st.peek().p >= x.p) {
                out.addLast(st.pop());
            }
            st.push(x);
        }
        while (!st.isEmpty()) {
            out.addLast(st.pop());
        }
        return out;
    }

    private static int calculate(ArrayDeque<P> st) {
        Stack<Integer> tmp = new Stack<>();
        while (!st.isEmpty()) {
            P p = st.removeFirst();
            if (p.isDigit()) {
                tmp.push(p.chr -'0');
                continue;
            }
            int x = tmp.pop();
            int y = tmp.pop();
            tmp.push(eval(y,x,p.chr));
        }
        return tmp.pop();
    }

    private static int getPriority(char c) {
        if (c == '*') return 2;
        if (c == '+' || c == '-') return 1;
        return 0;
    }

    private static int eval(int a, int b, char c) {
        if (c == '+') return a + b;
        if (c == '-') return a - b;
        return a * b;
    }

    static class P{
        char chr;
        int p;
        public P(char c) {
            this.chr = c;
            this.p = getPriority(c);
        }
        boolean isDigit() {
            return Character.isDigit(chr);
        }
    }
}