package y2022.mar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

// https://leetcode.com/problems/simplify-path/
public class Solution0314 {
    public String simplifyPath(String path) {
        /*
         dir path 를 간단하게 만들기

         /home//foo -> /home/foo
         /home/foo/ -> /home/foo
         /home/../ -> /home
         /home/./././ -> /home

         /home/../foo/../var
            /foo
            /home
            /var
         /

         path consists of English letters, digits, period '.', slash '/' or '_'.
         */
        StringBuilder sb = new StringBuilder();

        String[] split = path.split("/");
        System.out.println(Arrays.toString(split));
        // home, ..
        // home, ., ., .
        // home ..
        Stack<String> stack = new Stack<>();

        for (String s : split) {
            if(s.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else if (s.length() != 0 && !s.equals(".")) {
                stack.push(s);
            }
        }
        System.out.println("stack : " + stack);

        sb.append('/');
        for (String s : stack) {
            sb.append(s);
            sb.append('/');
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    public String simplifyPathDeque(String path) {
        String[] strs = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for (String s : strs) {
            if (s.length() == 0 || s.equals("."))  {
                continue;
            } else if (s.equals("..")) {
                deque.pollFirst();
            } else {
                deque.offerFirst(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/").append(deque.pollLast());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Solution0314 s = new Solution0314();

        //System.out.println(s.simplifyPath("/home//foo/"));
        //System.out.println(s.simplifyPath("/home/../foo/../var"));
        //System.out.println(s.simplifyPath("/../"));
        //System.out.println(s.simplifyPath("/home/"));
        //System.out.println(s.simplifyPath("/home//foo/"));
        System.out.println(s.simplifyPath("/a/./b/../../c/")); // "/a/c", "/c"
    }
}
