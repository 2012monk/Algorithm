package BOJ.N10827ab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int k, comp;
    static String a;

    static String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int size = Math.max(a.length(), b.length());
        int carry = 0;
        for (int i = 0; i < size; i++) {
            int tmp = carry;
            if (i < a.length()) tmp += a.charAt(a.length() - i - 1) - '0';
            if (i < b.length()) tmp += b.charAt(b.length() - i - 1) - '0';
            carry = tmp / 10;
            tmp %= 10;
            sb.append(tmp);
        }
        if (carry > 0) sb.append('1');
        sb.reverse();
        return sb.toString();
    }

    static String mul(String a, String b) {
        String res = "0";
        for (int i = b.length()-1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            for (int j = a.length()-1; j >= 0; j--) {
                int tmp = carry;
                tmp += (a.charAt(j)-'0') * (b.charAt(i)-'0');
                carry = tmp / 10;
                tmp %= 10;
                sb.append(tmp);
            }
            if (carry > 0) sb.append(carry);
            sb.reverse();
            if (i != b.length() - 1) sb.append("0".repeat(b.length() - i - 1));
            res = add(res, sb.toString());
        }
        return res;
    }

    static String power(String a, int x) {
        if (x == 1) return a;
        String tmp = power(a, x/2);
        tmp = mul(tmp, tmp);
        if ((x & 1) == 1) tmp = mul(tmp, a);
        return tmp;
    }

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        a = stz.nextToken();
        k = Integer.parseInt(stz.nextToken());
        comp = (a.length() - 1 - a.indexOf(".")) * k;
        a = a.replace(".", "");
        String r = power(a, k);
        if (comp > 0) r = r.substring(0, r.length()-comp) + "." + r.substring(r.length()-comp);
        System.out.println(r);
    }
}
