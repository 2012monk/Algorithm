package BOJ.N16916부분문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static char[] needle, haystack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        haystack = br.readLine().toCharArray();
        needle = br.readLine().toCharArray();
        System.out.println(kmp());
    }

    static int kmp() {
        int begin = 0, matched = 0;
        int size = haystack.length - needle.length;
        int[] pi = partial();
        while (begin <= size) {
            if (matched < needle.length && haystack[ begin + matched ] == needle[ matched ]) {
                matched++;
                if (matched == needle.length) return 1;
                continue;
            }
            if (matched != 0) {
                begin += matched - pi[matched - 1];
                matched = pi[matched - 1];
            }
            begin++;
        }
        return 0;
    }

    static int[] partial() {
        int[] pi = new int[haystack.length];
        int begin = 1, matched = 0;

        while (begin + matched < haystack.length) {
            if (haystack[ begin + matched ] == haystack[ matched ]) {
                matched++;
                pi[begin + matched - 1] = matched;
                continue;
            }
            if (matched != 0) {
                begin += matched - pi[matched - 1];
                matched = pi[matched - 1];
                continue;
            }
            begin++;
        }
        return pi;
    }
}
