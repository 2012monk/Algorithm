package BOJ.N2447별찍기10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean star(int x, int y, int size) {
        if (size == 3){
            return !(x == 1 && y == 1);
        }
        if (x >= size/3 && x < (size/3)*2 && y >= size/3 && y < (size/3)*2) return false;
        return star(x%(size/3), y%(size/3), size/3);
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(star(i,j,n) ? '*' : ' ');
            }
            bw.write('\n');
        }
        bw.flush();
    }


}
