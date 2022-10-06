package leetcode.Aeasy.a557ReverseWordsinaStringIII;

import java.util.Arrays;

public class AF {
    int calculateDaysBetweenDates(String date1, String date2) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] daysInMonthLeap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] date1Arr = Arrays.stream(date1.split("-")).mapToInt(Integer::parseInt).toArray();
        int[] date2Arr = Arrays.stream(date2.split("-")).mapToInt(Integer::parseInt).toArray();
        int days = 0;
        if (date1Arr[0] == date2Arr[0]) {
            if (date1Arr[1] == date2Arr[1]) {
                days = Math.abs(date1Arr[2] - date2Arr[2]);
            } else {
                days = Math.abs(date1Arr[2] - date2Arr[2]);
                for (int i = Math.min(date1Arr[1], date2Arr[1]); i < Math.max(date1Arr[1], date2Arr[1]); i++) {
                    days += daysInMonth[i - 1];
                }
            }
        } else {
            days = Math.abs(date1Arr[2] - date2Arr[2]);
            for (int i = Math.min(date1Arr[1], date2Arr[1]); i < Math.max(date1Arr[1], date2Arr[1]); i++) {
                days += daysInMonth[i - 1];
            }
            for (int i = Math.min(date1Arr[0], date2Arr[0]); i < Math.max(date1Arr[0], date2Arr[0]); i++) {
                days += checkIsLeapYear(i) ? 366 : 365;
            }
        }
        return days;
    }
    boolean checkIsLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
