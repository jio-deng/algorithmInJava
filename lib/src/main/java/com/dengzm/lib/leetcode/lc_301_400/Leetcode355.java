package com.dengzm.lib.leetcode.lc_301_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 355. 设计推特
 * @date 2020/4/13 10:25
 */
public class Leetcode355 {
    class Twitter {
        private int time = 1;
        private Map<Integer, Set<Integer>> map = new HashMap<>();
        private List<Msg> list = new ArrayList<>();

        /** Initialize your data structure here. */
        public Twitter() {
            // do nothing
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            Msg msg = new Msg(time, userId, tweetId);
            list.add(0, msg);
            time ++;
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> ans = new ArrayList<>();

            if (!map.containsKey(userId)) {
                map.put(userId, new HashSet<>());
            }

            int max = 10;
            Set<Integer> set = map.get(userId);
            for (int i = 0; i < list.size(); i ++) {
                Msg msg = list.get(i);
                if (msg.uid == userId || set.contains(msg.uid)) {
                    ans.add(msg.tid);
                    max --;
                    if (max == 0) {
                        break;
                    }
                }
            }

            return ans;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if (!map.containsKey(followerId)) {
                map.put(followerId, new HashSet<>());
            }
            Set<Integer> set = map.get(followerId);
            set.add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if (!map.containsKey(followerId)) {
                map.put(followerId, new HashSet<>());
            }
            Set<Integer> set = map.get(followerId);
            set.remove(followeeId);
        }

        class Msg {
            int time;
            int tid;
            int uid;

            public Msg(int time, int uid, int tid) {
                this.time = time;
                this.tid = tid;
                this.uid = uid;
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
