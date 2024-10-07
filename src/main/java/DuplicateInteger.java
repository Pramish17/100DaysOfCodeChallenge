import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DuplicateInteger {
    public static void main (String args[]){
        int[] nums = {1,2,3,3};
        System.out.println(hasDuplicate(nums));
    }
    public static boolean hasDuplicate(int[] nums) {
       Set<Integer> set = new HashSet();
       for(int i =0; i<nums.length; i++){
           if(set.contains(nums[i])){
               return true;
           }
           set.add(nums[i]);
       }
       return false;
    }
}
