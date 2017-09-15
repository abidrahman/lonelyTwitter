package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by abidrahman on 2017-09-14.
 */

public abstract class Tweet extends Object implements Tweetable {
    private String text;
    protected Date date;

    private ArrayList<Mood> moods;

    public Tweet(String tweet, Date date, ArrayList<Mood> moods) throws TweetTooLongException {
        this.setText(tweet);
        this.date = date;
        this.moods = moods;
    }

    public Tweet(String tweet, Date date) throws TweetTooLongException {
        this.setText(tweet);
        this.date = date;
    }

    public Tweet(String tweet) throws TweetTooLongException {
        this.setText(tweet);
        this.date = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) throws TweetTooLongException {
        if (text.length() <= 140) {
            this.text = text;
        } else {
            throw new TweetTooLongException();
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Mood> getMoods() {
        return moods;
    }

    public void addMood(Mood mood) {
        this.moods.add(mood);
    }

    public void removeMood(Mood mood) {
        this.moods.remove(mood);
    }

    public abstract Boolean isImportant();

}
