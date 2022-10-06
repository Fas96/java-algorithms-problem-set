package atcoder.abc267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

  public static void main(String[] args)throws IOException {


  BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
  String[] lenGiven;
  String[] numsString;
  lenGiven = bi.readLine().split(" ");
  int nums[] = new int[Integer.parseInt(lenGiven[0])];
  int givenLen= Integer.parseInt(lenGiven[1]);

  numsString = bi.readLine().split(" ");

  for (int i = 0; i < nums.length; i++) {
    nums[i]=Integer.parseInt(numsString[i]);
  }

  int ans=Integer.MIN_VALUE;

  int L=0,R=0,N=nums.length;

  while (R<=N){
    if(R-L==givenLen){
      int jack=1;
      int sum=0;
      for (int i = L; i <=R-1; i++) {
        sum+=(jack*nums[i]);
        jack++;
      }
      ans=Math.max(ans,sum);
      L++;
      R--;
    }else {
      R++;
    }


  }
  System.out.println(ans);
}




}
