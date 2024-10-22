
public class BestTimeToBuyAndSellStock {
    public static void main(String args[]){
        int[] prices = {2,4,1};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices){
        int min= Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0; i<prices.length; i++){  /* Time Complexity O(n) */
            if(prices[i]< min){
                min = prices[i];
            }else if (prices[i]-min>profit){
                profit=prices[i]-min;
            }
        }

        return profit;
    }
}
