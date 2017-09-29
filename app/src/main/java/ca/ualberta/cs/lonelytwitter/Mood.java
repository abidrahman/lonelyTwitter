/**
 * Mood class
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
 * The Mood abstract class represents a mood. This
 * class must be extended whenever a new mood class is
 * created.
 */
public abstract class Mood {
    private Date date;

    /**
     * Mood constructor that receives a date.
     * @param date
     */
    public Mood(Date date) {
        this.date = date;
    }

    /**
     * Mood constructor that sets the date to
     * a default date.
     */
    public Mood() {
        this.date = new Date();
    }

    /**
     * Get the date of the mood.
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set the date of the mood.
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

}
