package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by abidrahman on 2017-09-14.
 */

public abstract class Mood {
    private Date date;

    //Constructor with date argument
    public Mood(Date date) {
        this.date = date;
    }

    //Constructor with default date
    public Mood() {
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
