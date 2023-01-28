package leetcode.Bmedium.Q452MinimumNumberOfArrowsToBurstBalloons;

import java.util.*;

public class Q452MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {

        //common template for overlapping ends
        int numberOfOverlappingEnds = 0;
        int minimumEnd = Integer.MAX_VALUE;

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        for (int[] p : points) {

            if (p[0] > minimumEnd) {
                numberOfOverlappingEnds++;
                minimumEnd = p[1];
            } else {
                minimumEnd = Math.min(minimumEnd, p[1]);
            }
        }
        return numberOfOverlappingEnds + (points.length > 0 ? 1 : 0);

    }

    //test for Overlapping ends
    public int eraseOverlapIntervals(int[][] points) {
        int numberOfOverlappingEnds = 0;
        int overLappingNumber = 1;
        int minimumEnd = Integer.MIN_VALUE;
        List<Interval> interVals=new ArrayList<>();
        for (int[] p : points) {
            interVals.add(new Interval(p[0],p[1]));
        }
        Collections.sort(interVals, new Comparator<Interval>() {
            @Override
            public int compare(Interval inter1, Interval inter2) {
                return inter1.start < inter2.start?1:0;
            }
        });

        for (Interval interVal : interVals) {
            if (interVal.start >= minimumEnd) {
                numberOfOverlappingEnds+=overLappingNumber-1;
                overLappingNumber=1;
                minimumEnd = interVal.end;
            } else {
                overLappingNumber++;
                minimumEnd = interVal.end;
            }
        }
        return numberOfOverlappingEnds +  overLappingNumber-1;

    }
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }


    //https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/discuss/93735/A-Concise-Template-for-%22Overlapping-Interval-Problem%22

}
