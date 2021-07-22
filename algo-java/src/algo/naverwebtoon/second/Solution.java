package algo.naverwebtoon.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Solution {
    static public String[] solution(String s) {
        String[] answer = {};
        Stack<String > st = new Stack<>();
        ArrayList<String > result = new ArrayList<>();
        int e = s.length() - 1;
        StringBuilder ft = new StringBuilder();
        StringBuilder bt = new StringBuilder();
        for (int i=0; i<s.length() / 2;i++) {
            String rev = new StringBuffer(bt).reverse().toString();
            System.out.println("ft.toString() = " + ft.toString());
            System.out.println("bt = " + rev);
            if (ft.length() > 0 && bt.length() > 0 && ft.toString().equals(rev)){

                result.add(ft.toString());
                st.push(rev);
                ft = new StringBuilder();
                bt = new StringBuilder();
            }
            ft.append(s.charAt(i));
            bt.append(s.charAt(e - i));
//            else {
//            }
        }
        String rev = new StringBuffer(bt).reverse().toString();
        if (ft.toString().equals(rev.toString())) {
            result.add(ft.toString());
            if (s.length() % 2 != 0) {
                System.out.println(123);
                result.add(String.valueOf(s.charAt(s.length() / 2)));
            }
            st.push(rev);
        }else{
            result.add(ft.toString() + rev);
        }
        while (!st.empty()) {
            result.add(st.pop());
        }
        answer = new String[result.size()];
        for (int i=0;i<answer.length;i++){
            answer[i] = result.get(i);
        }
        return answer;
    }

    static public String[] s(String s) {
        Stack<String > st = new Stack<>();
        ArrayList<String > result = new ArrayList<>();
        int e = s.length() - 1;
        StringBuilder ft = new StringBuilder();
        StringBuilder bt = new StringBuilder();
        for (int i=0; i<s.length() / 2;i++) {
            ft.append(s.charAt(i));
            bt.append(s.charAt(e - i));

            String f = String.valueOf(s.charAt(i));
            String b = String.valueOf(s.charAt(e - i));

            if (f.equals(b)) {
                result.add(ft.toString());
                st.push(new StringBuffer(bt).reverse().toString());
                ft = new StringBuilder();
                bt = new StringBuilder();
            }
        }
        String rev = new StringBuffer(bt).reverse().toString();
        if (ft.toString().equals(rev)) {
            result.add(ft.toString());

            st.push(rev);
        }else{
            result.add(ft.toString() + rev);
        }
        while (!st.empty()) {
            result.add(st.pop());
        }
        String[] answer = new String[result.size()];
        for (int i=0;i<answer.length;i++){
            if (!result.get(i).equals("")) {
                answer[i] = result.get(i);
            }
        }
        return result.stream().filter(c -> !c.equals("")).toArray(String[]::new);
//        return answer;
    }

    public static void main(String[] args) {
        String i = "abcxyasdfasdfxyabc";
        String j = "abcxyqwertyxyabc";
        String k = "llttaattll";
        String o = "zzzzzz";
        String r = "aabaa";
        Arrays.stream(s(k)).forEach(s -> System.out.printf("%s ", s));
        System.out.println();

//        Arrays.stream(solution(o)).forEach(System.out::printf);
//        System.out.println();
//        Arrays.stream(solution(r)).forEach(System.out::printf);
//        System.out.println();
//        Arrays.stream(solution(i)).forEach(System.out::printf);
//        System.out.println();
//
//        Arrays.stream(solution(j)).forEach(System.out::printf);
//        System.out.println();
    }
}
