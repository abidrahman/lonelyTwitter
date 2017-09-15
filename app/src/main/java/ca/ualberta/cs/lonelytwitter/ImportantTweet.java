package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by abidrahman on 2017-09-14.
 */

public class ImportantTweet extends Tweet {
    public ImportantTweet(String tweet, Date date) throws TweetTooLongException {
        super(tweet, date);
        this.setText(tweet);
        this.date = date;
    }

    public ImportantTweet(String tweet) throws TweetTooLongException {
        super(tweet);
    }

    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    @Override
    public String getText() {
        return "!!!" + super.getText();
    }

}
