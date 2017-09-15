package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by abidrahman on 2017-09-14.
 */

public class NormalTweet extends Tweet {
    public NormalTweet(String tweet, Date date) throws TweetTooLongException {
        super(tweet, date);
    }

    public NormalTweet(String tweet) throws TweetTooLongException {
        super(tweet);
    }

    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
