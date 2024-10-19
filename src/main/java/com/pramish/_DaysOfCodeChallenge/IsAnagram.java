package com.pramish._DaysOfCodeChallenge;

import java.util.Arrays;
import java.util.HashMap;

public class IsAnagram {
    public static void main (String args[]){
        System.out.println(isAnagram("cat", "tac"));
    }
    public static boolean isAnagram( String s, String t){
        if(s.length() != t.length()){
            return false;
        }
//        char[] sortS= s.toCharArray();
//        char[] sortT = t.toCharArray();
//        Arrays.sort(sortS);
//        Arrays.sort(sortT);
//        return Arrays.equals(sortS,sortT);
//        //time complexity : O(nlogn)
//        //space complexity : 0(1) or O(n) depending upon sorting algorithm
        HashMap<Character, Integer> mapS = new HashMap();
        HashMap<Character, Integer> mapT = new HashMap();
        for(int i=0; i<s.length(); i++){
            mapS.put(s.charAt(i),mapS.getOrDefault(s.charAt(i),0)+1);
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
return mapS.equals(mapT);
    }
}
