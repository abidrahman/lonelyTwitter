package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by abidrahman on 2017-10-12.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest(){
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");
        tweets.add(tweet);
        try {
            tweets.add(tweet);
            fail();
        } catch (IllegalArgumentException e) {}
    }

    public void testDelete(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        list.delete(tweet);
        assertFalse(list.hasTweet(tweet));
    }

    public void testGetCount() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        Tweet tweet1 = new NormalTweet("test1");
        Tweet tweet2 = new NormalTweet("test2");
        list.add(tweet);
        list.add(tweet1);
        list.add(tweet2);

        assertTrue(list.getCount() == 3);
    }

    public void testGetTweets(){
        TweetList tweets = new TweetList(); //
        Tweet tweet = new NormalTweet("test1", new Date(2016, 1, 1));
        Tweet tweet1 = new NormalTweet("test1", new Date(2015, 1, 1));
        Tweet tweet2 = new NormalTweet("test1", new Date(2014, 1, 1));
        tweets.add(tweet);
        tweets.add(tweet1);
        tweets.add(tweet2);
        ArrayList<Tweet> returnedTweet = tweets.getTweets();

        Date prev_date = tweet2.getDate();
        Tweet tweet_compare = returnedTweet.remove(0);
        assertTrue(0 == prev_date.compareTo(tweet_compare.getDate()));

        prev_date = tweet1.getDate();
        tweet_compare = returnedTweet.remove(0);
        assertTrue(0 == prev_date.compareTo(tweet_compare.getDate()));

        prev_date = tweet.getDate();
        tweet_compare = returnedTweet.remove(0);
        assertTrue(0 == prev_date.compareTo(tweet_compare.getDate()));

    }

    public void testHasTweet(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }
}

