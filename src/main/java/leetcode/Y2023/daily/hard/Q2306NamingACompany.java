package leetcode.Y2023.daily.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q2306NamingACompany {
    private   Set<String> getSetSimilarCompanyNames(Set<String> s1, Set<String> s2)
    {
       return s2.stream().filter(s1::contains).collect(HashSet::new, Set::add, Set::addAll);
    }

    public long distinctNames(String[] ideas) {
        Map<Character, Set<String>> companyStartingInitialsMap = new HashMap<>();

        buildCompaniesStartingInitialsTable(ideas, companyStartingInitialsMap);

        long res = 0;
        for(char key: companyStartingInitialsMap.keySet())
        {
            Set<String> currentCompany=companyStartingInitialsMap.get(key);
            for(char key1: companyStartingInitialsMap.keySet())
            {
                if(isSameCompany(key, key1)) continue;
                Set<String> ideaMatchPossible=companyStartingInitialsMap.get(key1);

                Set<String> setOfSimilarIdeas=getSetSimilarCompanyNames(currentCompany, ideaMatchPossible);

                res+=((long) getUniqueNamesCount(ideaMatchPossible, setOfSimilarIdeas) * getUniqueNamesCount(currentCompany, setOfSimilarIdeas));
            }
        }


        return res;

    }

    private  int getUniqueNamesCount(Set<String> isNameMatchPossibleCompany, Set<String> setOfSimilarNames) {
        return isNameMatchPossibleCompany.size() - setOfSimilarNames.size();
    }

    private static boolean isSameCompany(char key, char key1) {
        return key == key1;
    }

    private static void buildCompaniesStartingInitialsTable(String[] ideas, Map<Character, Set<String>> companyStartingInitialsMap) {
        for (String idea : ideas) {
            char initial = idea.charAt(0);
            Set<String> ls = companyStartingInitialsMap.getOrDefault(initial,new HashSet<>());
            ls.add(idea.substring(1));
            companyStartingInitialsMap.put(initial, ls);
        }
    }
}
