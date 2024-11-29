import java.util.*;

public class DesignTwitter {

    private int timestamp;
    private Map<Integer, List<int[]>> userTweets;
    private Map<Integer, Set<Integer>> userFollows;

    public DesignTwitter() {
        timestamp = 0;
        userTweets = new HashMap<>();
        userFollows = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userTweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{timestamp--, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        userFollows.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for (int followeeId : userFollows.get(userId)) {
            if (userTweets.containsKey(followeeId)) {
                List<int[]> tweets = userTweets.get(followeeId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                minHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index});
            }
        }

        while (!minHeap.isEmpty() && newsFeed.size() < 10) {
            int[] current = minHeap.poll();
            newsFeed.add(current[1]);
            int index = current[3];
            if (index > 0) {
                int[] tweet = userTweets.get(current[2]).get(index - 1);
                minHeap.offer(new int[]{tweet[0], tweet[1], current[2], index - 1});
            }
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        userFollows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        userFollows.computeIfPresent(followerId, (k, v) -> {
            v.remove(followeeId);
            return v;
        });
    }

    public static void main(String[] args) {
        DesignTwitter twitter = new DesignTwitter();

        // Example usage
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 102);
        twitter.follow(2, 1);
        twitter.postTweet(2, 201);
        twitter.postTweet(1, 103);

        System.out.println("News Feed for User 1: " + twitter.getNewsFeed(1));
        System.out.println("News Feed for User 2: " + twitter.getNewsFeed(2));

        twitter.unfollow(2, 1);
        System.out.println("News Feed for User 2 after unfollowing User 1: " + twitter.getNewsFeed(2));
    }
}
