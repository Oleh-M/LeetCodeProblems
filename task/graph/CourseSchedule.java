package graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;

        // create the array lists to represent the courses
        var courses = new ArrayList<List<Integer>>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>(2));
        }
        // create the dependency for courses
        for (int[] prerequisite : prerequisites) {
            courses.get(prerequisite[1]).add(prerequisite[0]);
        }

        var visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (checkCourses(courses, visited, i)) return false;
        }

        return true;
    }

    private static boolean checkCourses(List<List<Integer>> courses, int[] visited, int course) {
        visited[course] = 1;

        var eligibleCourses = courses.get(course);

        for (Integer eligibleCourse : eligibleCourses) {
            if (visited[eligibleCourse] == 1) return true;
            if (visited[eligibleCourse] == 0) {
                if (checkCourses(courses, visited, eligibleCourse)) return true;
            }
        }

        visited[course] = 2;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{new int[]{1, 0}}));
        System.out.println(canFinish(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}}));
    }
}
