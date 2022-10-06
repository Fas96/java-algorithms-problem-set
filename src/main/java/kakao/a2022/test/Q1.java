package kakao.a2022.test;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Q1 {
    @Test
    public void testSolA() {
        Solution solution = new Solution();
        assertEquals(1, 1);
        assertEquals(1, 1);
    }

    @Test
    public void testSolB() {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.2 A", "2021.07.1 B", "2022.02.19 C", "2022.02.20 C"})));

    }

    @Test
    public void testSolC() {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution("2020.01.1", new String[]{"Z 3", "D 5"},
                new String[]{"2019.01.1 D", "2019.11.15 Z", "2019.08.03 D", "2019.07.1 D", "2018.12.28 Z"})));

    }
   private String addNMonthsToGivenDate(String date, int n) {
        String[] dateArr = date.split("\\.");
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);
        int totalMonths = year * 12 + month + n;
        int newYear = totalMonths / 12;
        int newMonth = totalMonths % 12;
        if (newMonth == 0) {
            newYear--;
            newMonth = 12;
        }
        return String.format("%04d.%02d.%02d", newYear, newMonth, day);

    }

    private boolean givenDateIsGreaterThanAnotherDate(String date1, String date2) {
        String[] date1Arr = date1.split("\\.");
        String[] date2Arr = date2.split("\\.");
        int year1 = Integer.parseInt(date1Arr[0]);
        int month1 = Integer.parseInt(date1Arr[1]);
        int day1 = Integer.parseInt(date1Arr[2]);

        int year2 = Integer.parseInt(date2Arr[0]);
        int month2 = Integer.parseInt(date2Arr[1]);

        int day2 = Integer.parseInt(date2Arr[2]);


        if (year1 > year2) {
            return true;
        } else if (year1 == year2) {
            if (month1 > month2) {
                return true;
            } else if (month1 == month2) {
                if (day1 > day2) {
                    return true;
                }
            }
        }
        return false;
    }
    String getGivenDateMinusOneDay(String date) {
        String[] dateArr = date.split("\\.");
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);
        if (day == 1) {
            if (month == 1) {
                year--;
                month = 12;
                day = 31;
            } else {
                month--;
                day = 31;
            }
        } else {
            day--;
        }
        return String.format("%04d.%02d.%02d", year, month, day);
    }

     class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {


            HashMap<String,Integer> termsMap=new HashMap<>();
            for (String term : terms) {
                String[] termArr = term.split(" ");
                termsMap.put(termArr[0], Integer.parseInt(termArr[1]));
            }


              List<String> privaciesList = new LinkedList<>();
              List<String> newDateList = new LinkedList<>();

            for (String privacy : privacies) {
                String[] privacyArr = privacy.split(" ");
                String date = privacyArr[0];
                String name = privacyArr[1];
                int months = termsMap.get(name);
                String newDate = addNMonthsToGivenDate(date, months);

                   if (!givenDateIsGreaterThanAnotherDate(getGivenDateMinusOneDay(newDate), today)) {
                        privaciesList.add(privacy);
                        newDateList.add(newDate);
                    }


            }

            for (int i = 0; i < newDateList.size(); i++) {
                if (givenDateIsGreaterThanAnotherDate(newDateList.get(i), today)) {
                    privaciesList.remove(i);
                }
            }

            int[] answer = new int[privaciesList.size()];
            for (int i = 0; i < privaciesList.size(); i++) {
                for (int j = 0; j < privacies.length; j++) {
                    if (privaciesList.get(i).equals(privacies[j])) {
                        answer[i] = j + 1;
                    }
                }
            }

            return  answer;
        }
    }

}
