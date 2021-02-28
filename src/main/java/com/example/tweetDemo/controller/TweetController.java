package com.example.tweetDemo.controller;

import com.example.tweetDemo.model.Tweet;
import com.example.tweetDemo.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @PostMapping("/tweet")
    public Map<String, Integer> addNewTweet(@RequestBody String tweet) {
        return tweetService.addNewTweet(tweet);
    }

    @GetMapping("/tweet/trends")
    public Map<String, Integer> fetchTweetTrends() {
        return tweetService.getTopTweetTrends();
    }

    @GetMapping("/tweet/hashtags")
    public Map<String, Integer> fetchAllHashTags() {
        return tweetService.getAllHashTags();
    }

    @GetMapping("/tweets")
    public List<Tweet> getAllTweets() {
        return tweetService.getAllTweets();
    }
}
