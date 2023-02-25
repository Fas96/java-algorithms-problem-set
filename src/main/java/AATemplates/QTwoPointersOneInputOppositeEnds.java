package AATemplates;

public class QTwoPointersOneInputOppositeEnds {
    public int fn(int[] arr) {
        //DEFINE YOUR CONDITION HERE
        boolean CONDITION = true;

        int left = 0;
        int right = arr.length - 1;
        int ans = 0;

        while (left < right) {
            // do some logic here with left and right
            if (CONDITION) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }
}
