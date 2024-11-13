public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles,h));
    }

    private static int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end =Integer.MIN_VALUE;

        for(int i=0; i<piles.length;i++){
            if (piles[i] > end) {
            end =piles[i];
            }
            }
        int result =-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(isEatingSpeedValid(piles,mid,h)){
                result = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return result; /* Time Complexity O(nlog(max(piles))) */
        }

    private static boolean isEatingSpeedValid(int[] piles, int mid, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + mid - 1) / mid;
            if (hours > h) return false;
        }
        return true;
    }
}
