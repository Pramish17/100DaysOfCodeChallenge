public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] fruits = {2,2,3,3,1,1,2,3,4};
        System.out.println(totalFruit(fruits));
    }

    private static int totalFruit(int[] fruits) {
        int count =0;
        int lastFruit = -1;
        int secondLastFruit = -1;
        int currentMax = 0;
        int max = 0;

        for(Integer fruit: fruits){
            if(fruit==lastFruit || fruit ==secondLastFruit){
                currentMax = currentMax+1;
            }else{
                currentMax = count+1;
            }

            if(fruit==lastFruit){
                count =count+1;
            }else{
                count =1;
            }
            if(fruit!=lastFruit){
                secondLastFruit=lastFruit;
                lastFruit=fruit;
            }
            max = Math.max(currentMax,max);

        }
        return max; /* Time Complexity O(n) , Space Complexity O(1) */

    }
}
