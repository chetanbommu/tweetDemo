package com.example.tweetDemo.service;

import com.example.tweetDemo.dao.TweetDao;
import com.example.tweetDemo.model.Tweet;
import com.example.tweetDemo.util.TweetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TweetService {

    @Autowired
    private TweetDao tweetDao;

    @Autowired
    private TweetUtil tweetUtil;

    public Map<String, Integer> addNewTweet(String tweetText) {
        Tweet tweet = tweetUtil.constructTweet(tweetText);
        tweetDao.saveTweet(tweet);
        return getTopTweetTrends();
    }

    public Map<String, Integer> getTopTweetTrends() {
        Map<String, Integer> lookupData = tweetDao.getLookup();
        return tweetUtil.getTop10TweetTrends(lookupData);
    }

    public List<Tweet> getAllTweets() {
        return tweetDao.getDataStore();
    }

    public Map<String, Integer> getAllHashTags() {
        return tweetDao.getLookup();
    }
}
