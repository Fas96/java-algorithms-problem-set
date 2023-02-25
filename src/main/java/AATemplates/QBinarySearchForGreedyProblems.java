package AATemplates;

public class QBinarySearchForGreedyProblems {
    //If looking for a minimum:
    public int fnMin(int[] arr) {
        //MINIMUM_POSSIBLE_ANSWER and MAXIMUM_POSSIBLE_ANSWER are the minimum and maximum possible answers
        //TODO:CRITERIA specify the minimum and maximum possible answers
        int MINIMUM_POSSIBLE_ANSWER = 0;
        int MAXIMUM_POSSIBLE_ANSWER = 1000000;

        int left = MINIMUM_POSSIBLE_ANSWER;
        int right = MAXIMUM_POSSIBLE_ANSWER;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean check(int x) {
        // this function is implemented depending on the problem
        //TODO:CRITERIA specify the check function
        boolean BOOLEAN = true;
        return BOOLEAN;
    }

    //If looking for a maximum:
    public int fnMax(int[] arr) {
        //MINIMUM_POSSIBLE_ANSWER and MAXIMUM_POSSIBLE_ANSWER are the minimum and maximum possible answers
        //TODO:CRITERIA specify the minimum and maximum possible answers
        int MINIMUM_POSSIBLE_ANSWER = 0;
        int MAXIMUM_POSSIBLE_ANSWER = 1000000;
        int left = MINIMUM_POSSIBLE_ANSWER;
        int right = MAXIMUM_POSSIBLE_ANSWER;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }


}
