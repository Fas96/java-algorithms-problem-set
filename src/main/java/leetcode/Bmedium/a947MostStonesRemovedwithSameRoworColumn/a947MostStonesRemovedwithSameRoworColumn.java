package leetcode.Bmedium.a947MostStonesRemovedwithSameRoworColumn;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

public class a947MostStonesRemovedwithSameRoworColumn {
    @Test
    public void testSolutionMostStonesRemovedwithSameRoworColumn(){
        assertEquals(5,removeStones(new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}}));
    }
    public int removeStones(int[][] stones) {


        int N=stones.length,res=0;
        int[] parent=new int[N];
        for(int i=0;i<N;i++){
            parent[i]=i;
        }
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1]){
                    union(parent,i,j);
                }
            }
        }

        for(int i=0;i<N;i++){
            if(parent[i]==i){
                res++;
            }
        }
        return N-res;

    }

    private void union(int[] parent, int i, int j) {
        int p1=find(parent,i);
        int p2=find(parent,j);
        if(p1!=p2){
            parent[p1]=p2;
        }
    }

    private int find(int[] parent, int i) {
        if(parent[i]!=i){
            parent[i]=find(parent,parent[i]);
        }
        return parent[i];
    }
}
