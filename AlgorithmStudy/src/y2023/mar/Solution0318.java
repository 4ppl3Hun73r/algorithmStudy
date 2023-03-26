package y2023.mar;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/design-browser-history/
public class Solution0318 {

    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory("leetcode.com");

        history.visit("google.com");
        history.visit("facebook.com");
        history.visit("youtube.com");

        System.out.println(history.back(1));
        System.out.println(history.back(1));
        System.out.println(history.forward(1));

        history.visit("linkedin.com");
        System.out.println(history.forward(2));
        System.out.println(history.back(2));
        System.out.println(history.back(7));



    }
}

class BrowserHistory {

    List<String> histories = new LinkedList<>();
    int idx = -1;
    int size = 0;

    public BrowserHistory(String homepage) {
        histories.add(homepage);
        size = 1;
        idx = 0;
    }

    public void visit(String url) {
        idx ++;
        histories.add(idx , url);

        size = idx + 1;
    }

    public String back(int steps) {
        idx = Math.max(0, idx - steps);

        return histories.get(idx);
    }

    public String forward(int steps) {
        idx = Math.min(size - 1, idx + steps);

        return histories.get(idx);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */