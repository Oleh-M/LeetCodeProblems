package graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;

        // create the array lists to represent the courses
        var courses = new ArrayList<List<Integer>>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }

        // create the dependency graph
        for (int i = 0; i < prerequisites.length; i++) {
            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] visited = new int[numCourses];

        // dfs visit each course
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, courses, visited)) return false;
        }

        return true;
    }

    private static boolean dfs(int course,
                               List<List<Integer>> courses,
                               int[] visited) {
        visited[course] = 1; // mark that course being visited
        var eligibleCourses = courses.get(course); // get its children

        // dfs courses
        for (int i = 0; i < eligibleCourses.size(); i++) {
            int eligibleCourse = eligibleCourses.get(i);

            // course has been visited while visiting its children (i.e. cycle)
            if (visited[eligibleCourse] == 1) return false;
            if (visited[eligibleCourse] == 0) {// not visited
                if (!dfs(eligibleCourse, courses, visited)) return false;
            }
        }

        visited[course] = 2; // mark it done visiting (any number except 1 and 0)
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{new int[]{1, 0}}));
        System.out.println(canFinish(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}}));
    }
}
