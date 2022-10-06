package atcoder.abc267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A {
    int numberOfdays() throws IOException {
    List<String> days=new ArrayList<>();
    days.addAll(
        Arrays.asList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday","Saturday"));
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String day=reader.readLine();

    int dayIdx=days.indexOf(day);
    return  days.size()-dayIdx-1;
  }

}
