package kakao.a2022.test;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Q2 {


    @Test
    public void testSolC(){

        assertEquals("dllrl", solution(3,4,2,3,3,1,5));
//        assertEquals("dr",solution(2,2,1,1,2,2,2));
//        assertEquals("impossible",solution(3,3,1,2,3,3,4));

    }

         public String solution(int n, int m, int x, int y, int r, int c, int k) {
             StringBuilder sb = new StringBuilder();

                String[][] map = new String[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if(x==i&&y==j){
                            map[i][j]="S";
                        } else if(r==i&&c==j){
                            map[i][j]="E";
                        }else {
                            map[i][j]=".";
                        }
                    }
                }
                //perform dfs on map start from S(x,y)  end at E(r,c) return path
               dfs(map,x,y,r,c,k,sb);

                return sb.toString();
         }

    private void dfs(String[][] map, int x, int y, int r, int c, int k, StringBuilder sb) {
        if(x==r&&y==c){
            return;
        }
        if(k==0){
            sb.append("impossible");
            return;
        }
        if(x+1<map.length&&map[x+1][y].equals(".")){
            map[x+1][y]="l";
            sb.append("l");
            dfs(map,x+1,y,r,c,k-1,sb);
        }else if(y+1<map[0].length&&map[x][y+1].equals(".")){
            map[x][y+1]="d";
            sb.append("r");
            dfs(map,x,y+1,r,c,k-1,sb);
        }else if(x-1>=0&&map[x-1][y].equals(".")){
            map[x-1][y]="d";
            sb.append("d");
            dfs(map,x-1,y,r,c,k-1,sb);
        }else if(y-1>=0&&map[x][y-1].equals(".")){
            map[x][y-1]="r";
            sb.append("r");
            dfs(map,x,y-1,r,c,k-1,sb);
        }else {
            sb.append("impossible");
            return;
        }
    }


}
