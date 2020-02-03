package LeetCode;

import java.util.HashMap;

public class LC149_Max_Points_On_A_Line {
        public int maxPoints(int[][] points) {
            if (points == null || points.length == 0 || points[0] == null || points[0].length == 0) return 0;
            int num = points.length;
            if (num <= 2) return num;
            int res = 0;
            HashMap<String, Integer> slope = new HashMap<>();
            for (int i = 0; i < num; i++) {
                slope.clear();
                int vertical = 0;
                int overlap = 1;
                int max = 0;
                for(int j = i + 1; j < num; j++) {
                    if (points[i][0] == points[j][0]) {
                        if (points[i][1] == points[j][1]) {
                            overlap++;
                        } else {
                            vertical++;
                        }
                        continue;
                    }
                    int dx = points[i][0] - points[j][0];
                    int dy = points[i][1] - points[j][1];
                    int tmp = gcd(dx, dy);
                    dx /= tmp;
                    dy /= tmp;
                    String k = String.valueOf(dy) + String.valueOf(dx);

                    if (!slope.containsKey(k)) {
                        slope.put(k, 0);
                    }
                    slope.put(k, slope.get(k) + 1);
                }

                for (String s : slope.keySet()) {
                    res = Math.max(res, overlap + slope.get(s));
                }
                res = Math.max(res, vertical + overlap);
            }

            return res;
        }

        private int gcd (int a, int b) {
            if (b == 0) {
                return a;
            }else {
                return gcd(b, a % b);
            }
        }
    }
