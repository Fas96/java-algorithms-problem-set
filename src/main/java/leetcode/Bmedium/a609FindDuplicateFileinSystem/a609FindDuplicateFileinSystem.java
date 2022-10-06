package leetcode.Bmedium.a609FindDuplicateFileinSystem;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class a609FindDuplicateFileinSystem {
    public List<List<String>> findDuplicate(String[] paths) {

        Map<String,List<String>> hm=new HashMap<>();
        List<List<String>> res=new ArrayList<>();

        for (String path:paths) {
            String[] split= path.split(" ");
            String root=split[0];
            for (int i = 1; i < split.length; i++) {
                System.out.println(split[i]);
               String fileName=  split[i].toString().split("\\(")[0];
               String fileContent=  split[i].toString().split("\\(")[1];
               if(!hm.containsKey(fileContent)){
                   hm.put(fileContent,new ArrayList<>());
                   hm.get(fileContent).add(root+"/"+fileName);
               }else{

                   hm.get(fileContent).add(root+"/"+fileName);
               }

            }

        }
        for (Map.Entry<String,List<String>> val:hm.entrySet()) {
            if(val.getValue().size()>1) res.add(val.getValue());
        }





        return  res;
    }
    @Test
    public void testfindDuplicate(){
        assertEquals(Arrays.asList(Arrays.asList("root/a/2.txt","root/c/d/4.txt","root/4.txt"),Arrays.asList(Arrays.asList("root/a/1.txt","root/c/3.txt"))),findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"}));
    }
}
