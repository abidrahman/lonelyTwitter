/**
 * Tweet class
 *
 * Copyright 2017 Abid Rahman
 *
 * @author arahman1
 * @version 1.0
 * @created 2017-09-27
 */
package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * The Tweet abstract class uses a text and a date to represent a Tweet.
 * All Tweet classes must extend this class.
 */
public abstract class Tweet extends Object implements Tweetable {
    private String text;
    protected Date date;

    private ArrayList<Mood> moods;

    /**
     * Constructor for Tweet with a String for tweet and a Date for date
     * and list of moods.
     * @param tweet
     * @param date
     * @param moods, list of moods to add to the tweet.
     * @throws TweetTooLongException
     */
    public Tweet(String tweet, Date date, ArrayList<Mood> moods) throws TweetTooLongException {
        this.setText(tweet);
        this.date = date;
        this.moods = moods;
    }

    /**
     * Constructor for Tweet with a String for tweet and a Date for date.
     * @param tweet
     * @param date
     * @throws TweetTooLongException
     */
    public Tweet(String tweet, Date date) throws TweetTooLongException {
        this.setText(tweet);
        this.date = date;
    }

    /**
     * Constructor for Tweet with a String for tweet.
     * @param tweet
     * @throws TweetTooLongException
     */
    public Tweet(String tweet) throws TweetTooLongException {
        this.setText(tweet);
        this.date = new Date();
    }

    /**
     * Get Tweet's text.
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Set Tweet's String, check for max text length.
     * @param text
     */
    public void setText(String text) throws TweetTooLongException {
        if (text.length() <= 140) {
            this.text = text;
        } else {
            throw new TweetTooLongException();
        }
    }

    /**
     * Get Tweet's date.
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set Tweet's date.
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Get Tweet's list of moods.
     * @return moods
     */
    public ArrayList<Mood> getMoods() {
        return moods;
    }

    /**
     * Add a mood to the Tweet's list of moods.
     * @param mood
     */
    public void addMood(Mood mood) {
        this.moods.add(mood);
    }

    /**
     * Remove a mood from the Tweet's list of moods.
     * @param mood
     */
    public void removeMood(Mood mood) {
        this.moods.remove(mood);
    }

    /**
     * Function declaration to determine if tweet is important.
     * @return isImportant (TRUE or FALSE)
     */
    public abstract Boolean isImportant();

    /**
     * Returns string representation of the Tweet.
     * @return string
     */
    @Override
    public String toString(){
        return date.toString() + " | " + text;
    }

}
