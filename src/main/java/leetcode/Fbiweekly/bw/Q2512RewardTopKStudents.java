package leetcode.Fbiweekly.bw;

import lombok.ToString;
import org.w3c.dom.Node;

import java.util.*;

public class Q2512RewardTopKStudents {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        PriorityQueue<Student> pq = new PriorityQueue<>((a, b) -> {
            if (a.score > b.score) {
                return -1;
            } else if (b.score > a.score) {
                return 1;
            } else {
                if (a.id > b.id) {
                    return 1;
                } else if (a.id < b.id) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        Set<String> pf = new HashSet<>();
        Set<String> nf = new HashSet<>();
        for (int i = 0; i < positive_feedback.length; i++) {
            pf.add(positive_feedback[i]);
        }
        for (int i = 0; i < negative_feedback.length; i++) {
            nf.add(negative_feedback[i]);
        }

        for (int i = 0; i < report.length; i++) {
            String reportForStudent = report[i];
            String[] words = reportForStudent.split(" ");
            int score = 0;
            for (String word : words) {
                if (pf.contains(word)) {
                    score = score + 3;
                }
                if (nf.contains(word)) {
                    score = score - 1;
                }
            }
            Student pair = new Student(score, student_id[i]);
            pq.offer(pair);
        }
        List<Integer> result = new ArrayList<>();
        while (k != 0) {
            if (pq.isEmpty()) {
                break;
            }
            Student pair = pq.poll();
            result.add(pair.id);
            k = k - 1;
        }
        return result;
    }
    class Student{
        int id;
        int score;
        public Student(int id, int score){
            this.id=id;
            this.score=score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", score=" + score +
                    '}';
        }
    }
}
