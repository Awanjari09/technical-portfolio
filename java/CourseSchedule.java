package Problems;
import java.util.*;

class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];

            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            for (int neighbor : graph.get(current)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of courses: ");
        int numCourses = sc.nextInt();
        System.out.print("Enter number of prerequisite pairs: ");
        int m = sc.nextInt();
        int[][] prerequisites = new int[m][2];
        System.out.println("Enter prerequisite pairs (course prerequisite):");
        for (int i = 0; i < m; i++) {
            prerequisites[i][0] = sc.nextInt();
            prerequisites[i][1] = sc.nextInt();
        }


        System.out.println("\nCourses: " + numCourses);

        System.out.println("Prerequisites:");
        for (int i = 0; i < m; i++) {
            System.out.println(prerequisites[i][1] + " -> " + prerequisites[i][0]);
        }
        boolean result = canFinish(numCourses, prerequisites);
        if (result) {
            System.out.println("\nAll courses can be completed.");
        } else {
            System.out.println("\nCourses cannot be completed (cycle detected).");
        }
        sc.close();
    }
}