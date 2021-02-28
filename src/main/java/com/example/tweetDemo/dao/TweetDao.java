package com.example.tweetDemo.dao;

import com.example.tweetDemo.model.Tweet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TweetDao {

    private List<Tweet> dataStore = new ArrayList<>();
    private Map<String, Integer> lookup = new HashMap<>();

    public void saveTweet(Tweet tweet) {
        dataStore.add(tweet);
        updateLookUp(tweet);
    }

    private void updateLookUp(Tweet tweet) {
        for(String hashTag: tweet.getHashTags()) {
            lookup.put(hashTag.toLowerCase(), lookup.getOrDefault(hashTag.toLowerCase(), 0) + 1);
        }
    }

    public List<Tweet> getDataStore() {
        return dataStore;
    }


    public Map<String, Integer> getLookup() {
        return lookup;
    }
}
