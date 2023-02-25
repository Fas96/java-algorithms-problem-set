package epi.arrays;

import java.util.List;

public class CanReachEnd {
    public boolean canReachEnd(List<Integer> maxAdvancedSteps){
        int furthestReachSoFar = 0, lastIdx = maxAdvancedSteps.size() - 1;
        for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastIdx; i++) {
            furthestReachSoFar = Math.max(furthestReachSoFar, maxAdvancedSteps.get(i) + i);
        }
        return furthestReachSoFar >= lastIdx;
    }
}
