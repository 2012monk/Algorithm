package BOJ.N1748수이어쓰기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        long ans = 0;
        long n = Long.parseLong(br.readLine());
        for (int i = 1; i <= n; i = i * 10) ans += n - i + 1;
        System.out.println(ans);
    }
}
