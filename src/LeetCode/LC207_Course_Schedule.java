package LeetCode;

//207. Course Schedule
//https://leetcode.com/problems/course-schedule/

import java.util.ArrayList;
import java.util.List;

public class LC207_Course_Schedule {
    private enum Status {
        INITIAL, PROCESSING, DONE;
    }

    private static class V {
        public int label;
        public List<Integer> nexts;
        public Status status;
        public V(int label) {
            this.label = label;
            this.nexts = new ArrayList<>();
            status = Status.INITIAL;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        V[] status = new V[numCourses];
        for (int i = 0; i < numCourses; i++) {
            status[i] = new V(i);
        }

        int row = prerequisites.length;
        for (int i = 0; i < row; i++) {
            int prev = prerequisites[i][1];
            int next = prerequisites[i][0];
            status[prev].nexts.add(next);
        }

        for (int i = 0; i < numCourses; i++) {
            if (containsCircle(status[i], status))
                return false;
        }

        return true;

    }

    private boolean containsCircle(V course, V[] status) {
        if (course.status == Status.DONE) return false;
        if (course.status == Status.PROCESSING) return true; //have circles


        course.status = Status.PROCESSING;

        for (int i: course.nexts) {
            if (containsCircle(status[i], status))
            return true;
        }

        course.status = Status.DONE;
        return false;
    }
}
