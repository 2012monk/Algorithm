package BOJ.N12104순환순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] src = (s + s).toCharArray();
        char[] key = br.readLine().toCharArray();
        n = key.length;
        System.out.println(kmp(key, src));
    }

    static int kmp(char[] key, char[] src) {
        int[] t = table(key);
        int ans = 0, j = 0;
        for (int i = 0; i < src.length - 1; i++) {
            while (j > 0 && src[i] != key[j]) j = t[j - 1];
            if (src[i] == key[j]) j++;
            if (j == key.length) {
                ans++;
                j = t[j - 1];
            }
        }
        return ans;
    }

    static int[] table(char[] src) {
        int[] t = new int[src.length];
        int j = 0;
        for (int i = 1; i < src.length; i++) {
            while (j > 0 && src[i] != src[j]) j = t[j - 1];
            if (src[i] == src[j]) t[i] = ++j;
        }
        return t;
    }
}
