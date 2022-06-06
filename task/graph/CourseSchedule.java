package graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        var courses = new ArrayList<List<Integer>>();

        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>(2));
        }

        for (int[] prerequisite : prerequisites) {
            courses.get(prerequisite[1]).add(prerequisite[0]);
        }

        var visited = new boolean[numCourses];
        var memo = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(courses, visited, memo, i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean dfs(List<List<Integer>> courses, boolean[] visited, boolean[] memo, int course) {
        if (visited[course]) return false;
        if (memo[course]) return true;

        visited[course] = true;

        for (int i = 0; i < courses.get(course).size(); i++) {
            if (!dfs(courses, visited, memo, courses.get(course).get(i))) {
                return false;
            }
        }

        visited[course] = false;
        memo[course] = true;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{new int[]{1, 0}}));
        System.out.println(canFinish(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}}));
    }
}
