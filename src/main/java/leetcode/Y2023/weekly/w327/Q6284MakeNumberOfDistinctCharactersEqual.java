package leetcode.Y2023.weekly.w327;

public class Q6284MakeNumberOfDistinctCharactersEqual {
    public boolean isItPossible(String word1, String word2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }


        for(int i = 0;i < 26;i++){
            for(int j = 0;j < 26;j++){
                if(count1[i] > 0 && count2[j] > 0){
                    count1[i]--;
                    count2[j]--;

                    count1[j]++;
                    count2[i]++;
                    int stand = 0;
                    for(int v : count1){
                        if(v > 0)stand++;
                    }
                    for(int v : count2){
                        if(v > 0)stand--;
                    }
                    if(stand == 0)return true;
                    count1[j]--;
                    count2[i]--;

                    count1[i]++;
                    count2[j]++;
                }
            }
        }
        return false;

    }
}
