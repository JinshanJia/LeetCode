/*
* Name: Jinshan Jia
* 11/09/2013
* Email: jiajinshan2009@gmail.com
* Problem:WordLadderII
* The third function is the one passed the test 
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Word Ladder II
 * Given two words (start and end), and a dictionary, 
 * find all shortest transformation sequence(s) from start to end, such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 */
public class WordLadderII {
    public ArrayList<ArrayList<String>> findLadders(String start, String end,
            HashSet<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by
        // each test case.
        if (start.equals(end)) {
            ArrayList<String> r = new ArrayList<String>();
            r.add(start);
            ArrayList<ArrayList<String>> tempR = new ArrayList<ArrayList<String>>();
            tempR.add(r);
            return tempR;
        }
        dict.add(end);
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        Queue<LinkedList<String>> queue = new LinkedList<LinkedList<String>>();
        LinkedList<String> tempList = new LinkedList<String>();
        tempList.add(start);
        queue.add(tempList);
        HashMap<String, Integer> searchedHashMap = new HashMap<String, Integer>();
        searchedHashMap.put(start, 1);
        while (!queue.isEmpty()) {
            LinkedList<String> path = queue.remove();
            String poitString = path.get(path.size() - 1);
            if (poitString.equals(end)) {
                searchedHashMap.put(end, path.size());
                result.add(new ArrayList<String>(path));
                continue;
            }
            int length = poitString.length();
            for (int i = 0; i < length; i++) {
                StringBuilder tempSBuilder = new StringBuilder(poitString);
                for (int j = 0; j < 26; j++) {
                    tempSBuilder.setCharAt(i, (char)(j + 'a'));
                    String tempString = tempSBuilder.toString();
                    if (dict.contains(tempString) && 
                            (!searchedHashMap.containsKey(tempString) || searchedHashMap.get(tempString) == (path.size() + 1))) {
                        searchedHashMap.put(tempString, path.size() + 1);
                        LinkedList<String> newPath = new LinkedList<String>(path);
                        newPath.add(tempString);
                        queue.add(newPath);
                    } else if (dict.contains(tempString) && searchedHashMap.containsKey(tempString)) {
                        dict.remove(tempString);
                    }
                }
            }
        }
        return result;
    }
    
    public ArrayList<ArrayList<String>> findLadders2(String start, String end,
            HashSet<String> dict) {
        HashMap<String, HashSet<String>> adjacentListHashMap = new HashMap<String, HashSet<String>>();
        if (start.equals(end)) {
            ArrayList<String> r = new ArrayList<String>();
            r.add(start);
            ArrayList<ArrayList<String>> tempR = new ArrayList<ArrayList<String>>();
            tempR.add(r);
            return tempR;
        }
        dict.add(start);
        dict.add(end);
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        
        for (String s : dict) {
            HashSet<String> set = new HashSet<String>();
            int length = s.length();
            for (int i = 0; i < length; i++) {
                StringBuilder tempSBuilder = new StringBuilder(s);
                for (int j = 0; j < 26; j++) {
                    tempSBuilder.setCharAt(i, (char)(j + 'a'));
                    if (dict.contains(tempSBuilder.toString()) && !tempSBuilder.toString().equals(s)) {
                        set.add(tempSBuilder.toString());
                    }
                }
            }
            adjacentListHashMap.put(s, set);
        }
        
        Queue<LinkedList<String>> queue = new LinkedList<LinkedList<String>>();
        LinkedList<String> tempList = new LinkedList<String>();
        tempList.add(start);
        queue.add(tempList);
        HashMap<String, Integer> searchedHashMap = new HashMap<String, Integer>();
        searchedHashMap.put(start, 1);
        while (!queue.isEmpty()) {
            LinkedList<String> path = queue.remove();
            String poitString = path.get(path.size() - 1);
            if (poitString.equals(end)) {
                searchedHashMap.put(end, path.size());
                result.add(new ArrayList<String>(path));
                continue;
            }
            
            for (String s:adjacentListHashMap.get(poitString)) {
                if (!searchedHashMap.containsKey(s) || searchedHashMap.get(s) == (path.size() + 1)) {
                    searchedHashMap.put(s, path.size() + 1);
                    LinkedList<String> newPath = new LinkedList<String>(path);
                    newPath.add(s);
                    queue.add(newPath);
                }
            }
        }
        
        return result;
    }
    
    public ArrayList<ArrayList<String>> findLadders3(String start, String end,
            HashSet<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by
        // each test case.
        dict.add(end);
        HashMap<String, HashSet<String>> preWordsHashMap = new HashMap<String, HashSet<String>>();
        LinkedList<HashSet<String>> hashSets = new LinkedList<HashSet<String>>();
        hashSets.add(new HashSet<String>());
        hashSets.add(new HashSet<String>());
        int currentSetLevel = 0;
        hashSets.get(currentSetLevel).add(start);

        while (!hashSets.get(currentSetLevel).isEmpty()) {
            int preSetLevel = currentSetLevel;
            currentSetLevel = (currentSetLevel + 1) % 2;
            
            for (String string : hashSets.get(preSetLevel)) {
                dict.remove(string);
            }
            hashSets.get(currentSetLevel).clear();
            
            for (String string : hashSets.get(preSetLevel)) {
                int length = string.length();
                for (int i = 0; i < length; i++) {
                    StringBuilder tempSBuilder = new StringBuilder(string);
                    for (int j = 0; j < 26; j++) {
                        tempSBuilder.setCharAt(i, (char)(j + 'a'));
                        String tempString = tempSBuilder.toString();
                        if (dict.contains(tempString)) {
                            hashSets.get(currentSetLevel).add(tempString);
                            if (preWordsHashMap.containsKey(tempString)) {
                                preWordsHashMap.get(tempString).add(string);
                            } else {
                                preWordsHashMap.put(tempString, new HashSet<String>());
                                preWordsHashMap.get(tempString).add(string);
                            }
                        }
                    }
                }
            }
            
            if (preWordsHashMap.containsKey(end)) {
                return pathGenerate(preWordsHashMap, start, end);
            }
        }
        return new ArrayList<ArrayList<String>>(); 
    }
    
    public ArrayList<ArrayList<String>> pathGenerate(HashMap<String, HashSet<String>> preWordsHashMap, String start, String end) {
        LinkedList<LinkedList<String>> paths = new LinkedList<LinkedList<String>>();
        String tempString = end;
        Queue<LinkedList<String>> queue = new LinkedList<LinkedList<String>>();
        LinkedList<String> tempStrings = new LinkedList<String>();
        tempStrings.add(tempString);
        queue.add(tempStrings);
        while(!queue.isEmpty()) {
            tempStrings = queue.remove();
            tempString = tempStrings.getFirst();
            if (tempString.equals(start)) {
                paths.add(tempStrings);
                continue;
            }
            for (String string : preWordsHashMap.get(tempString)) {
                LinkedList<String> outList = new LinkedList<String>(tempStrings);
                outList.push(string);
                queue.add(outList);
            }
        }
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        for (LinkedList<String> l : paths) {
            result.add(new ArrayList<String>(l));
        }
        return result;
    }
}
