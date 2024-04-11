import java.util.*;

class Pair {
    int a, b;
    List<String> path;

    public Pair(int a, int b, List<String> path) {
        this.a = a;
        this.b = b;
        this.path = new ArrayList<>(path);
    }
}

public class Transform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        String result = bfs(c, d, x, y);
        System.out.println(result);
    }

    private static String bfs(int c, int d, int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(c, d, Collections.singletonList("(" + c + " " + d + ")")));

        Set<String> visited = new HashSet<>();
        visited.add(c + "," + d);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            if (current.a == x && current.b == y) {
                return current.path.size() - 1 + " " + String.join(" ", current.path);
            }

            // Operation I: (a, b) -> (a-b, b)
            if (current.a >= current.b) {
                int newA = current.a - current.b;
                String newState = newA + "," + current.b;
                if (!visited.contains(newState)) {
                    List<String> newPath = new ArrayList<>(current.path);
                    newPath.add("(" + newA + " " + current.b + ")");
                    queue.add(new Pair(newA, current.b, newPath));
                    visited.add(newState);
                }
            }

            // Operation II: (a, b) -> (a+b, b)
            if (current.a + current.b <= 30) { // to avoid overflow
                int newA = current.a + current.b;
                String newState = newA + "," + current.b;
                if (!visited.contains(newState)) {
                    List<String> newPath = new ArrayList<>(current.path);
                    newPath.add("(" + newA + " " + current.b + ")");
                    queue.add(new Pair(newA, current.b, newPath));
                    visited.add(newState);
                }
            }

            // Operation III: (a, b) -> (b, a)
            String newState = current.b + "," + current.a;
            if (!visited.contains(newState)) {
                List<String> newPath = new ArrayList<>(current.path);
                newPath.add("(" + current.b + " " + current.a + ")");
                queue.add(new Pair(current.b, current.a, newPath));
                visited.add(newState);
            }
        }

        return "-1";
    }
}
