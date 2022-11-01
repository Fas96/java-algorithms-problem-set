class Solution {
    public int countTime(String time) {
    // Input: time = "?5:00"
    // Output: 2
    // Explanation: We can replace the ? with either a 0 or 1, producing "05:00" or "15:00". Note that we cannot replace it with a 2, since the time "25:00" is invalid. In total, we have two choices.
    // Example 2:
    //
    //     Input: time = "0?:0?"
    // Output: 100
    // Explanation: Each ? can be replaced by any digit from 0 to 9, so we have 100 total choices.
    // Example 3:
    //
    //     Input: time = "??:??"
    // Output: 1440
    // Explanation: There are 24 possible choices for the hours, and 60 possible choices for the minutes. In total, we have 24 * 60 = 1440 choices.


     //least TIME "00:00" and the latest possible time is "23:59".
    int mod = 1000000007;
    int ans = 0;
    int n = time.length();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
        nums[i] = time.charAt(i) - '0';

    }
    int[] arr = new int[n];






  }
}
