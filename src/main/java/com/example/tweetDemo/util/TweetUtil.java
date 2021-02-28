package com.example.tweetDemo.util;

import com.example.tweetDemo.model.HashTagMetaData;
import com.example.tweetDemo.model.Tweet;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TweetUtil {

    public Tweet constructTweet(String tweetText) {
        Tweet tweet = new Tweet(tweetText);
        setHashTags(tweet);
        return tweet;
    }

    public Map<String, Integer> getTop10TweetTrends(Map<String, Integer> lookupData) {
        Map<String, Integer> result = new LinkedHashMap<>();
        PriorityQueue<HashTagMetaData> maxHeap = new PriorityQueue<>(new HashTagComparator());
        for(Map.Entry<String, Integer> entry: lookupData.entrySet()) {
            HashTagMetaData hashTagMetaData = new HashTagMetaData(entry.getKey(), entry.getValue());
            maxHeap.add(hashTagMetaData);
        }

        for(int index = 0; index < 10 && index < lookupData.size(); index++) {
            HashTagMetaData hashTagMetaData = maxHeap.poll();
            result.put(hashTagMetaData.getHashTag(), hashTagMetaData.getCount());
        }

        return result;
    }

    private void setHashTags(Tweet tweet) {
        Set<String> hashTags = getHashTags(tweet.getTweetText());
        tweet.setHashTags(hashTags);
    }

    private Set<String> getHashTags(String tweetText) {
        Set<String> hashTags = new HashSet<>();
        tweetText = cleanString(tweetText);
        StringTokenizer stringTokenizer = new StringTokenizer(tweetText, " ");
        while(stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            if(token.startsWith("#")) {
                token = token.substring(1, token.length()).toLowerCase();
                hashTags.add(token);
            }
        }
        return hashTags;
    }

    private String cleanString(String tweetText) {
        String cleansedTweetText = "";
        for(char character: tweetText.toCharArray()) {
            if(character == '.' || character == ',' || character == '!' || character == '?' || character == '&')
                cleansedTweetText += ' ';
            else
                cleansedTweetText += character;
        }
        return cleansedTweetText;
    }
}
