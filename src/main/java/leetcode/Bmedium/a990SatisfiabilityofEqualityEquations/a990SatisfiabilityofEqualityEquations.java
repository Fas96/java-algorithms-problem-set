package leetcode.Bmedium.a990SatisfiabilityofEqualityEquations;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class a990SatisfiabilityofEqualityEquations {
    @Test
    public void testequationsPossible(){
        assertEquals(false,equationsPossible(new String[]{"a==b","b!=a"}));
    }
    public boolean equationsPossible(String[] equations) {
        Set<String> uniqVar= new HashSet<>();
        Set<String> uniqOp= new HashSet<>();
        for (String cmp : equations) {
            uniqOp.add(cmp.substring(1,cmp.length()-1));
            uniqVar.add(cmp.substring(0,1));
            uniqVar.add(cmp.substring(cmp.length()-1));
        }
        System.out.println(uniqVar);
        System.out.println(uniqOp);
        return false;

    }
}
