import java.util.Stack;

public class Leetcode71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        // Split the input string into an array of directories using '/' as the delimiter
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (!dir.isEmpty() && !dir.equals(".")) {
                // If the current directory is '..', pop the last directory from the stack
                if (dir.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    // Otherwise, push the current directory onto the stack
                    stack.push(dir);
                }
            }
        }

        // rebuild the simplified path
        StringBuilder sb = new StringBuilder("/");
            while (!stack.isEmpty()) {
                String dir = stack.pop();
                if (dir.equals("..")) {
                    continue;
                } else {
                    sb.insert(0, "/" + dir);
                }
            }
            if (sb.length() == 1) {
                return "/";
            } else {
                String result = sb.toString();
                while (!result.startsWith("/")) {
                    result = result.substring(1);
                }
                return result.substring(0, result.length()-1);
            }
    }

    public static void main(String[] args) {
        Leetcode71 solution = new Leetcode71();
        System.out.println(solution.simplifyPath("/home/")); // /home
        System.out.println(solution.simplifyPath("/home//foo/")); // /home/foo
        System.out.println(solution.simplifyPath("/home/user/Documents/../Pictures")); // /home/user/Pictures
        System.out.println(solution.simplifyPath("/../")); // /
        System.out.println(solution.simplifyPath("/.../a/../b/c/../d/./")); // /.../b/d
    }
}
