/**
 * NormalTweet class
 *
 * Copyright 2017 Abid Rahman
 *
 * @author arahman1
 * @version 1.0
 * @created 2017-09-27
 */
package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * NormalTweet extends Tweet and is not important.
 */
public class NormalTweet extends Tweet {

    /**
     * Constructor for NormalTweet using a String for tweet
     * and a Data for date.
     * @param tweet
     * @param date
     * @throws TweetTooLongException
     */
    public NormalTweet(String tweet, Date date) throws TweetTooLongException {
        super(tweet, date);
    }

    /**
     * Constructor for NormalTweet using a String for tweet.
     * @param tweet
     * @throws TweetTooLongException
     */
    public NormalTweet(String tweet) throws TweetTooLongException {
        super(tweet);
    }

    /**
     * Setting the importance of the NormalTweet.
     * @return isImportant, always false for normalTweets.
     */
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
