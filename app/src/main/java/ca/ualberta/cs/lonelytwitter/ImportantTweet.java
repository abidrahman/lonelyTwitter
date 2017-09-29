/**
 * ImportantTweet class
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
 * ImportantTweet is a subclass of the abstract Tweet class
 * that is deemed to be important.
 */
public class ImportantTweet extends Tweet {

    /**
     * Constructor for ImportantTweet, creates an instance of the
     * ImportantTweet class using a String and a date.
     * @param tweet
     * @param date
     * @throws TweetTooLongException
     */
    public ImportantTweet(String tweet, Date date) throws TweetTooLongException {
        super(tweet, date);
        this.setText(tweet);
        this.date = date;
    }

    /**
     * Constructor for ImportantTweet, creates an instance of the
     * ImportantTweet class using a String.
     * @param tweet
     * @throws TweetTooLongException
     */
    public ImportantTweet(String tweet) throws TweetTooLongException {
        super(tweet);
    }

    /**
     * Setting the importance of the ImportantTweet.
     * @return isImportant, always true for importantTweets
     */
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    /**
     * Fetch the text that makes up the tweet.
     * @return tweet text
     */
    @Override
    public String getText() {
        return "!!!" + super.getText();
    }

}
