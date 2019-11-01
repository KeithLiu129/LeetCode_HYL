package LeetCode;

//210. Course Schedule II
//https://leetcode.com/problems/course-schedule-ii/


import java.util.ArrayList;
import java.util.List;

public class LC210_Course_Schedule_II {

    private int curLab = 0;
    private enum Status {
        INITIAL, PROCESSING, DONE;
    }

    private static class Vertex {
        public int label;
        public List<Integer> nexts;
        public Status status;

        public Vertex(int label) {
          this.label = label;
          nexts = new ArrayList<>();
          status = Status.INITIAL;
        }
    }



    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Vertex[] courses = new Vertex[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Vertex(i);
        }
        int[] res = new int[numCourses];
        int row = prerequisites.length;
        for (int i = 0; i < row; i++) {
            int prev = prerequisites[i][1], next = prerequisites[i][0];
            courses[prev].nexts.add(next);
        }
        curLab = numCourses - 1;

        for (int i = 0; i < numCourses; i++) {
            if (topo(courses[i], courses, res)) {
                return new int[0]; // find out there is no such res
            }
        }

        return res;
    }

    private boolean topo(Vertex source, Vertex[] courses, int[] res) {
        if (source.status == Status.DONE) return false;
        if (source.status == Status.PROCESSING) return true;

        source.status = Status.PROCESSING;

        for (int next : source.nexts) {
            if (topo(courses[next], courses, res)) {
                return true;
            }
        }

        source.status = Status.DONE;
        res[curLab--] = source.label;
        return false;
    }
}
