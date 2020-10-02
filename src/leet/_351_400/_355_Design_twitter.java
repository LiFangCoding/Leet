package leet._351_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _355_Design_twitter {
    //TODO
    static class Twitter {
        // user -> time, tweetid, idx, user
        Map<Integer, List<int[]>> tweets;
        Map<Integer, Set<Integer>> follows;
        // current timestamp
        int time;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            time = 0;
            tweets = new HashMap<>();
            follows = new HashMap<>();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            if (!tweets.containsKey(userId)) {
                tweets.put(userId, new ArrayList<>());
            }
            tweets.get(userId).add(new int[] { time, tweetId });
            time++;
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int u) {
            //存 userid, ts,
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
            if (!follows.containsKey(u)) {
                follows.put(u, new HashSet<>());
            }
            follows.get(u).add(u);
            for (int user : follows.get(u)) {
                List<int[]> utweets = tweets.get(user);
                if (utweets != null && utweets.size() != 0) {
                    int i = utweets.size() - 1;
                    pq.add(new int[] { utweets.get(i)[0], utweets.get(i)[1], i, user });
                }
            }

            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < 10 && pq.size() != 0; i++) {
                int[] t = pq.remove();
                res.add(t[1]);
                int j = t[2];
                if (j > 0) {
                    j--;
                    int user = t[3];
                    List<int[]> utweets = tweets.get(user);
                    pq.add(new int[] { utweets.get(j)[0], utweets.get(j)[1], j, user });
                }
            }

            return res;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int x, int y) {
            if (!follows.containsKey(x)) {
                follows.put(x, new HashSet<>());
            }
            follows.get(x).add(y);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int x, int y) {
            // System.out.println(follows);
            if (follows.containsKey(x)) {
                follows.get(x).remove(y);
            }
        }
    }

    /**
     * Your Twitter object will be instantiated and called as such:
     * Twitter obj = new Twitter();
     * obj.postTweet(userId,tweetId);
     * List<Integer> param_2 = obj.getNewsFeed(userId);
     * obj.follow(followerId,followeeId);
     * obj.unfollow(followerId,followeeId);
     */
}
