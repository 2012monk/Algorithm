package algo.naverwebtoon.first;

import java.util.Arrays;
import java.util.Collections;

class Solution {

    public int[] sort(int[] arr) {


        return null;
    }
    public int solution(int[] prices, int[] discounts) {
        int answer = 0;
        Integer[] pa = Arrays.stream(prices).boxed().toArray(Integer[]::new);
        Integer[] ds = Arrays.stream(discounts).boxed().toArray(Integer[]::new);
        Arrays.sort(pa, Collections.reverseOrder());
        Arrays.sort(ds, Collections.reverseOrder());

        int g = Math.min(pa.length, ds.length);

        for (int i=0;i<g;i++) {
            double p = (double) ds[i] / 100;
            pa[i] = pa[i] - ((int) ((double) pa[i] * p));
        }



        for (int i: pa) {
            answer += i;
        }
        return answer;
    }



    public static void main(String[] args) {

    }
}