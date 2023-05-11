package sedgewick.code;

public class Recursion {
    public int rank(int key,int[]A,int low,int hi){
        if(low>hi) return -1;
        int mid = low+(hi-low)/2;
        if(key<A[mid]) return rank(key,A,low,mid-1);
        else if(key>A[mid]) return rank(key,A,mid+1,hi);
        else return mid;
    }
}
