import java.util.HashMap;

public class IsAnagram {
    public static void main(String[] args){
        String s = "racecar";
        String t = "carrace";
        System.out.println (isAnagram(s,t));
    }

    private static boolean isAnagram(String s, String t) {  /* Time Complexity O(n) */
        if(s.length()!=t.length()){
            return false;
        }
        boolean result;

        HashMap<Character, Integer> mapS = new HashMap();
        HashMap<Character, Integer> mapT = new HashMap();

        for(int i =0; i<s.length();i++){
            mapS.put(s.charAt(i),mapS.getOrDefault(s.charAt(i),0)+1);
            mapT.put(t.charAt(i),mapT.getOrDefault(t.charAt(i),0)+1);
        }

        result = mapS.equals(mapT);

        return result;
    }
}
