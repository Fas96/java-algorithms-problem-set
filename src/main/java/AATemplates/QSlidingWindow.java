package AATemplates;

public class QSlidingWindow {
    public int fn(int[] arr) {
        //DEFINE YOUR WINDOW CONDITION HERE
        boolean WINDOW_CONDITION_BROKEN = true;

        int left = 0, ans = 0, curr = 0;

        for (int right = 0; right < arr.length; right++) {
            // do logic here to add arr[right] to curr

            while (WINDOW_CONDITION_BROKEN) {
                // remove arr[left] from curr
                left++;
            }

            // update ans
        }

        return ans;
    }
}
