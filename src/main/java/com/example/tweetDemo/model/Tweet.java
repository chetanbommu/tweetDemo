package com.example.tweetDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class Tweet {

    private String tweetText;
    private Set<String> hashTags;

    public Tweet(String tweetText) {
        this.tweetText = tweetText;
    }
}
