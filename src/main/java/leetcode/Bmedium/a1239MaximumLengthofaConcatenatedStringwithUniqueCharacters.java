package leetcode.Bmedium;


import java.util.List;

public class a1239MaximumLengthofaConcatenatedStringwithUniqueCharacters {
    private boolean isUnique(String s){
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
            if(count[s.charAt(i)-'a']>1){
                return false;
            }
        }
        return true;

    }

    public int maxLength(List<String> arr) {
        int[] res = new int[1];
        dfs(arr,0,"",res);
        return res[0];
    }

    private void dfs(List<String> arr, int i, String s, int[] res) {
        if(i==arr.size()){
            if(isUnique(s)){
                res[0]=Math.max(res[0],s.length());
            }
            return;
        }
        dfs(arr,i+1,s,res);
        dfs(arr,i+1,s+arr.get(i),res);
    }
}

//    function isUnique(s: string) {
//    const set = new Set();
//        for (const c of s) {
//            if (set.has(c)) {
//                return false;
//            }
//            set.add(c);
//        }
//        return true;
//    }
//
//    function maxLength(arr: string[]): number {
//        let max = 0;
//        const dfs = (index: number, str: string) => {
//        if (index === arr.length) {
//        max = Math.max(max, str.length);
//        return;
//        }
//        if (isUnique(str + arr[index])) {
//        dfs(index + 1, str + arr[index]);
//        }
//        dfs(index + 1, str);
//        };
//        dfs(0, '');
//        return max;
//
//        };
