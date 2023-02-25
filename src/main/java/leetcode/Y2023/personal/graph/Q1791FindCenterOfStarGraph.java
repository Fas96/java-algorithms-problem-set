package leetcode.Y2023.personal.graph;

import java.util.*;

public class Q1791FindCenterOfStarGraph {
    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
