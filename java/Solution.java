package Problems;
import java.util.*;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        int[] indegree = new int[numCourses];


        for(int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];

            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0)
                queue.offer(i);
        }

        int count = 0;

        while(!queue.isEmpty()) {

            int current = queue.poll();
            count++;

            for(int neighbor : graph.get(current)) {

                indegree[neighbor]--;

                if(indegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }


        return count == numCourses;
    }

    public static void main(String[] args) {

        Solution obj = new Solution();

        int numCourses = 4;

        int[][] prerequisites = {
                {1,0},
                {2,1},
                {3,2}
        };

        System.out.println(obj.canFinish(numCourses, prerequisites));
    }
}