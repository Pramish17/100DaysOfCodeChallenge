
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicateInteger {
    public static void main (String args[]){
        int[] nums = {1,2,3,4};
        System.out.println(hasDuplicate(nums));
    }
    public static boolean hasDuplicate(int[] nums) {

       Set<Integer> set = new HashSet();    /* Time Complexity O(n)*/
       for(int i =0; i<nums.length; i++){
           if(set.contains(nums[i])){
               return true;
           }
           set.add(nums[i]);
       }

       return false;

    }
}



//        Arrays.sort(nums); /* Time Complexity O(nlogn) */
//        for(int i=0; i<nums.length-1; i++){
//            if(nums[i]==nums[i+1]){
//                return true;
//            }
//        }

//using stream /* Time complexity O(n) */
//        if(Arrays.stream(nums).distinct().count()!= nums.length){
//            return true;
//        }
