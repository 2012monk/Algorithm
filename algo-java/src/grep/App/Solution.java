package grep.App;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private final Map<String, String> DB = new HashMap<>();
    private final List<Integer> cart = new ArrayList<>();
    private boolean isLoggedIn = false;

    private final List<Boolean> result = new ArrayList<>();

    public boolean[] solution(String[] infos, String[] actions) {
        for (String s: infos) {
            String[] p = s.split(" ");
            DB.put(p[0], p[1]);
        }
        for (String cmd : actions) {
            if (cmd.contains("LOGIN")) {
                String[] s = cmd.split(" ");
                login(s[0], s[1]);
            } else if (cmd.contains("ADD") && checkLogin()) {
                int item = Integer.parseInt(cmd.split(" ")[1]);
                cart.add(item);
                success();
            } else if (cmd.contains("ORDER") && checkLogin()) {
                order();
            } else {
                fail();
            }
        }

        boolean[] answer = new boolean[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;

    }

    /**
     * @return login 되어 있으면 true else false
     */
    private boolean checkLogin() {
        if (!isLoggedIn) {
            result.add(false);
            return false;
        }
        return true;
    }

    private void success() {
        result.add(true);
    }

    private void fail() {
        result.add(false);
    }

    private void login(String id, String password) {
        if (isLoggedIn) {
            result.add(false);
            return;
        }
        if (DB.containsKey(id) && DB.get(id).equals(password)) {
            result.add(true);
            isLoggedIn = true;
            return;
        }
    }

    private void order() {
        if (cart.isEmpty()) {
            fail();
        }
        cart.clear();
        success();
    }
}
