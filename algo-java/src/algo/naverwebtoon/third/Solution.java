package algo.naverwebtoon.third;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    static public int solution(String s, String t) {
        Pattern pattern = Pattern.compile(t);

        int result = -1;

        while (true) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()){
                s = s.replace(t, "");
                result ++;
            }else{
                break;
            }
        }

        return result + 1;
    }

    public static void main(String[] args) {
        String[][] t = new String[10][2];
        t[0] = new String[]{"aabcbcd", "abc"};
        System.out.println("solution(t[0][0], t[0][1]) = " + solution(t[0][0], t[0][1]));
    }
}