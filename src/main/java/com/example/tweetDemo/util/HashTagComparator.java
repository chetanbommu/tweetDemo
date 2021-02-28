package com.example.tweetDemo.util;

import com.example.tweetDemo.model.HashTagMetaData;

import java.util.Comparator;

public class HashTagComparator implements Comparator<HashTagMetaData> {

    @Override
    public int compare(HashTagMetaData tag1, HashTagMetaData tag2) {
        if(tag1.getCount() == tag2.getCount()) {
            return tag1.getHashTag().compareTo(tag2.getHashTag());
        }
        return tag2.getCount() - tag1.getCount();
    }
}
